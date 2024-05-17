package com.springbootprojects.myfirstproject.heroesandvillains.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootprojects.myfirstproject.VillainDto;
import com.springbootprojects.myfirstproject.VillainResponseDto;
import com.springbootprojects.myfirstproject.VillainService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("villains")
public class VillainsController {

    private final VillainService villainService;

    public VillainsController(
        VillainService villainService
    ) {
        this.villainService = villainService;
    }

    @GetMapping()
    public List<VillainResponseDto> findAllVillains() {
        return villainService.findAllVillains();
    }
    
    @GetMapping("id/{villain-id}")
    public VillainResponseDto findVillainById(
        @PathVariable("villain-id") Integer id
    ) {
        return villainService.findVillainById(id);
    }
    
    @PostMapping()
    public VillainResponseDto createVillain(@RequestBody VillainDto villainDto) {
        return villainService.createVillain(villainDto);
    }
    
    @DeleteMapping("id/{villain-id}")
    public String deleteVillainById(
        @PathVariable("villain-id") Integer id
    ) {
        return villainService.deleteVillainById(id);
    }
}
