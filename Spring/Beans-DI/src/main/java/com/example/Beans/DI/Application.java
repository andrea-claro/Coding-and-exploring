package com.example.Beans.DI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan({"com.example.Beans.DI"})
public class Application {

	@Bean
	public User user(){
		return new User("Dan", "Bilzerian");
	}

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for(String name: beanNames){
			System.out.println(name);
		}

		System.out.println("\n"+ctx.getBean("user").toString());
	}

}
