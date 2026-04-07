package com.myproject.petcare.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age;
    private String breed;
    private String name;

    @Column(name = "species")
    private String species;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private PetOwner petOwner;
}