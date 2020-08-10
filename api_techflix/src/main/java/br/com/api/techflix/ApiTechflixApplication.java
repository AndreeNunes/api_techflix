package br.com.api.techflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ApiTechflixApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTechflixApplication.class, args);
	}

}
