package com.myproject.petcare.service;

import com.myproject.petcare.entity.Pet;
import com.myproject.petcare.repository.PetRepository;
import com.myproject.petcare.repository.PetOwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;
    private final PetOwnerRepository petOwnerRepository;


    public Pet savePet(Pet pet) {
        if (pet.getPetOwner() != null && pet.getPetOwner().getId() != null) {
            return petRepository.save(pet);
        }
        throw new RuntimeException("Pet Owner ID is required!");
    }


    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }


    public Pet getPetById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found with id: " + id));
    }


    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }
}