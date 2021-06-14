package demo;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;
import tacos.Taco;
import tacos.data.TacoRepository;

@Configuration
public class RouterFunctionConfig {

	private TacoRepository tacoRepo;

	@Autowired
	public RouterFunctionConfig(TacoRepository tacoRepo) {
		this.tacoRepo = tacoRepo;
	}

	/*
	 * 
	 * 
	 * @Bean public RouterFunction<?> helloRouterFunction(){ return
	 * route(GET("/hello"), request -> ok().body(just("Hello World"), String.class))
	 * .andRoute(GET("/bye"), request -> ok().body(just("See ya"), String.class)); }
	 */

	/*
	@Bean
	public RouterFunction<?> routerFunction() {
		return route(GET("/design/taco"), this::recents).andRoute(POST("/design"), this::postTaco);
	}

	public Mono<ServerResponse> recents(ServerRequest request) {
		return ServerResponse.ok().body(tacoRepo.findAll().take(12), Taco.class);
	}

	public Mono<ServerResponse> postTaco(ServerRequest request) {
		Mono<Taco> taco = request.bodyToMono(Taco.class);
		Mono<Taco> savedTaco = tacoRepo.save(taco);
		return ServerResponse.created(URI.create("http://localhost:9090/design/taco/" + savedTaco.getId()))
				.body(savedTaco, Taco.class);
	}
	*/
}
