package com.aluracursos.buscalibros.buscalibros;

import com.aluracursos.buscalibros.buscalibros.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class BuscalibrosApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(BuscalibrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner teclado = new Scanner(System.in);
		Principal principal = new Principal();
		var opcion =0;
		while (opcion !=9) {

			principal.opcionesMenu();
			while (!teclado.hasNextInt()) {
				System.out.println("Por favor, introduce solo números:");
				teclado.next();
			}
			opcion = teclado.nextInt();
			switch (opcion){

				case 1:
					principal.muetsraMenu(5);
					break;

				case 2:
					principal.muetsraMenu(10);
					break;

				case 3:
					principal.buscarLibro();
					break;

				case 4:
					principal.estadisticas();
					break;

				case 9:
					System.out.println("Proceso terminado");
					System.out.println("Gracias por usar nuestros servicios");
					break;

				default:
					System.out.println("Opcion no valida");
			}
		}

	}
}
