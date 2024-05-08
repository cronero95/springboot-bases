package com.springbootprojects.myfirstproject.heroesandvillains.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springbootprojects.myfirstproject.heroesandvillains.models.HeroModel;
import com.springbootprojects.myfirstproject.heroesandvillains.services.IHeroesService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("heroes")
public class HeroesController {

    private final IHeroesService heroesService;

    public HeroesController(
        IHeroesService heroesService
    ) {
        this.heroesService = heroesService;
    }

    @GetMapping()
    public HeroModel getHero() {
        return new HeroModel("Batman", "Bruce Wayne");
        
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public List<String> saveHeroes(
        @RequestBody List<HeroModel> heroes
    ) {
        return heroesService.saveHeroes(heroes);
    }

    @PatchMapping("/{id}")
    public String editHero(
        @RequestBody HeroModel hero,
        @PathVariable int id
    ) {
        return "Hero "+id+" edited";
    }
    
}
