package com.springbootprojects.myfirstproject.villain;

import org.springframework.stereotype.Service;

import com.springbootprojects.myfirstproject.hero.Hero;
import com.springbootprojects.myfirstproject.publisher.Publisher;

@Service
public class VillainMapper {

    public Villain dtoToVillain(VillainDto villainDto) {
        var villain = new Villain();
        villain.setName(villainDto.name());
        
        var hero = new Hero();
        hero.setId(villainDto.heroId());
        villain.setHero(hero);

        var publisher = new Publisher();
        publisher.setId(villainDto.publisherId());
        villain.setPublisher(publisher);

        return villain;
    }

    public VillainResponseDto villainToDtoResponse(Villain villain) {
        var villainResponseDto = new VillainResponseDto(
            villain.getName()
        );
        return villainResponseDto;
    }
}
