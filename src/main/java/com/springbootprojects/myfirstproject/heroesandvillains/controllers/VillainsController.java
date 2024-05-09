package com.springbootprojects.myfirstproject.heroesandvillains.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springbootprojects.myfirstproject.heroesandvillains.models.VillainModel;
import com.springbootprojects.myfirstproject.records.VillainRecord;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("villains")
public class VillainsController {

    @GetMapping()
    public VillainModel getVillain() {
        return new VillainModel(
            "Joker", "Batman", 100
        );
        
    }
    
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public VillainRecord createVillain(
        @RequestBody VillainRecord villain
    ) {
        return villain;
    }
    
    @GetMapping("marvel/{name}")
    public VillainModel getMarvelVillain(
        @PathVariable("name") String villainName
    ) {
        if (villainName.equals("magneto")) {
            return new VillainModel(
                "Magneto", "X-Men", 320
            );
        } else if (villainName.equals("loki")) {
            return new VillainModel(
                "Loki", "Thor", 300
            );
        } else {
            return new VillainModel(
                "Unknown", "Unknown", 0
            );
        }
    }
    
    @GetMapping("marvel")
    public VillainModel postMethodName(
        @RequestParam("name") String villainName
    ) {
        if (villainName.equals("magneto")) {
            return new VillainModel(
                "Magneto", "X-Men", 320
            );
        } else if (villainName.equals("loki")) {
            return new VillainModel(
                "Loki", "Thor", 300
            );
        } else {
            return new VillainModel(
                "Unknown", "Unknown", 0
            );
        }
    }
    
}
