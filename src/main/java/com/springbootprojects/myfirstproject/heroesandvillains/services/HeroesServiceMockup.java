package com.springbootprojects.myfirstproject.heroesandvillains.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootprojects.myfirstproject.heroesandvillains.models.HeroModel;

@Service
public class HeroesServiceMockup implements IHeroesService {

    @Override
    public List<String> saveHeroes(List<HeroModel> heroes) {

        List<String> heroesResponse = new ArrayList<>();

        heroesResponse.add("Saving in local database...");
        for (HeroModel hero : heroes) {
            heroesResponse.add(
                "The hero "+hero.heroName+" was saved."
            );
        }

        return heroesResponse;
    }

}
