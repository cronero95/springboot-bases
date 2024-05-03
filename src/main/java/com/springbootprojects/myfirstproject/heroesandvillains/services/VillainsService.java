package com.springbootprojects.myfirstproject.heroesandvillains.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootprojects.myfirstproject.heroesandvillains.models.VillainModel;

@Service
public class VillainsService implements IVillainsService {

    @Override
    public List<String> saveVillains(List<VillainModel> villains) {

        List<String> villainsResponse = new ArrayList<>();

        villainsResponse.add("Saving in database...");
        for (VillainModel villain : villains) {
            villainsResponse.add(
                "The villain "+villain.villainName+" was saved."
            );
        }

        return villainsResponse;
    }
}
