package com.aluracursos.buscalibros.buscalibros.principal;

import com.aluracursos.buscalibros.buscalibros.modelos.DatosEspecificos;
import com.aluracursos.buscalibros.buscalibros.modelos.DatosGenerales;
import com.aluracursos.buscalibros.buscalibros.servicios.ConsumoApi;
import com.aluracursos.buscalibros.buscalibros.servicios.ConvierteDatos;

import java.util.Scanner;
import java.util.zip.CheckedOutputStream;

public class Principal {

    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);

    public void muetsraMenu() {

         var json = consumoApi.obtenerDatos(URL_BASE);
         System.out.println(json);

        var datos = convierteDatos.obtenerDatos(json, DatosGenerales.class);
        System.out.println(datos);
    }
    public void buscarLibro() {

        System.out.println("Ingrese nombre escritor");

        var escritor = teclado.nextLine();

        System.out.println("Ingrese nombre del libro");

        var nombreLibro = teclado.nextLine();

        var json = consumoApi.obtenerDatos(URL_BASE+"?search="+escritor+"%20"+nombreLibro);

        var buscador = convierteDatos.obtenerDatos(json, DatosGenerales.class);
        System.out.println(buscador);
 }

 public void opcionesMenu (){
     System.out.println("***********");
     System.out.println("Elija una opcion");
     System.out.println("***********");
     System.out.println("""
             1- Mostar libros disponibles
             2- Buscar por autor y/o nombre del libro
             9. Salir
             """);
     System.out.println("***********");

 }

}
