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
		//Scanner teclado = new Scanner(System.in);
		Principal principal = new Principal();

		principal.muetsraMenu();
		principal.buscarLibro();





	}

}
