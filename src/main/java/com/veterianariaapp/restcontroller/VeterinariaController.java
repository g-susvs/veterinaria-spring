package com.veterianariaapp.restcontroller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.veterianariaapp.model.Veterinaria;
import com.veterianariaapp.service.CloudinaryService;
import com.veterianariaapp.service.interfaces.VeterinariaService;

@RestController
@RequestMapping("/api/veterinaria")
public class VeterinariaController {

    @Autowired
    VeterinariaService veterinariaService;
    @Autowired
    CloudinaryService cloudinaryService;

    @GetMapping
    List<Veterinaria> getVeterinarias() {
        return veterinariaService.getVeterinarias();
    }

    @PostMapping
    ResponseEntity<Veterinaria> save(@RequestBody Veterinaria veterinaria) {
        return new ResponseEntity<>(veterinariaService.saveVeterinaria(veterinaria), HttpStatus.CREATED);
    }

    @PutMapping("/actualizarimg/{id}")
    ResponseEntity<Veterinaria> save(@PathVariable int id, @RequestParam("archivo") MultipartFile multipartFile)
            throws IOException {

        Map result = cloudinaryService.uploaad(multipartFile);

        String url = (String) result.get("secure_url");

        Veterinaria veterinaria = veterinariaService.actualizarImg(id, url);

        return new ResponseEntity<>(veterinariaService.saveVeterinaria(veterinaria), HttpStatus.OK);
    }

}
