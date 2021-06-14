package tacos.web.api;

import org.springframework.hateoas.server.core.Relation;

@Relation(value = "taco", collectionRelation = "tacos")
public class TacoResource {//extends ResourceSupport {
	
	//private static final IngredientResourceAssembler ingredientAssembler = new IngredientResourceAssembler(); 
	/*
	@Getter
	private final String name;
	
	@Getter
	private final Date createdAt;
	
	@Getter
	private final List<IngredientResource> ingredients;
	
	public TacoResource(Taco taco) {
		this.name = taco.getName();
		this.createdAt = taco.getCreatedAt();
		this.ingredients = ingredientAssembler.toResource(taco.getIngredients());
	}
	*/
}
