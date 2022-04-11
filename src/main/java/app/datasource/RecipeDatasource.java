package app.datasource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.recipe.entity.Recipe;

@Repository
public interface RecipeDatasource extends CrudRepository<Recipe, Long> {
	
}
