package com.example.autoconfigure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * @SpringBootConfiguration al posto delle prossime tre annotazioni
 */
@EnableAutoConfiguration(exclude = {})
@Configuration
@ComponentScan
public class AutoConfigureApplication {

	public static void main(String[] args) {

		SpringApplication.run(AutoConfigureApplication.class, args);
	}

}
