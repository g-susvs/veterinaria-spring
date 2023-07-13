package com.veterianariaapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.veterianariaapp.model.Cita;
import com.veterianariaapp.repository.CitaRepository;
import com.veterianariaapp.service.interfaces.CitaService;

public class CitaServiceImpl implements CitaService {

    @Autowired
    CitaRepository citaRepository;

    @Override
    public List<Cita> getCitas() {
        return citaRepository.findAll();
    }

    @Override
    public Cita saveCita(Cita cita) {
        return citaRepository.save(cita);
    }

}
