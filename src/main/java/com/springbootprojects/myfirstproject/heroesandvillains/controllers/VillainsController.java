package com.springbootprojects.myfirstproject.heroesandvillains.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootprojects.myfirstproject.Villain;
import com.springbootprojects.myfirstproject.VillainRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("villains")
public class VillainsController {

    private final VillainRepository villainRepository;

    public VillainsController(VillainRepository villainRepository) {
        this.villainRepository = villainRepository;
    }

    @GetMapping()
    public List<Villain> findAllVillains() {
        return villainRepository.findAll();
    }
    
    @GetMapping("id/{villain-id}")
    public Villain findVillainById(
        @PathVariable("villain-id") Integer id
    ) {
        return villainRepository.findById(id)
            .orElse(null);
    }
    
    @PostMapping()
    public Villain createVillain(@RequestBody Villain villain) {
        return villainRepository.save(villain);
    }
    
    @DeleteMapping("id/{villain-id}")
    public String deleteVillainById(
        @PathVariable("villain-id") Integer id
    ) {
        villainRepository.deleteById(id);
        return "The villain with id: "+id+" was deleted";
    }
}
