package com.springbootprojects.myfirstproject.heroesandvillains;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.SessionScope;

import com.springbootprojects.myfirstproject.heroesandvillains.services.HeroesService;
import com.springbootprojects.myfirstproject.heroesandvillains.services.HeroesServiceMockup;
import com.springbootprojects.myfirstproject.heroesandvillains.services.IHeroesService;
import com.springbootprojects.myfirstproject.heroesandvillains.services.IVillainsService;
import com.springbootprojects.myfirstproject.heroesandvillains.services.VillainsService;



@Configuration
public class HeroesAndVillainsAppConfig {

    @Bean
    @Scope("singleton")
    IHeroesService productionHeroesService() {
        return new HeroesService();
    }

    @Bean
    @SessionScope
    IVillainsService sessionVillainsService() {
        return new VillainsService();
    }

    @Bean
    @Primary
    IHeroesService developmentHeroesService() {
        return new HeroesServiceMockup();
    }

}
