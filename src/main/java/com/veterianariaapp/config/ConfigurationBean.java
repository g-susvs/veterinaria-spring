package com.veterianariaapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.veterianariaapp.service.VeterinariaServiceImpl;
import com.veterianariaapp.service.interfaces.VeterinariaService;

@Configuration
public class ConfigurationBean {

    @Bean
    VeterinariaService veterinariaService() {
        return new VeterinariaServiceImpl();
    }

}
