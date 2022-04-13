package app.recipe.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import app.dto.AbstractResponse;
import app.dto.RecipesResponse;
import app.dto.RequestRecipe;
import app.dto.RequestUpdateRecipe;


@Path("recipe")
@Component
@Produces("application/json")
public interface RecipeService {
	
	// curl -XGET http://localhost:8080/api/recipe/all
	@GET
	@Path("/all")
	public RecipesResponse getRecipes();
	
	// curl -XPOST -H "Content-type: application/json" -d '{"name":"Arepas", "description":"Hechas con arina de maiz precocido", "imagePath":"http://google.com.ar"}' 'http://localhost:8080/api/recipe'
	@POST
	@Path("")
	@Consumes("application/json")
	public AbstractResponse createRecipe(@RequestBody RequestRecipe requestCreateRecipe); 
	
	// curl -XPOST -H "Content-type: application/json" -d '{"id":"5","name":"Arepa", "description":"Hecha con arina de maiz precocida", "imagePath":"http://google.com.uy"}' 'http://localhost:8080/api/recipe/update'
    @PUT
    @Path("")
    @Consumes("application/json")
    public AbstractResponse updateRecipe(@QueryParam("id")Long id, @RequestBody RequestRecipe requestUpdateRecipe);
    
    // curl -XDELETE -H "Content-type: application/json" -d '{"id":"8","name":"Arepa", "description":"Hecha con arina de maiz precocida", "imagePath":"http://google.com.uy"}' 'http://localhost:8080/api/recipe/delete'
    @DELETE
    @Path("")
    public AbstractResponse deleteRecipe(@QueryParam("id")Long id);


}
