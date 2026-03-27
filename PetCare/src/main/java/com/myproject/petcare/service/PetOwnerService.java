package com.myproject.petcare.service;

import com.myproject.petcare.entity.PetOwner;
import com.myproject.petcare.repository.PetOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetOwnerService {

    @Autowired
    private PetOwnerRepository petOwnerRepository;


    public PetOwner savePetOwner(PetOwner petOwner) {
        return petOwnerRepository.save(petOwner);
    }


    public List<PetOwner> getAllPetOwners() {
        return petOwnerRepository.findAll();
    }

    public PetOwner getPetOwnerById(Long id) {
        return petOwnerRepository.findById(id).orElse(null);
    }


    public void deletePetOwner(Long id) {
        petOwnerRepository.deleteById(id);
    }
}