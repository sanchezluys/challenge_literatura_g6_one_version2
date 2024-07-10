package com.alura.challenge.challengeLiteratura.service;

import com.alura.challenge.challengeLiteratura.model.Autor;
import com.alura.challenge.challengeLiteratura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public void saveAutores(List<Autor> autores) {
        autorRepository.saveAll(autores);
    }
}
