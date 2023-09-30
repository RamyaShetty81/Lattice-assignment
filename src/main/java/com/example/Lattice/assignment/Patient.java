package com.example.Lattice.assignment;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctor")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer patientId;

    String name;

    @Enumerated(EnumType.STRING)
    City city;

    String email;

    @Column(unique = true,nullable = false)
    String phoneNo;

    @Enumerated(EnumType.STRING)
    Symptom symptom;
}
