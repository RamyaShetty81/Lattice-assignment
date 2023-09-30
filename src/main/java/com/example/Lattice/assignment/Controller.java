package com.example.Lattice.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portal")

public class Controller {
    @Autowired
    Services service;

    @PostMapping("/add-patient")
    public ResponseEntity addPatient(@RequestBody Patient patient)
    {
        return new ResponseEntity<>(service.addPatient(patient), HttpStatus.CREATED);
    }

    @DeleteMapping("/remove-patient/{patientId}")
    public ResponseEntity removePatient(@RequestParam Integer patientId)
    {
        return new ResponseEntity(service.removePatient(patientId),HttpStatus.ACCEPTED);
    }


    @GetMapping("/{patientId}")
    public ResponseEntity suggestDoctor(@RequestParam Integer patientId)
    {

        Patient patient = service.getPatientById(patientId);
        City city = patient.getCity();
        if(city!= City.Faridabad && city!= City.Noida && city!= City.Delhi) {
            return new ResponseEntity<>("We are still waiting to expand to your location",HttpStatus.BAD_REQUEST);
        }
        try {
            List<Doctor> doctorList = service.suggestDoctor(patientId);
            return new ResponseEntity(doctorList, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("There isn’t any doctor present at your location for your symptom",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add-doctor")
    public ResponseEntity addDoctor(@RequestBody Doctor doctor)
    {
        return new ResponseEntity<>(service.addDoctor(doctor), HttpStatus.CREATED);
    }

    @DeleteMapping("/remove-doctor/{doctorId}")
    public ResponseEntity removeDoctor(@RequestParam Integer doctorId)
    {
        return new ResponseEntity(service.removeDoctor(doctorId),HttpStatus.ACCEPTED);
    }
}
