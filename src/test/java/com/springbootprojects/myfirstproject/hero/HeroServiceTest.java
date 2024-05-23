package com.springbootprojects.myfirstproject.hero;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
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
     
        Mockito.verify(heroMapper, Mockito.times(1))
            .dtoToHero(heroDto);

        Mockito.verify(heroRepository, Mockito.times(1))
            .save(hero);

        Mockito.verify(heroMapper, Mockito.times(1))
            .heroToDtoResponse(savedHero);
    }

    @Test
    public void should_return_all_heroes() {

        Hero hero_01 = new Hero();
        hero_01.setName("Batman");
        hero_01.setCity("Gotham City");
        hero_01.setId(1);

        Hero hero_02 = new Hero();
        hero_02.setName("Wonder Woman");
        hero_02.setCity("Themyscira");
        hero_02.setId(2);

        Hero hero_03 = new Hero();
        hero_03.setName("Aquaman");
        hero_03.setCity("Atlantis");
        hero_03.setId(3);

        List<Hero> heroes = new ArrayList<>();
        heroes.add(hero_01);
        heroes.add(hero_02);
        heroes.add(hero_03);

        Mockito.when(heroRepository.findAll())
            .thenReturn(heroes);

        Mockito.when(heroMapper.heroToDtoResponse(ArgumentMatchers.any(Hero.class)))
            .thenReturn(new HeroResponseDto("any", "any"));

        List<HeroResponseDto> heroResponseDtos = heroService.findAllHeroes();

        Assertions.assertEquals(heroes.size(), heroResponseDtos.size());
        Mockito.verify(heroRepository, Mockito.times(1))
            .findAll();
    }
}
