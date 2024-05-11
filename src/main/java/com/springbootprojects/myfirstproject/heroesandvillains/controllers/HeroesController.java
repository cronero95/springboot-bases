package com.springbootprojects.myfirstproject.heroesandvillains.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootprojects.myfirstproject.Heroe;
import com.springbootprojects.myfirstproject.HeroeRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;






@RestController
@RequestMapping("heroes")
public class HeroesController {

    private final HeroeRepository heroeRepository;

    public HeroesController(
        HeroeRepository heroeRepository
    ) {
        this.heroeRepository = heroeRepository;
    }

    @GetMapping()
    public List<Heroe> findAllHeroes() {
        return heroeRepository.findAll();
    }
    

    @GetMapping("id/{heroe-id}")
    public Heroe findHeroeById(
        @PathVariable("heroe-id") Integer id
    ) {
        return heroeRepository.findById(id)
            .orElse(null);
    }
    
    @PostMapping()
    public Heroe createHero(@RequestBody Heroe heroe) {
        return heroeRepository.save(heroe);
    }
    
    @GetMapping("publisher/{publisher}")
    public List<Heroe> findHeroesByPublisher(
        @PathVariable String publisher
    ) {
        return heroeRepository.findAllByPublisherContaining(publisher);
    }
    
    @DeleteMapping("id/{hero-id}")
    public String deleteHeroById(
        @PathVariable("hero-id") Integer id
    ) {
        heroeRepository.deleteById(id);
        return "The Hero with id: "+id+" was deleted";
    }
}
