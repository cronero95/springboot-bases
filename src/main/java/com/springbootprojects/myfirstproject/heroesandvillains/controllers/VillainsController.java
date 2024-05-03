package com.springbootprojects.myfirstproject.heroesandvillains.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootprojects.myfirstproject.heroesandvillains.models.VillainModel;
import com.springbootprojects.myfirstproject.heroesandvillains.services.IVillainsService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("villains")
public class VillainsController {

    private IVillainsService villainsService;

    public VillainsController(IVillainsService villainsService) {
        this.villainsService = villainsService;
    }

    @GetMapping("search")
    public VillainModel getVillain(@RequestParam String villain) {
        if (villain.equals("joker")) {
            return new VillainModel("Joker", "Batman");
        } else {
            throw new IllegalArgumentException("Villain not found.");
        }
    }
    
    @PostMapping("save")
    public List<String> saveVillains(@RequestBody List<VillainModel> villains) {
        return villainsService.saveVillains(villains);
    }
    
}
