package dev.tedi.Movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//tells you it's a controller for the REST API not just another class
@RestController
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

//	tell the framework it's a get method
//	with the get mapping you can define what the address is in this case just slash
	@GetMapping("/")
	public String apiRoot() {
		return "Hello, World!";
	}

}
