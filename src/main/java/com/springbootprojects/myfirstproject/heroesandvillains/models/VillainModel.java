package com.springbootprojects.myfirstproject.heroesandvillains.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VillainModel {
    @JsonProperty("name")
    public String villainName;

    @JsonProperty("enemy")
    public String villainEnemy;

    public int power;

    public VillainModel(
        String villainName,
        String villainEnemy,
        int power
    ) {
        this.villainName = villainName;
        this.villainEnemy = villainEnemy;
        this.power = power;
    }
}
