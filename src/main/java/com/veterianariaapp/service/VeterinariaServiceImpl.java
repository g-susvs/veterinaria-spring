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

}
