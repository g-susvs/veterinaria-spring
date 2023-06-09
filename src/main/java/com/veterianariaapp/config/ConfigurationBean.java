package com.veterianariaapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.veterianariaapp.service.CitaServiceImpl;
import com.veterianariaapp.service.UsuarioServiceImpl;
import com.veterianariaapp.service.VeterinariaServiceImpl;
import com.veterianariaapp.service.interfaces.CitaService;
import com.veterianariaapp.service.interfaces.UsuarioService;
import com.veterianariaapp.service.interfaces.VeterinariaService;

@Configuration
public class ConfigurationBean {

    @Value("${cloudinary.cloud-name}")
    private String cloudName;

    @Value("${cloudinary.api-key}")
    private String apiKey;

    @Value("${cloudinary.api-secret}")
    private String apiSecret;

    @Bean
    Cloudinary cloudinaryConfig() {
        return new Cloudinary("cloudinary://"
                + apiKey + ":"
                + apiSecret + "@"
                + cloudName);
    }

    @Bean
    VeterinariaService veterinariaService() {
        return new VeterinariaServiceImpl();
    }

    @Bean
    UsuarioService usuarioService() {
        return new UsuarioServiceImpl();
    }

    @Bean
    CitaService citaService() {
        return new CitaServiceImpl();
    }

}
