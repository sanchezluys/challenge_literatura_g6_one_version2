package com.alura.challenge.challengeLiteratura.repository;

import com.alura.challenge.challengeLiteratura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
