package com.springbootprojects.myfirstproject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroeRepository extends JpaRepository<Heroe, Integer> {
    List<Heroe> findAllByPublisherContaining(String publisher);
}
