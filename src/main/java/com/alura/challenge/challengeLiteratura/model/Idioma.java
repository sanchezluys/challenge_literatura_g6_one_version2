package com.alura.challenge.challengeLiteratura.model;

public enum Idioma {
    ES("es"),
    FR("fr"),
    EN("en"),
    TL("tl"),
    PT("pt");

    private String idioma;

    Idioma(String idioma) {
        this.idioma = idioma;
    }

    public String getIdioma(){
        return this.idioma;
    }

    public static Idioma fromString(String text) {
        for (Idioma idioma : Idioma.values()) {
            if (idioma.idioma.equalsIgnoreCase(text)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Enum no encontrado " + text );
    }
}
