package com.springbootprojects.myfirstproject.heroesandvillains.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootprojects.myfirstproject.HeroDto;
import com.springbootprojects.myfirstproject.HeroResponseDto;
import com.springbootprojects.myfirstproject.HeroService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("heroes")
public class HeroesController {

    private final HeroService heroService;

    public HeroesController(
        HeroService heroService
    ) {
        this.heroService = heroService;
    }

    @GetMapping()
    public List<HeroResponseDto> findAllHeroes() {
        return heroService.findAllHeroes();
    }

    @GetMapping("id/{heroe-id}")
    public HeroResponseDto findHeroeById(
        @PathVariable("heroe-id") Integer id
    ) {
        return heroService.findHeroeById(id);
    }
    
    @PostMapping()
    public HeroResponseDto createHero(
        @RequestBody HeroDto heroDto
    ) {
        return heroService.createHero(heroDto);
    }
    
    @DeleteMapping("id/{hero-id}")
    public String deleteHeroById(
        @PathVariable("hero-id") Integer id
    ) {
        return heroService.deleteHeroById(id);
    }
}
