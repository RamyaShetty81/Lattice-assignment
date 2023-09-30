package com.example.Lattice.assignment;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service

public interface Services {

    public String addPatient(Patient patient);
    public String removePatient(Integer patientId);
    public List<Doctor> suggestDoctor(Integer patientId);
    public String addDoctor(Doctor doctor);
    public String removeDoctor(Integer doctorId);
    public Patient getPatientById(Integer patientId);
}
