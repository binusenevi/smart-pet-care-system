package com.myproject.petcare.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "pet_owner")
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

    // Default Constructor
    public PetOwner() {
    }

    // Getters and Setters (අතින් ලිවීම වඩාත් සුදුසුයි)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getNic() { return nic; }
    public void setNic(String nic) { this.nic = nic; }

    public String getContactNo() { return contactNo; }
    public void setContactNo(String contactNo) { this.contactNo = contactNo; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<Pet> getPets() { return pets; }
    public void setPets(List<Pet> pets) { this.pets = pets; }
}