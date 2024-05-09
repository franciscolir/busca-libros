package com.aluracursos.buscalibros.buscalibros.modelos;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") String fechaNacimineto){
    @Override
    public String toString() {
        return  "nombre='" + nombre + '\'' +
                "fechaNacimineto='" + fechaNacimineto;
    }
}
