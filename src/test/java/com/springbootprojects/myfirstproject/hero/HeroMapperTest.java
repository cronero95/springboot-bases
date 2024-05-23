package com.springbootprojects.myfirstproject.hero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HeroMapperTest {

    private HeroMapper heroMapper;

    @BeforeEach
    void setUp() {
        heroMapper = new HeroMapper();
    }

    @Test
    public void shouldMapHeroDtoToHero() {
        HeroDto heroDto = new HeroDto(
            "Wonder Woman", 
            "Themyscira", 
            2
        );

        Hero hero = heroMapper.dtoToHero(heroDto);

        Assertions.assertEquals( heroDto.name(), hero.getName() );
        Assertions.assertEquals( heroDto.city(), hero.getCity() );
        Assertions.assertNotNull( hero.getPublisher() );
        Assertions.assertEquals( heroDto.publisherId(), hero.getPublisher().getId() );
    }
    
    @Test
    public void should_throw_null_pointer_exception_when_heroDto_is_null() {
        var exception = Assertions.assertThrows(
            NullPointerException.class, 
            ()-> heroMapper.dtoToHero(null)
        );

        Assertions.assertEquals(
            "The heroDto should not be null", exception.getMessage()
        );
    }

    @Test
    public void shouldMapHeroToHeroResponseDto() {
        Hero hero = new Hero();
        hero.setName("Wonder Woman");
        hero.setCity("Themyscira");

        HeroResponseDto heroResponseDto = heroMapper.heroToDtoResponse(hero);

        Assertions.assertEquals(hero.getName(), heroResponseDto.name());
        Assertions.assertEquals(hero.getCity(), heroResponseDto.city());
    }
}


