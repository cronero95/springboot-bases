package com.springbootprojects.myfirstproject;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
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
@Table(name="heroes")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(
        name = "hero_name", length = 50, 
        nullable = false, unique = true)
    private String name;

    @Column(
        name = "hero_city", length = 50, 
        nullable = false)
    private String city;

    @OneToOne(
        mappedBy = "hero",
        cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private Villain villain;

    @ManyToOne
    @JoinColumn(
        name = "publisher_id", referencedColumnName = "id"
    )
    @JsonBackReference
    private Publisher publisher;

    public Hero() {}

    public Integer getId() { return id; }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }

    public String getCity() { return city; }
    public void setCity(String city) {
        this.city = city;
    }

    public Publisher getPublisher() { return publisher;}
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Villain getVillain() { return villain; }
    public void setVillain(Villain villain) {
        this.villain = villain;
    }
}
