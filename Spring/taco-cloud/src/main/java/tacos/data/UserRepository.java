package tacos.data;

import java.util.UUID;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;

import reactor.core.publisher.Mono;
import tacos.User;

public interface UserRepository extends ReactiveMongoRepository<User, String> { //extends CrudRepository<User, Long> {
	
	//@AllowFiltering
	Mono<User> findByUsername(String username);
}
