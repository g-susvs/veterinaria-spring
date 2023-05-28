package com.veterianariaapp.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterianariaapp.model.Veterinaria;
import com.veterianariaapp.service.interfaces.VeterinariaService;

@RestController
@RequestMapping("/api/veterinaria")
public class VeterinariaController {

    @Autowired
    VeterinariaService veterinariaService;

    @GetMapping
    List<Veterinaria> getVeterinarias() {
        return veterinariaService.getVeterinarias();
    }

    @PostMapping
    ResponseEntity<Veterinaria> save(@RequestBody Veterinaria veterinaria) {
        return new ResponseEntity<>(veterinariaService.saveVeterinaria(veterinaria), HttpStatus.CREATED);
    }
}
