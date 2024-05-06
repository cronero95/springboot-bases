package com.springbootprojects.myfirstproject.heroesandvillains.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.springbootprojects.myfirstproject.heroesandvillains.models.HeroModel;

@Service
public class HeroesService implements IHeroesService {

    @Value("${myurls.heroes.production-database}")
    public String heroesDatabase;

    @Override
    public List<String> saveHeroes(List<HeroModel> heroes) {

        List<String> heroesResponse = new ArrayList<>();

        heroesResponse.add("Saving in database...");
        for (HeroModel hero : heroes) {
            heroesResponse.add(
                "The hero "+hero.heroName+" was saved."
            );
        }
        heroesResponse.add(heroesDatabase);

        return heroesResponse;
    }
}
