package tacos.web;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;
import tacos.Ingredient;
import tacos.Taco;
import tacos.data.IngredientRepository;
import tacos.data.TacoRepository;
import tacos.Ingredient.Type;
import tacos.Order;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

	private final IngredientRepository ingredientRepo;
	private TacoRepository tacoRepo;
	
	private RestTemplate rest;
	private Traverson traverson;
	
	@Autowired
	public DesignTacoController(IngredientRepository ingredientRepo, TacoRepository tacoRepo, RestTemplate rest, Traverson traverson) {
		this.ingredientRepo = ingredientRepo;
		this.tacoRepo = tacoRepo;
		this.rest = rest;
		this.traverson = traverson;
	}
	
	@ModelAttribute(name = "order")
	public Order order() {
		return new Order();
	}
	
	@ModelAttribute(name = "taco")
	public Taco taco() {
		return new Taco();
	}
	
	@GetMapping
	public String showDesignForm(Model model) {
		List<Ingredient> ingredients = new ArrayList<>();
		ingredientRepo.findAll().forEach(i -> ingredients.add(i));
		for (Ingredient ingredient : ingredients) {
			log.info("Ingrediente: "+ingredient.toString());
		}
				/*
				 * Nel caso in cui non ci fosse un Repository dove catturare i dati
				 * 
				Arrays.asList(new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
				new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
				new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
				new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
				new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
				new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
				new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
				new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
				new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
				new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));
				*/
		Type[] types = Ingredient.Type.values();
		for (Type type : types) 
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));

		model.addAttribute("taco", new Taco());
		return "design";
	}
/*
	@PostMapping
	public String processDesign(@Valid Taco taco, Errors errors, @ModelAttribute Order order) {
		if (errors.hasErrors())
			return "design";
		
		Taco tacoSaved = tacoRepo.save(taco);
		order.addTaco(tacoSaved);
		
		log.info("Processing design: " + tacoSaved);

		return "redirect:/orders/current";
	}
*/
	private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		List<Ingredient> temp = ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
		return temp;
	}
	
	/*
	 * Metodo per consumare una API rest con metodo GET
	 */
	public Ingredient getIngredientById(String ingredientId) {
		return rest.getForObject("http://localhost:9090/ingredients/{id}", Ingredient.class, ingredientId);
	}
	
	/*
	 * Stesso metodo che utilizzata una hashmap
	 
	public Ingredient getIngredientById(String ingredientId) {
		Map<String, String> urlVariable = new HashMap<>();
		urlVariable.put("id", ingredientId);
		return rest.getForObject("http://localhost:9090/ingredients/{id}", Ingredient.class, urlVariable);
	}
	*/
	
	/*
	 * Stesso metodo che utilizza uno URI parameter
	
	public Ingredient getIngredientById(String ingredientId) {
		Map<String, String> urlVariable = new HashMap<>();
		urlVariable.put("id", ingredientId);
		URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:9090/ingredients/{id}").build(urlVariable);
		
		return rest.getForObject(url, Ingredient.class);
	}
	*/
	
	/*
	 * Stesso metodo che utilizza un rest.getForEntity in modo da prelevare anche gli header della risposta
	
	public Ingredient getIngredientById(String ingredientId) {
		ResponseEntity<Ingredient> responseEntity = rest.getForEntity("http://localhost:9090/ingredients/{id}", Ingredient.class, ingredientId);
		log.info("Fetched time: "+responseEntity.getHeaders().getDate());
		return responseEntity.getBody();
	}
	*/
	
	/*
	 * Metodo per consumare API con metodo PUT
	 */
	public void updateIngredient(Ingredient ingredient) {
		rest.put("http://localhost:9090/ingredients/{id}", ingredient, ingredient.getId());
	}
	
	/*
	 * Metodo per consumare API con metodo DELETE
	 */
	public void deleteIngredient(Ingredient ingredient) {
		rest.delete("http://localhost:9090/ingredients/{id}", ingredient.getId());
	}
	
	/*
	 * Metodo per consumare API con metodo POST
	 */
	public Ingredient createIngredient(Ingredient ingredient) {
		return rest.postForObject("http://localhost:9090/ingredients", ingredient, Ingredient.class);
	}
	
	/*
	 * Variante con ritorno della URI alla quale viene postato l'elemento
	
	public URI createIngredient(Ingredient ingredient) {
		return rest.postForLocation("http://localhost:9090/ingredients", ingredient);
	}
	*/
	
	/*
	 * Nel caso serva in ritorno sia l'oggetto che la URI allora si utilizza il metodo postForEntity
	
	public Ingredient createIngredient(Ingredient ingredient) {
		ResponseEntity<Ingredient> responseEntity = rest.postForEntity("http://localhost:9090/ingredients", ingredient, Ingredient.class);
		log.info("New resource created at: "+ responseEntity.getHeaders().getLocation());
		return responseEntity.getBody();
	}
	*/
	
	/*
	 * Nel caso si voglia navigare tra i link senza utilizzare l'hardcoding, utilizzare Traverson
	 */
	public Ingredient addIngredient(Ingredient ingredient) {
		String ingredientUrl = traverson.follow("ingredients").asLink().getHref();
		return rest.postForObject(ingredientUrl, ingredient, Ingredient.class); 
	}
}
