package com.alura.challenge.challengeLiteratura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    private Long id;
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Idioma idioma;
    private String copyright;
    private Integer descargas;
    @ManyToOne
    private Autor autor;

    public Libro() {
    }

    public Libro(DatosLibro libro){
        this.id = libro.id();
        this.titulo = libro.titulo();
        this.idioma = Idioma.fromString(libro.idiomas().stream()
                .limit(1).collect(Collectors.joining()));
        this.copyright = libro.copyright();
        this.descargas = libro.descargas();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "\n------------ Libro ------------\n" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", idioma=" + idioma +
                ", copyright='" + copyright + '\'' +
                ", descargas=" + descargas +
                ", autor=" + autor +
                "\n-----------------------------------\n";
    }


    public void setTitle(String titulo) {
    }

    public void setLanguages(String idiomas) {
    }

    public void setDownloadCount(Integer descargas) {
    }

    public void setAutores(Set<Autor> autores) {
    }

    public List<Autor> getAuthors() {
        return (List<Autor>) autor;
    }

    public void setAuthors(List<Autor> authors) {
        this.autor = autor;
    }


}
