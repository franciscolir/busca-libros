package com.aluracursos.buscalibros.buscalibros.modelos;

public interface IConvierteDatos {

    <T> T obtenerDatos (String json, Class<T> clase);
}
