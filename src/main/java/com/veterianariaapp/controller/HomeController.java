package com.veterianariaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.veterianariaapp.model.Veterinaria;
import com.veterianariaapp.service.interfaces.VeterinariaService;

@Controller
public class HomeController {

    @Autowired
    VeterinariaService veterinariaService;

    @GetMapping("/")
    public String home(Model model) {

        List<Veterinaria> lista = veterinariaService.getVeterinarias();

        model.addAttribute("veterinarias", lista);

        return "home";
    }

    // private List<Veterinaria> getAll() {
    // Veterinaria veterinaria1 = new Veterinaria();
    // veterinaria1.setId(1);
    // veterinaria1.setNombre("Carevet");
    // veterinaria1.setCorreo("vet1@email.com");
    // veterinaria1.setDescripcion("Ofrecemos todos los servicios");
    // veterinaria1.setDireccion("Avenida principal");
    // veterinaria1.setDestacado(1);
    // veterinaria1.setImagen("veterinaria1.png");

    // Veterinaria veterinaria2 = new Veterinaria();
    // veterinaria2.setId(2);
    // veterinaria2.setNombre("Pet-Salud");
    // veterinaria2.setCorreo("vet2@email.com");
    // veterinaria2.setDescripcion("Ofrecemos todos los servicios");
    // veterinaria2.setDireccion("Avenida secundaria");
    // veterinaria2.setDestacado(0);
    // veterinaria2.setImagen("veterinaria2.png");

    // Veterinaria veterinaria3 = new Veterinaria();
    // veterinaria3.setId(3);
    // veterinaria3.setNombre("PetsCare");
    // veterinaria3.setCorreo("vet3@email.com");
    // veterinaria3.setDescripcion("Ofrecemos todos los servicios");
    // veterinaria3.setDireccion("Tercera avenida");
    // veterinaria3.setDestacado(1);
    // veterinaria3.setImagen("veterinaria3.png");

    // List<Veterinaria> lista = Arrays.asList(veterinaria1, veterinaria2,
    // veterinaria3);
    // return lista;
    // }
}
