package com.example.Lattice.assignment;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctor")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer doctorID;

    String name;

    @Enumerated(EnumType.STRING)
    City city;

    String email;

    @Column(unique = true,nullable = false)
    String phoneNo;

    @Enumerated(EnumType.STRING)
    Speciality speciality;
}
