package com.alura.challenge.challengeLiteratura.service;

import com.alura.challenge.challengeLiteratura.model.DatosLibro;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
public class ConvierteLibrosAutores {
    public static List<DatosLibro> mapJsonToLibros(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Mapeo root = objectMapper.readValue(json, Mapeo.class);
        return root.getResults();
    }
}
