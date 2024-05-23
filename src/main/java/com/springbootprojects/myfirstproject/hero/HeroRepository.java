package com.springbootprojects.myfirstproject.hero;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Integer> {
    List<Hero> findAllByNameContaining(String name);
}
