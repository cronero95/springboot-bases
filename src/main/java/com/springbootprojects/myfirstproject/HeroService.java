package com.springbootprojects.myfirstproject;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class HeroService {
    private final HeroRepository heroRepository;
    private final HeroMapper heroMapper;

    public HeroService(
        HeroRepository heroRepository,
        HeroMapper heroMapper
    ) {
        this.heroRepository = heroRepository;
        this.heroMapper = heroMapper;
    }

    public HeroResponseDto createHero(HeroDto heroDto) {
        var hero = heroMapper.dtoToHero(heroDto);
        heroRepository.save(hero);
        return heroMapper.heroToDtoResponse(hero);
    }

    public String deleteHeroById(Integer id) {
        heroRepository.deleteById(id);
        return "The Hero with id: "+id+" was deleted";
    }

    public HeroResponseDto findHeroeById(Integer id) {
        var hero = heroRepository.findById(id)
            .orElse(null);

        if (hero == null) {
            return new HeroResponseDto(null, null);
        }

        return heroMapper.heroToDtoResponse(hero);
    }

    public List<HeroResponseDto> findAllHeroes() {
        return heroRepository.findAll()
            .stream()
            .map(heroMapper::heroToDtoResponse)
            .collect(Collectors.toList());
    }
}