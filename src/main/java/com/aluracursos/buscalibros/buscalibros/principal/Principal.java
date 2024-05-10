package com.aluracursos.buscalibros.buscalibros.principal;

import com.aluracursos.buscalibros.buscalibros.modelos.DatosEspecificos;
import com.aluracursos.buscalibros.buscalibros.modelos.DatosGenerales;
import com.aluracursos.buscalibros.buscalibros.modelos.Libros;
import com.aluracursos.buscalibros.buscalibros.servicios.ConsumoApi;
import com.aluracursos.buscalibros.buscalibros.servicios.ConvierteDatos;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
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


        System.out.println("Ingrese nombre del libro");

        var buscaLibro = teclado.nextLine();

        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + buscaLibro.replace(" ", "+"));

        var buscador = convierteDatos.obtenerDatos(json, DatosGenerales.class);

        Optional<DatosEspecificos> libroBuscado = buscador.resultado().stream()
                        .filter(l -> l.titulo().toUpperCase().contains(buscaLibro.toUpperCase()))
                        .findFirst();
          if (libroBuscado.isPresent()){
              System.out.println("Libro encontrado");
              System.out.println(libroBuscado.get());
          } else {
              System.out.println("Libro no encontrado");
          }

 }
 public void estadisticas (){
     var json = consumoApi.obtenerDatos(URL_BASE);
     //System.out.println(json);

     var datos = convierteDatos.obtenerDatos(json, DatosGenerales.class);

        DoubleSummaryStatistics est = datos.resultado().stream()
                .filter(d -> d.totalDescargas()>0)
                .collect(Collectors.summarizingDouble(DatosEspecificos::totalDescargas));

     System.out.println("Promedio de descargas: "+est.getAverage());
     System.out.println("Libro con mas descargas: "+est.getMax());
     System.out.println("Libro con menos descargas: "+est.getMin());
     System.out.println("Total de libros analizados: "+est.getCount());
 }

 public void opcionesMenu (){
     System.out.println("***********");
     System.out.println("Elija una opcion");
     System.out.println("***********");
     System.out.println("""
             1- Mostar TOP 5 libros mas descargados
             2- Mostar TOP 10 libros mas descargados
             3- Buscar por autor y/o nombre del libro
             4- Estadisticas
             9. Salir
             """);
     System.out.println("***********");

 }

}
