package com.aluracursos.buscalibros.buscalibros.modelos;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosEspecificos(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DatosAutor> autor,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") Double totalDescargas) {
    @Override
    public String toString() {
        return  "titulo='" + titulo + '\'' +
                ", autor=" + autor +'\'' +
                ", idiomas=" + idiomas +'\'' +
                ", totalDescargas=" + totalDescargas;
    }
}
