package tacos.web.api;

import lombok.Getter;
import tacos.Ingredient;

public class IngredientResource { //extends ResourceSupport {
	
	@Getter
	private String name;
	
	@Getter
	private tacos.Ingredient.Type type;
	
	public IngredientResource(Ingredient ingredient) {
		this.name = ingredient.getName();
		this.type = ingredient.getType();
	}
}
