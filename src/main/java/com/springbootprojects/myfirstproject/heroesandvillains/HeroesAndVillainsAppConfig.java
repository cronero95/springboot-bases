package com.springbootprojects.myfirstproject.heroesandvillains;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.springbootprojects.myfirstproject.HeroesQuotes;
import com.springbootprojects.myfirstproject.heroesandvillains.services.HeroesService;
import com.springbootprojects.myfirstproject.heroesandvillains.services.HeroesServiceMockup;
import com.springbootprojects.myfirstproject.heroesandvillains.services.IHeroesService;
import com.springbootprojects.myfirstproject.heroesandvillains.services.IVillainsService;
import com.springbootprojects.myfirstproject.heroesandvillains.services.VillainsService;



@Configuration
public class HeroesAndVillainsAppConfig {

    @Bean
    HeroesQuotes heroesQuotes() {
        return new HeroesQuotes("We Save As Many As We Can... That's All We Do.");
    }

    @Bean
    IHeroesService productionHeroesService() {
        return new HeroesService();
    }

    @Bean
    IVillainsService sessionVillainsService() {
        return new VillainsService();
    }

    @Bean
    @Primary
    IHeroesService developmentHeroesService() {
        return new HeroesServiceMockup();
    }

}
