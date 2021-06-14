package tacos.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import tacos.Ingredient;

@CrossOrigin(origins="*")
public interface IngredientRepository extends ReactiveCrudRepository<Ingredient, String> { // extends
																							// CrudRepository<Ingredient,
																							// String> {
	/*
	 * Commento dopo l'estensione della CrudRepository e quindi non più necessari
	 * 
	 * Iterable<Ingredient> findAll();
	 * 
	 * Ingredient findOne(String id);
	 * 
	 * Ingredient save(Ingredient ingredient);
	 */
	/*
	 * 
	 * Ingredient findOneFromName(String name);
	 */
}
