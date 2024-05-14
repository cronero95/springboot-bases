package com.springbootprojects.myfirstproject;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "villains")
public class Villain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(
        name = "villain_name", length = 50, 
        nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(
        name = "publisher_id", referencedColumnName = "id"
    )
    @JsonBackReference
    private Publisher publisher;

    @OneToOne
    @JoinColumn(
        name = "hero_id", referencedColumnName = "id"
    )
    @JsonBackReference
    private Hero hero;

    public Villain() {}

    public Integer getId() { return id; }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }

    public Publisher getPublisher() { return publisher; }
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Hero getHero() { return hero; }
    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
