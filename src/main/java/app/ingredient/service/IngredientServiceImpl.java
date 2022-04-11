package app.ingredient.service;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import app.datasource.IngredientDataSource;
import app.dto.Ingredients;
import app.dto.IngredientsResponse;
import app.recipe.entity.Ingredient;

public class IngredientServiceImpl implements IngredientService {

	private static final Logger logger = LoggerFactory.getLogger(IngredientServiceImpl.class);

	@Autowired
	private IngredientDataSource ingredientDatasource;

	@Override
	public IngredientsResponse getIngredients() {

		IngredientsResponse response = new IngredientsResponse();
		response.setCode("200");
		response.setDescription("ok");

		Iterable<Ingredient> ingredients = ingredientDatasource.findAll();

		ingredients.forEach(daoIngredient1 -> {

			ingredients.forEach(daoIngredient2 -> {

				if (daoIngredient1.getName() == daoIngredient2.getName()) {
					Double amount = daoIngredient1.getAmount() + daoIngredient2.getAmount();
					daoIngredient1.setAmount(amount);
				}
			
			});

			Ingredient ingredient = (Ingredient) daoIngredient1;
			response.getIngredients().add(ingredient);
		});

		return response;

	}

}
