package com.example.Lattice.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service

public class ServiceImplementations implements Services {
    @Autowired
    DoctorRepository doctorRepository;


    @Autowired
    PatientRepository patientRepository;

    @Override
    public String addPatient(Patient patient) {
        patientRepository.save(patient);
        return "Patient added successfully!!!";
    }

    @Override
    public String removePatient(Integer patientId) {
        Patient patient = patientRepository.findById(patientId).get();
        if(patient == null) return "Invalid Patient ID";
        else {
            patientRepository.delete(patient);
            return "Patient removed Successfully";
        }
    }

    @Override
    public List<Doctor> suggestDoctor(Integer patientId) {
        //getting patient symptom and city
        Patient patient = patientRepository.findById(patientId).get();
        String symptom = String.valueOf(patient.getSymptom());
        City city = patient.getCity();

        Speciality speciality;
            if (symptom.equals("Arthritis") || symptom.equals("BackPain") || symptom.equals("TissueInjuries"))
                speciality = Speciality.Orthopedic;
            else if (symptom.equals("Dysmenorrhea")) speciality = Speciality.Gynecology;
            else if (symptom.equals("SkinInfection") || symptom.equals("skinBurn")) speciality = Speciality.Dermatology;
            else speciality = Speciality.ENT;

            List<Doctor> doctorList = doctorRepository.findByCityAndSpeciality(city,speciality);

            return doctorList;

    }

    @Override
    public String addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
        return "Doctor added succesfully";
    }

    @Override
    public String removeDoctor(Integer doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).get();

            if(doctor == null) return "Doctor ID is not found";
            else
            {
                doctorRepository.delete(doctor);
                return "Doctor removed Successfully!!!";
            }
    }

    public Patient getPatientById(Integer patientId)
    {
        return patientRepository.findById(patientId).get();
    }
}
