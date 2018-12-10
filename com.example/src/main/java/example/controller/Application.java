package example.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"example.business","example.aspect", "example.web", "example.exceptions", "example.controller"})
@SpringBootApplication
public class Application {
	
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Application.class, args);
	}

}
