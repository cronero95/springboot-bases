package com.springbootprojects.myfirstproject.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class HeroServiceTest {

    @InjectMocks
    private HeroService heroService;

    @Mock
    private HeroRepository heroRepository;
    @Mock
    private HeroMapper heroMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_succesfully_create_a_hero() {

        HeroDto heroDto = new HeroDto(
            "Wonder Woman",
            "Themyscira",
            2
        );

        Hero hero = new Hero();
        hero.setName("Wonder Woman");
        hero.setCity("Themyscira");

        Hero savedHero = new Hero();
        savedHero.setName("Wonder Woman");
        savedHero.setCity("Themyscira");
        savedHero.setId(1);

        HeroResponseDto heroResponseDto = new HeroResponseDto(
            "Wonder Woman",
            "Themyscira"
        );
    }
}
