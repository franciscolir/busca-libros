package com.aluracursos.buscalibros.buscalibros.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class Libros {
    private String titulo;
    private String autor;
    private String nacimiento;
    private List<String> idiomas;
    private Double totalDescargas;


    public Libros(DatosEspecificos d, DatosAutor a) {
        this.titulo = d.titulo();
        this.autor = a.nombre();
        this.nacimiento = a.fechaNacimineto();
        this.idiomas = d.idiomas();
        this.totalDescargas = d.totalDescargas();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Double getTotalDescargas() {
        return totalDescargas;
    }

    public void setTotalDescargas(Double totalDescargas) {
        this.totalDescargas = totalDescargas;
    }

    @Override
    public String toString() {
        return
                "titulo='" + titulo + '\'' +
                "autor='" + autor + '\'' +
                "nacimiento='" + nacimiento + '\'' +
                "idiomas=" + idiomas + '\'' +
                "totalDescargas=" + totalDescargas;
    }
}
