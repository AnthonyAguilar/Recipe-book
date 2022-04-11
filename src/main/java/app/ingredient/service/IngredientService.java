package app.ingredient.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import app.dto.IngredientsResponse;

@Path("ingredient")
@Component
@Consumes("application/json")
@Produces("application/json")
public interface IngredientService {
	
	// curl -XGET http://localhost:8080/api/ingredient/all
	@GET
	@Path("/all")
	public IngredientsResponse getIngredients();
}
