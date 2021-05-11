package com.example.controller;

import com.example.domain.Post;
import com.example.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EntityScan("com.example.domain")
@ComponentScan(basePackages = "com.example")
public class H2demoApplication {

	@Autowired
	PostRepository postRepository;

	public static void main(String[] args) {

		SpringApplication.run(H2demoApplication.class, args);
	}

	@PostConstruct
	void seePosts(){
		for (Post post : postRepository.findAll()) {
			if (post != null)
				System.out.println(post.toString());
		}
	}

}
