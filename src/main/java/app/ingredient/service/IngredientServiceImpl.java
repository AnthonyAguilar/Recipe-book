package app.ingredient.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import app.datasource.IngredientDataSource;
import app.dto.Ingredients;
import app.dto.IngredientsResponse;
import app.dto.IngredietItem;
import app.recipe.entity.Ingredient;

public class IngredientServiceImpl implements IngredientService{
	
	private static final Logger logger = LoggerFactory.getLogger(IngredientServiceImpl.class);
		
	@Autowired
	private IngredientDataSource ingredientDatasource;

	@Override
	public IngredientsResponse getIngredients() {
		
		IngredientsResponse response = new IngredientsResponse();
		response.setCode("200");
		response.setDescription("ok");
		List<Object[]> ingredientsList = ingredientDatasource.findIngredientsNoRepeat();
		
		for (Object[] item : ingredientsList) {
			Ingredient ingredient = new Ingredient();
			ingredient.setName(item[0].toString());
			ingredient.setAmount((Double)item[1]);
			response.getIngredients().add(ingredient);
	    }
		
		return response;
		
	}
	
}
