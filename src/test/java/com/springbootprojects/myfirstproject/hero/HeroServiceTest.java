package com.springbootprojects.myfirstproject.hero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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

        Mockito.when(heroMapper.dtoToHero(heroDto))
            .thenReturn(hero);

        Mockito.when(heroRepository.save(hero))
            .thenReturn(savedHero);
            
        Mockito.when(heroMapper.heroToDtoResponse(savedHero))
            .thenReturn(new HeroResponseDto(
                "Wonder Woman",
                "Themyscira"
            )
        );

        HeroResponseDto heroResponseDto = heroService.createHero(heroDto);

        Assertions.assertEquals(heroDto.name(), heroResponseDto.name());
        Assertions.assertEquals(heroDto.city(), heroResponseDto.city());
        
    }
}
