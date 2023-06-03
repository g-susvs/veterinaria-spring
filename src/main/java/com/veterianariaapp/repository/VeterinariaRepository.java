package com.veterianariaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.veterianariaapp.model.Veterinaria;

public interface VeterinariaRepository extends JpaRepository<Veterinaria, Integer> {

    Veterinaria findVeterinariaById(int id);
}
