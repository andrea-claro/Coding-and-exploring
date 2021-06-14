package tacos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import tacos.Ingredient;
import tacos.data.IngredientRepository;

@RestController
public class IngredientController {

	private IngredientRepository ingredientRepo;
	
	@Autowired
	public IngredientController(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}
	
	@GetMapping
	public Flux<Ingredient> allIngredient(){
		return ingredientRepo.findAll();
	}
}
