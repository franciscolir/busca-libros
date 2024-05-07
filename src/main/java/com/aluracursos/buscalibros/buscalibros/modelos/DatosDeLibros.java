package com.aluracursos.buscalibros.buscalibros.modelos;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosDeLibros(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") String autor,
        @JsonAlias("languages") String idiomas,
        @JsonAlias("download_count")Integer totalDescargas,
        @JsonAlias("imdbRating") String evaluacion) {
}