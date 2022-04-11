package app.datasource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.recipe.entity.Ingredient;

@Repository
public interface IngredientDataSource extends CrudRepository<Ingredient, Long> {

}
