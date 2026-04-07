package com.myproject.petcare.entity;

import com.myproject.petcare.entity.Pet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrowthRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double height;
    private Double weight;

    @Column(name = "recorded_date")
    private String recordedDate;

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
}