package com.springbootprojects.myfirstproject.heroesandvillains.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootprojects.myfirstproject.Hero;
import com.springbootprojects.myfirstproject.HeroRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("heroes")
public class HeroesController {

    private final HeroRepository heroeRepository;

    public HeroesController(
        HeroRepository heroeRepository
    ) {
        this.heroeRepository = heroeRepository;
    }

    @GetMapping()
    public List<Hero> findAllHeroes() {
        return heroeRepository.findAll();
    }
    

    @GetMapping("id/{heroe-id}")
    public Hero findHeroeById(
        @PathVariable("heroe-id") Integer id
    ) {
        return heroeRepository.findById(id)
            .orElse(null);
    }
    
    @PostMapping()
    public Hero createHero(@RequestBody Hero heroe) {
        return heroeRepository.save(heroe);
    }
    
    @DeleteMapping("id/{hero-id}")
    public String deleteHeroById(
        @PathVariable("hero-id") Integer id
    ) {
        heroeRepository.deleteById(id);
        return "The Hero with id: "+id+" was deleted";
    }
}
