package com.veterianariaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/form")
    public String form(Model model) {

        return "form";
    }

    @GetMapping("/formimg/{id}")
    public String formImg(@PathVariable int id, Model model) {

        Veterinaria veterinaria = veterinariaService.findVeterinariaById(id);

        model.addAttribute("veterinaria", veterinaria);

        return "formupload";
    }
}
