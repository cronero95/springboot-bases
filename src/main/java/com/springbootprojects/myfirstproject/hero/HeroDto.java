package com.springbootprojects.myfirstproject.hero;

import jakarta.validation.constraints.NotBlank;

public record HeroDto(

    @NotBlank(message = "Name can't be empty.")
    String name,

    @NotBlank(message = "City can't be empty.")
    String city,

    Integer publisherId
) { }
