package com.alura.challenge.challengeLiteratura.principal;

import com.alura.challenge.challengeLiteratura.repository.AutorRepository;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    private AutorRepository repository;
    public Principal(AutorRepository repository){
        this.repository = repository;
    }

    Opciones opciones = new Opciones();

    public void mostrarMenu() throws IOException {
    
        AutorRepository repository = this.repository;
        opciones.encabezado();
        this.opciones();
    }


    public void opciones() throws IOException {
        String opcion="0";
        Scanner scanner = new Scanner(System.in);
        //
        while(!opcion.equals("8"))
        {
            opciones.muestra();
            //
            opcion = scanner.nextLine();
            //
            switch (opcion)
            {
                case "1":
                    //System.out.println("Buscar libro por titulo.");
                    opciones.buscarPorTitulo();
                    break;
                case "2":
                    //System.out.println("Listar libros registrados.");
                    opciones.listarLibros();
                    break;
                case "3":
                    //System.out.println("Listar autores registrados.");
                    opciones.listarAutores();
                    break;
                case "4":
                    //System.out.println("Listar autores vivos en determinado año.");
                    opciones.listarAutoresVivosPorAno();
                    break;
                case "5":
                    //System.out.println("Listar libros por idioma.");
                    opciones.verIdiomas();
                    break;
                case "8":
                    opciones.muestreDespedida();
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        }
        scanner.close();
    }
}
