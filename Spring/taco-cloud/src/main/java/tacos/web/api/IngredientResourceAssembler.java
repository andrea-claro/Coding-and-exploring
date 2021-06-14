package tacos.web.api;

import tacos.Ingredient;

public class IngredientResourceAssembler {//extends ResourceAssembler<Ingredient, IngredientResource>{
/*
	public IngredientResourceAssembler() {
		super(IngredientController2.class, IngredientResource.class);
	}
	
	@Override
	public IngredientResource toResource(Ingredient ingredient) {
		return createResourceWithId(ingredient.getId(), ingredient);
	}
*/	
	public IngredientResource instatiateResource(Ingredient ingredient) {
		return new IngredientResource(ingredient);
	}
}
