package com.springbootprojects.myfirstproject.heroesandvillains.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootprojects.myfirstproject.heroesandvillains.models.HeroModel;
import com.springbootprojects.myfirstproject.heroesandvillains.services.IHeroesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("heroes")
public class HeroesController {

    private final IHeroesService heroesService;

    @Value("${myurls.heroes.production-database}")
    private String databaseUrl;

    @Value("#{${heroes.heroes-list}}")
    private List<String> batman;

    public HeroesController(
        IHeroesService heroesService
    ) {
        this.heroesService = heroesService;
    }

    @GetMapping("search")
    public HeroModel getHero(@RequestParam String hero) {
        if (hero.equals("batman")) {
            return new HeroModel("Batman", "Bruce Wayne");
        } else {
            throw new IllegalArgumentException("Hero not found.");
        }
    }

    @PostMapping("save")
    public List<String> saveHeroes(@RequestBody List<HeroModel> heroes) {
        return heroesService.saveHeroes(heroes);
    }
    
}
