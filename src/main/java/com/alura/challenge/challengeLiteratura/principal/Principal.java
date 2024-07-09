package com.alura.challenge.challengeLiteratura.principal;

import com.alura.challenge.challengeLiteratura.repository.AutorRepository;

public class Principal {

    private AutorRepository repository;
    public Principal(AutorRepository repository){
        this.repository = repository;
    }


    public void mostrarMenu() {
        AutorRepository repository = this.repository;
    }
}
