package com.springbootprojects.myfirstproject.heroesandvillains.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootprojects.myfirstproject.heroesandvillains.models.VillainModel;
import com.springbootprojects.myfirstproject.records.VillainRecord;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("villains")
public class VillainsController {

    @GetMapping()
    public VillainModel getVillain() {
        return new VillainModel("Joker", "Batman");
        
    }
    
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public VillainRecord createVillain(
        @RequestBody VillainRecord villain
    ) {
        return villain;
    }
    
}
