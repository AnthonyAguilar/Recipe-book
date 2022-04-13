package app.recipe.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import app.datasource.RecipeDatasource;
import app.dto.AbstractResponse;
import app.dto.RecipesResponse;
import app.dto.Ingredients;
import app.dto.RequestRecipe;
import app.dto.RequestUpdateRecipe;
import app.recipe.entity.Ingredient;
import app.recipe.entity.Recipe;

@Component
public class RecipeServiceImpl implements RecipeService {

	private static final Logger logger = LoggerFactory.getLogger(RecipeServiceImpl.class);
	
	@Autowired
	private RecipeDatasource datasource;
	
	@Override
	public RecipesResponse getRecipes() {
		
		RecipesResponse response = new RecipesResponse();
				
		try{			
			datasource.findAll().forEach(recipe -> response.getRecipes().add(recipe));
			response.setCode("200");
			response.setDescription("ok");
		} catch (Exception e) {
			logger.error("Error al obtener las recetas de la base de datos.");
			response.setCode("500");
			response.setDescription("Ha ocurrido un error al consultar las recetas");
		}
		
		return response;
	}
	
	@Override
	public AbstractResponse createRecipe( RequestRecipe request) {

		AbstractResponse response = new AbstractResponse();
		
		try {
			Recipe recipe = new Recipe();
			
			recipe.setImagePath(request.getImagePath());
			recipe.setDescription(request.getDescription());
			recipe.setName(request.getName());
			recipe.setIngredients(parseIngredients(request.getIngredients()));	
			datasource.save(recipe);
			
			response.setCode("201");
			response.setDescription("Receta creada con exito");
		} catch (DataAccessException e) {
			response.setCode("500");
			response.setDescription("Ha ocurrido un error al crear la receta");	
		}
		
		return response;
	}

	@Override
	public AbstractResponse updateRecipe(Long id, RequestRecipe request) {
		
		AbstractResponse response = new AbstractResponse();
		try {			
			Recipe recipe = datasource.findOne(Long.valueOf(id));			
			if(recipe == null){
				response.setCode("404");
				response.setDescription("El registro que desea actualizar no existe");			
				return response;
			}
			
			recipe.setId(id);
			recipe.setImagePath(request.getImagePath());
			recipe.setDescription(request.getDescription());
			recipe.setName(request.getName());
			recipe.setIngredients(parseIngredients(request.getIngredients()));
			
			datasource.save(recipe);
			response.setCode("200");
			response.setDescription("Registro actualizado con exito");
		} catch (DataAccessException e) {
			response.setCode("500");
			response.setDescription("Ha ocurrido un error al actualizar la receta");	
		}
		return response;
	}

	@Override
	public AbstractResponse deleteRecipe(Long id) {
		AbstractResponse response = new AbstractResponse();
		try {	
			Recipe recipe = datasource.findOne(Long.valueOf(id));
			
			if(recipe == null){
				response.setCode("404");
				response.setDescription("El registro que desea eliminar no existe");			
				return response;
			}
			
			datasource.delete(id);
			response.setCode("200");
			response.setDescription("ok");
		} catch (DataAccessException e) {
			response.setCode("500");
			response.setDescription("Ha ocurrido un error al eliminar la receta");	
		}
		return response;
	}

	public RecipeDatasource getDatasource() {
		return datasource;
	}

	public void setDatasource(RecipeDatasource datasource) {
		this.datasource = datasource;
	}
		
	private List<Ingredient> parseIngredients(List<Ingredients> ingredients) {
		
		List<Ingredient> result = new ArrayList<Ingredient>();
		
		ingredients.forEach(reqIngredient -> {
			
			Ingredient entityIngredient = new Ingredient();
			entityIngredient.setName(reqIngredient.getName());
			entityIngredient.setAmount(reqIngredient.getAmount());
			result.add(entityIngredient);
		});

		return result;
	}

}
