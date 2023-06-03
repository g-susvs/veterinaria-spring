package com.veterianariaapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.veterianariaapp.model.Veterinaria;
import com.veterianariaapp.repository.VeterinariaRepository;
import com.veterianariaapp.service.interfaces.VeterinariaService;

public class VeterinariaServiceImpl implements VeterinariaService {

    @Autowired
    VeterinariaRepository veterinariaRepository;

    @Override
    public List<Veterinaria> getVeterinarias() {
        return veterinariaRepository.findAll();
    }

    @Override
    public Veterinaria saveVeterinaria(Veterinaria veterinaria) {

        return veterinariaRepository.save(veterinaria);
    }

    @Override
    public Veterinaria findVeterinariaById(int id) {

        Veterinaria veterinaria = veterinariaRepository.findVeterinariaById(id);

        return veterinaria;
    }

    @Override
    public Veterinaria actualizarImg(int id, String url) {

        Veterinaria veterinaria = veterinariaRepository.findVeterinariaById(id);
        veterinaria.setImagen(url);

        veterinariaRepository.save(veterinaria);

        return veterinaria;
    }

}
