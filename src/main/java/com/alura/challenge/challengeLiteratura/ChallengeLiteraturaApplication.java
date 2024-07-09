package com.alura.challenge.challengeLiteratura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alura.challenge.challengeLiteratura.principal.Principal;
import com.alura.challenge.challengeLiteratura.repository.AutorRepository;

@SpringBootApplication
public class ChallengeLiteraturaApplication implements CommandLineRunner {

	@Autowired
	private AutorRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeLiteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		try {
			principal.mostrarMenu();
		} catch (Exception e) {
			// Handle the exception here
			System.out.println("Ocurrió un error: " + e.getMessage());
		}
	}
}
