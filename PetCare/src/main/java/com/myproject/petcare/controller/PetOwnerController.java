package com.myproject.petcare.controller;

import com.myproject.petcare.entity.PetOwner;
import com.myproject.petcare.service.PetOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/petowners")
public class PetOwnerController {

    @Autowired
    private PetOwnerService petOwnerService;

    @PostMapping("/save")
    public PetOwner savePetOwner(@RequestBody PetOwner petOwner) {
        return petOwnerService.savePetOwner(petOwner);
    }
}