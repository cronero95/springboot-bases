package com.springbootprojects.myfirstproject.heroesandvillains.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VillainModel {
    @JsonProperty("name")
    public String villainName;

    @JsonProperty("enemy")
    public String villainEnemy;

    public VillainModel(String villainName, String villainEnemy) {
        this.villainName = villainName;
        this.villainEnemy = villainEnemy;
    }
}
