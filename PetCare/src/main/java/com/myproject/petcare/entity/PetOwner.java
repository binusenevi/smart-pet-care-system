package com.myproject.petcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "pet_owner")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String nic;
    private String contactNo;
    private String location;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "petOwner", cascade = CascadeType.ALL)
    private List<Pet> pets;
}