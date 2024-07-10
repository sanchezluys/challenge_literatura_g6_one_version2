package com.alura.challenge.challengeLiteratura.principal;

import com.alura.challenge.challengeLiteratura.model.Autor;
import com.alura.challenge.challengeLiteratura.model.Datos;
import com.alura.challenge.challengeLiteratura.model.DatosLibro;
import com.alura.challenge.challengeLiteratura.model.Libro;
import com.alura.challenge.challengeLiteratura.repository.AutorRepository;
import com.alura.challenge.challengeLiteratura.service.ConsumoAPI;
import com.alura.challenge.challengeLiteratura.service.ConvierteDatos;


import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Opciones {

    public void muestra() {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                         MENÚ                             ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Buscar libro por titulo con la API                    ║");
        System.out.println("║ 2. Listar libros registrados en BD                       ║");
        System.out.println("║ 3. Listar autores registrados en BD                      ║");
        System.out.println("║ 4. Listar autores vivos en determinado año en BD         ║");
        System.out.println("║ 5. Listar libros por idioma de la BD                     ║");
        System.out.println("║ 8. Salir                                                 ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.print("Ingrese su opción: ");
    }

    public void buscarPorTitulo(AutorRepository repository) throws IOException {

        this.encabezadoBuscarPorTitulo();
        this.recibirTitulo(repository);

    }

    private void recibirTitulo(AutorRepository repository) throws IOException {
        String URL_BASE = "https://gutendex.com/books/?search=";
        Scanner scanner = new Scanner(System.in);
        String titulo = scanner.nextLine();
        ConsumoAPI api = new ConsumoAPI();
        ConvierteDatos conversor = new ConvierteDatos();
        System.out.println("⌛ Buscando...." + titulo);
        var json = api.obtenerDatos(URL_BASE + titulo.replace(" ", "+").toLowerCase());
        var datos = conversor.obtenerDatos(json, Datos.class);
        Integer cuenta = datos.total();
        if (cuenta > 0) {
            System.out.println("\uD83D\uDE03 Se encotraron " + (cuenta - 1) + " titulos mas que contienen " + titulo + " en su nombre ");
            Optional<DatosLibro> libroBuscado = datos.libros().stream()
                    .findFirst();
            this.muestraLibro(libroBuscado);
            this.guardarEnBD(libroBuscado, titulo, repository);
        } else {
            System.out.println("\uD83D\uDE41 lo sentimos, no se encontró ningún libro llamado: " + titulo);
        }

    }

    private void muestraLibro(Optional<DatosLibro> libroBuscado) {
        List<Libro> libroEncontrado = libroBuscado.stream().map(a -> new Libro(a)).collect(Collectors.toList());
        System.out.println(libroEncontrado);
    }


    private void guardarEnBD(Optional<DatosLibro> libroBuscado, String nombre, AutorRepository repository) {


        System.out.println("Guardando en BD el titulo encontrado...");
        try {
            List<Libro> libroEncontrado = libroBuscado.stream().map(a -> new Libro(a)).collect(Collectors.toList());
            Autor autorAPI = libroBuscado.stream().
                    flatMap(l -> l.autores()
                            .stream()
                            .map(a -> new Autor(a)))
                    .collect(Collectors.toList())
                    .stream().findFirst()
                    .get();

            Optional<Autor> autorBD = repository.buscarAutorPorNombre(
                    libroBuscado.get().
                            autores().stream()
                            .map(a -> a.nombre())
                            .collect(Collectors.joining()));

            Optional<Libro> libroOptional = repository.buscarLibroPorNombre(nombre);
            if (libroOptional.isPresent()) {
                System.out.println("El libro ya está guardado en la BD.");
            }
            else {
                Autor autor;
                if (autorBD.isPresent()) {
                    autor = autorBD.get();
                    System.out.println("EL autor ya esta guardado en la BD");
                } else {
                    autor = autorAPI;
                    repository.save(autor);
                }
                autor.setLibros(libroEncontrado);
                repository.save(autor);
            }

        } catch (Exception e) {
            System.out.println("Error! " + e.getMessage());
        }
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

    public void listarLibros(AutorRepository repository) {
        this.encabezadoListarLibros();
        List<Libro> libros = repository.buscarTodosLosLibros();
        System.out.println("---------------------------------------------");
        System.out.println("|| Titulo       Autor      Idioma     Descargas ||");
        System.out.println("---------------------------------------------");
        libros.forEach(l -> System.out.println(
                            " || "+ l.getTitulo() + " || " +
                            l.getAutor().getNombre() + " || "+
                            l.getIdioma().getIdioma() + " || " +
                            l.getDescargas()+ " || "
        ));
        System.out.println("---------------------------------------------");

    }

    private void encabezadoListarLibros() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║           LISTAR LIBROS REGISTRADOS EN LA BD           ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Se listarán los libros que estan registrados en la BD  ║");
        System.out.println("║                                                        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println("⌛ Buscando...");
    }

    public void listarAutores(AutorRepository repository) {
        this.encabezadoListarAutores();
        List<Autor> autores = repository.findAll();
        System.out.println("----------------------------------------------------------");
        System.out.println("|| Autor-Nombre       Fecha Nacimiento      Fecha Muerte ||");
        System.out.println("----------------------------------------------------------");
        autores.forEach(a -> System.out.println(
                " || "+ a.getNombre() + " || " +
                        a.getNacimiento() + " || "+
                        a.getFallecimiento() + " || "
        ));
        System.out.println("---------------------------------------------");
    }

    private void encabezadoListarAutores() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║           LISTAR AUTORES EN LA BD                      ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Se listarán los autores que esten registrados en la BD ║");
        System.out.println("║                                                        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println("⌛ Buscando....");
    }

    public void listarAutoresVivosPorAno(AutorRepository repository) {
        this.encabezadoListarAutoresVivosPorAno();
        this.recibirAno(repository);

    }

    private void recibirAno(AutorRepository repository) {
        Scanner scanner = new Scanner(System.in);
        Integer ano = null;
        while (ano == null || ano < 1 || ano > 5000) {
            //System.out.print("Ingrese el año para buscar autores vivos en ese año: ");
            String input = scanner.nextLine();

            try {
                ano = Integer.parseInt(input);
                if (ano < 1 || ano > 5000) {
                    System.out.println("El año debe estar entre 1 y 5000.");
                    ano = null;
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número entero.");
            }
        }

        List<Autor> autores = repository.buscarAutoresVivos(ano);
        System.out.println("----------------------------------------------------------");
        System.out.println("|| Autor-Nombre       Fecha Nacimiento      Fecha Muerte ||");
        System.out.println("----------------------------------------------------------");
        autores.forEach(a -> System.out.println(
                " || "+ a.getNombre() + " || " +
                        a.getNacimiento() + " || "+
                        a.getFallecimiento() + " || "
        ));
        System.out.println("---------------------------------------------");
    }

    private void encabezadoListarAutoresVivosPorAno() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║ LISTA DE AUTORES VIVOS EN LA FECHA DEFINIDA POR USTED  ║");
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
        System.out.println("╚════════════════════════════════════════════════════════╝");
        ;
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
