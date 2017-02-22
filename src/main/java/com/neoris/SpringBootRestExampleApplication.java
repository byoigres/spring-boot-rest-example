package com.neoris;

import com.neoris.repositories.PieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import com.neoris.models.Pie;

@SpringBootApplication
public class SpringBootRestExampleApplication {

	private final Faker faker = new Faker();

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestExampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner initializeDb(PieRepository repository) {
		return (args) -> {
			repository.deleteAll();
			// Insert ramdom pies
			for(int i = 0; i < 20; i++) {
				repository.save(new Pie(faker.lorem().word(), faker.lorem().sentence()));
			}
		};
	}
}
