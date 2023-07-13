package com.veterianariaapp.service.interfaces;

import java.util.List;
import com.veterianariaapp.model.Cita;

public interface CitaService {
    List<Cita> getCitas();

    Cita saveCita(Cita cita);
}
