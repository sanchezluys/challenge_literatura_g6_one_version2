package com.alura.challenge.challengeLiteratura.service;

import com.alura.challenge.challengeLiteratura.model.DatosLibro;
import com.alura.challenge.challengeLiteratura.model.Libro;
import com.alura.challenge.challengeLiteratura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private AutorService autorService;

    public void saveLibros(List<DatosLibro> libros) {
        for (DatosLibro libro : libros) {
            //autorService.saveAutores(libro.getAuthors());
            //utorService.saveAutores(libro.getTranslators());
        }
        //libroRepository.saveAll(libros);
    }
}
