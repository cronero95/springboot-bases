package com.springbootprojects.myfirstproject.heroesandvillains.services;

import java.util.List;

import com.springbootprojects.myfirstproject.heroesandvillains.models.VillainModel;

public interface IVillainsService {
    public List<String> saveVillains(List<VillainModel> villains);
}
