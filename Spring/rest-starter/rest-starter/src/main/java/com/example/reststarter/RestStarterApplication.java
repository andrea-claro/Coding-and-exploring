package com.example.reststarter;

import com.example.domain.Author;
import com.example.domain.Post;
import com.example.repository.AuthorRepository;
import com.example.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.util.Date;

@SpringBootApplication(scanBasePackages = "com.example")
public class RestStarterApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestStarterApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(AuthorRepository authorRepository, PostRepository postRepository){
		return args ->{
			Author dv = new Author("Andrea", "Claro", "andrea@claro.com");
			authorRepository.save(dv);

			Post post1 = new Post("Spring Boot Rocks!");
			post1.setSlug("spring-data-rocks");
			post1.setTeaser("Post Teaser");
			post1.setBody("Post Body");
			post1.setPostedOn(new Date());
			post1.setAuthor(dv);
			postRepository.save(post1);

			Post post2 = new Post("Rest is what all the cool kids are doing");
			post2.setSlug("rest-is-cool");
			post2.setTeaser("Post Teaser");
			post2.setBody("Post Body");
			post2.setPostedOn(new Date());
			post2.setAuthor(dv);
			postRepository.save(post2);
		};
	}

}
