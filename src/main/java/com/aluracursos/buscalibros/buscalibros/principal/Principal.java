package com.aluracursos.buscalibros.buscalibros.principal;

import com.aluracursos.buscalibros.buscalibros.modelos.DatosEspecificos;
import com.aluracursos.buscalibros.buscalibros.modelos.DatosGenerales;
import com.aluracursos.buscalibros.buscalibros.modelos.Libros;
import com.aluracursos.buscalibros.buscalibros.servicios.ConsumoApi;
import com.aluracursos.buscalibros.buscalibros.servicios.ConvierteDatos;

import java.util.Comparator;
import java.util.Scanner;
import java.util.zip.CheckedOutputStream;

public class Principal {

    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);


    public void muetsraMenu(int numero) {

         var json = consumoApi.obtenerDatos(URL_BASE);
         //System.out.println(json);
        var datos = convierteDatos.obtenerDatos(json, DatosGenerales.class);
        //System.out.println(datos);
        //Libros mas decargados
        System.out.println("TOP "+numero+" libros mas descargados");
        datos.resultado().stream()
                .sorted(Comparator.comparing(DatosEspecificos::totalDescargas).reversed())
                .limit(numero)
                .map(l->l.titulo().toUpperCase())
                .forEach(System.out::println);
    }
    public void buscarLibro() {

        System.out.println("Ingrese apellido escritor");
        System.out.println("Si no lo sabe presione enter.");

        var escritor = teclado.nextLine();

        System.out.println("Ingrese nombre del libro");

        var nombreLibro = teclado.nextLine();

        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + escritor + "%20" + nombreLibro);

        var buscador = convierteDatos.obtenerDatos(json, DatosGenerales.class);
        System.out.println("Libros encontrados");
        buscador.resultado().stream()
                .limit(10)
                .forEach(System.out::println);


 }

 public void opcionesMenu (){
     System.out.println("***********");
     System.out.println("Elija una opcion");
     System.out.println("***********");
     System.out.println("""
             1- Mostar TOP 5 libros mas descargados
             2- Mostar TOP 10 libros mas descargados
             3- Buscar por autor y/o nombre del libro
             9. Salir
             """);
     System.out.println("***********");

 }

}
