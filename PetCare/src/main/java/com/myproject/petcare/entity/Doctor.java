package com.myproject.petcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Doctor {
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-Increment the ID
    private Long id;
    private String registrationNo;
    private String specialization;
    private int experience;
    private String location;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

}
