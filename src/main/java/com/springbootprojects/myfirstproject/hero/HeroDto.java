package com.springbootprojects.myfirstproject.hero;

public record HeroDto(
    String name,
    String city,
    Integer publisherId
) { }
