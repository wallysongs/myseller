package io.github.wallysongs.myseller;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.wallysongs.myseller.entities.Categoria;
import io.github.wallysongs.myseller.repositories.CategoriaRepository;

@SpringBootApplication
public class MysellerApplication implements CommandLineRunner{

	private CategoriaRepository categoriaRepository;

	public MysellerApplication(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MysellerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(1L, "Informática");
		Categoria cat2 = new Categoria(2L, "Escritório");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
