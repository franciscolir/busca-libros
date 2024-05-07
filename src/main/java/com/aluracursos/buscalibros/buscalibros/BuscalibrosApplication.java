package com.aluracursos.buscalibros.buscalibros;

import com.aluracursos.buscalibros.buscalibros.servicios.ConsumoApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class BuscalibrosApplication implements CommandLineRunner {
	Scanner teclado = new Scanner(System.in);
	final String URL = "https://gutendex.com/books/";
			String buscaId;
	public static void main(String[] args) {

		SpringApplication.run(BuscalibrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Ingresa numero de libro");
		buscaId = (teclado.nextLine()+"/");
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obtenerDatos(URL+buscaId);
		System.out.println(json);
	}

}
