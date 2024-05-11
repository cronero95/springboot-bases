package com.springbootprojects.myfirstproject.heroesandvillains.dtos;

public class VillainDto {
    private String villainName, villainEnemy;
    private int villainPower;

    public String getVillainName() { return villainName; }
    public void setVillainName(String villainName) {
        this.villainName = villainName;
    }

    public String getVillainEnemy() { return villainEnemy; }
    public void setVillainEnemy(String villainEnemy) {
        this.villainEnemy = villainEnemy;
    }

    public int getVillainPower() { return villainPower; }
    public void setVillainPower(int villainPower) {
        this.villainPower = villainPower;
    }

    @Override
    public String toString() {
        return "VillainDto [villainName=" + villainName + 
            ", villainEnemy=" + villainEnemy + 
            ", villainPower=" + villainPower + "]";
    }
}
