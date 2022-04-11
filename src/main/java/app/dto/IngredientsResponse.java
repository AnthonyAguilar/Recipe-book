package app.dto;

import java.util.ArrayList;
import java.util.List;

import app.recipe.entity.Ingredient;

public class IngredientsResponse extends AbstractResponse {

	private List<Ingredient> ingredient;

	public List<Ingredient> getIngredients() {
		if(ingredient==null)
			ingredient= new ArrayList<Ingredient>();
		return ingredient;
	}

	public void setRecipes(List<Ingredient> ingredient) {
		this.ingredient = ingredient;
	}

}
