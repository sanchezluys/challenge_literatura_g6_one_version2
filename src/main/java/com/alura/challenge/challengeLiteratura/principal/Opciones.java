package com.alura.challenge.challengeLiteratura.principal;

import com.alura.challenge.challengeLiteratura.service.ConsumoAPI;

import java.util.Scanner;

public class Opciones {

    public void muestra() {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                         MENÚ                             ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Buscar libro por titulo con la API                    ║");
        System.out.println("║ 2. Listar libros registrados                             ║");
        System.out.println("║ 3. Listar autores registrados                            ║");
        System.out.println("║ 4. Listar autores vivos en determinado año               ║");
        System.out.println("║ 5. Listar libros por idioma                              ║");
        System.out.println("║ 8. Salir                                                 ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.print("Ingrese su opción: ");
    }

    public void buscarPorTitulo() {
        this.encabezadoBuscarPorTitulo();
        this.recibirTitulo();

    }

    private void recibirTitulo() {
        Scanner scanner = new Scanner(System.in);
        String titulo = scanner.nextLine();
        ConsumoAPI api = new ConsumoAPI();
        api.obtenerDatos(titulo);

    }

    private void encabezadoBuscarPorTitulo() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║     BUSCAR LIBRO POR TITULO CON LA API                 ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Ingrese el nombre del libro a ser buscado, ejemplo:    ║");
        System.out.println("║ > don quijote de la mancha                             ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.print("Ingrese el título para buscarlo: ");
    }

    public void listarLibros() {
        this.encabezadoListarLibros();
    }

    private void encabezadoListarLibros() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║           LISTAR LIBROS REGISTRADOS EN LA BD           ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Se listarán los libros que estan registrados en la BD  ║");
        System.out.println("║                                                        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }

    public void listarAutores() {
        this.encabezadoListarAutores();

    }

    private void encabezadoListarAutores() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║           LISTAR AUTORES EN LA BD                      ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Se listarán los autores que esten registrados en la BD ║");
        System.out.println("║                                                        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }

    public void listarAutoresVivosPorAno() {
        this.encabezadoListarAutoresVivosPorAno();
    }

    private void encabezadoListarAutoresVivosPorAno() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║           LISTA DE AUTORES VIVOS EN LA FECHA DEFINIDA  ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Se listarán los autores que estan registrados en la BD ║");
        System.out.println("║ y esten vivos en un año especifico                     ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.print("Ingrese el año para buscar autores vivos en ese año: ");
    }

    public void verIdiomas() {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║             IDIOMAS DISPONIBLES                          ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Es-Español                                            ║");
        System.out.println("║ 2. Fr-Frances                                            ║");
        System.out.println("║ 3. En-Ingles                                             ║");
        System.out.println("║ 4. PT-Portugués                                          ║");
        System.out.println("║ -------> 8. Volver sin listar                            ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.print("Ingrese su opción: ");
    }

    public void muestreDespedida() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                         DESPEDIDA                      ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Muchas gracias por usar esta Aplicacion de Literarura  ║");
        System.out.println("║ Nos vemos pronto!!                                     ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");;
    }

    public void encabezado() {
        //**
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║ ALURA LATAM                                              ║");
        System.out.println("║ CHALENGER LITERATURA                                     ║");
        System.out.println("║ Profesores: Bruno Fernández/ Genesys Rondon / Eric Fraga ║");
        System.out.println("║ Backend con JAVA 17                                      ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║ Usando API de: http://gutendex.com/                      ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
    }

}
