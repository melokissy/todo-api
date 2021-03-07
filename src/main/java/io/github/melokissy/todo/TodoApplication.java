package io.github.melokissy.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TodoApplication {
		
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
		
	}

}
