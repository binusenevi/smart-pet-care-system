package com.myproject.petcare.controller;

import com.myproject.petcare.entity.Pet;
import com.myproject.petcare.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping("/save")
    public Pet savePet(@RequestBody Pet pet) {
        return petService.savePet(pet);
    }

    @GetMapping("/all")
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }
}