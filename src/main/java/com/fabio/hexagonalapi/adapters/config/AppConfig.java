package com.fabio.hexagonalapi.adapters.config;

import com.fabio.hexagonalapi.HexagonalapiApplication;
import com.fabio.hexagonalapi.application.ports.PersonRepositoryPort;
import com.fabio.hexagonalapi.application.services.PersonServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = HexagonalapiApplication.class)
public class AppConfig {

    @Bean
    PersonServiceImpl personServiceImpl(PersonRepositoryPort personRepositoryPort) {
        return new PersonServiceImpl(personRepositoryPort);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
