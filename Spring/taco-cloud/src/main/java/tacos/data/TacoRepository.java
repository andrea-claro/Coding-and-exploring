package tacos.data;

import java.util.UUID;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;
import tacos.Taco;

public interface TacoRepository extends ReactiveMongoRepository<Taco, String> {//extends CrudRepository<Taco, Long>{

	//List<Taco> findAll(PageRequest page);
	/*
	 * Commento dopo l'estensione della CrudRepository e quindi inutile
	 * 
	Taco save(Taco taco);
	*/
	Flux<Taco> findByOrderByCreatedAtDesc();
}
