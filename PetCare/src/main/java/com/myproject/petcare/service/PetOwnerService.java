package com.myproject.petcare.service;

import com.myproject.petcare.entity.PetOwner;
import com.myproject.petcare.repository.PetOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetOwnerService {

    @Autowired
    private PetOwnerRepository petOwnerRepository;

    public PetOwner savePetOwner(PetOwner petOwner) {
        return petOwnerRepository.save(petOwner);
    }
}