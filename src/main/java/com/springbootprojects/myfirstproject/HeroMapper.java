package com.springbootprojects.myfirstproject;

import org.springframework.stereotype.Service;

@Service
public class HeroMapper {

    public Hero dtoToHero(HeroDto heroDto) {
        var hero = new Hero();
        hero.setName(heroDto.name());
        hero.setCity(heroDto.city());
        
        var publisher = new Publisher();
        publisher.setId(heroDto.publisherId());
        hero.setPublisher(publisher);

        return hero;
    }

    public HeroResponseDto heroToDtoResponse(Hero hero) {
        var heroResponseDto = new HeroResponseDto(
            hero.getName(), hero.getCity()
        );
        return heroResponseDto;
    }

}
