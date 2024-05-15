package com.springbootprojects.myfirstproject;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "publisher_name", length = 50, 
        nullable = false, unique = true)
    private String name;

    @Column(name = "publisher_foundation", 
        length = 50, nullable = false)
    private String foundationYear;

    @OneToMany(
        mappedBy = "publisher"
    )
    @JsonManagedReference
    private List<Hero> heroes;

    @OneToMany(
        mappedBy = "publisher"
    )
    @JsonManagedReference(
        value = "publisher_ref"
    )
    private List<Villain> villains;

    public Publisher() {}

    public Integer getId() { return id; }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }

    public String getFoundationYear() {return foundationYear;}
    public void setFoundationYear(String foundationYear) {
        this.foundationYear = foundationYear;
    }

    public List<Hero> getHeroes() { return heroes;}
    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public List<Villain> getVillains() { return villains; }
    public void setVillains(List<Villain> villains) {
        this.villains = villains;
    }
}
