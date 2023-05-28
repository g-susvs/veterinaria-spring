package com.veterianariaapp.service.interfaces;

import java.util.List;

import com.veterianariaapp.model.Veterinaria;

public interface VeterinariaService {
    List<Veterinaria> getVeterinarias();

    Veterinaria saveVeterinaria(Veterinaria veterinaria);
}
