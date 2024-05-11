package com.springbootprojects.myfirstproject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="heroes")
public class Heroe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "heroe_name", length = 50, nullable = false, unique = true)
    private String name;

    @Column(name = "heroe_city", length = 50, nullable = false)
    private String city;

    @Column(name = "heroe_publisher", length = 50, nullable = false)
    private String publisher;

    public Heroe() {}

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

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
