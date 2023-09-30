package com.example.Lattice.assignment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    List<Doctor> findByCity(City city);
    List<Doctor> findByCityAndSpeciality(City city,Speciality speciality);
}
