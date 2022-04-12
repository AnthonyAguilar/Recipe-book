package app.datasource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.dto.IngredietItem;
import app.recipe.entity.Ingredient;

@Repository
public interface IngredientDataSource extends JpaRepository<Ingredient, Serializable>{

	List<Ingredient> findAll();

	
	@Query(value = "SELECT c.name, SUM(c.amount)\n"
			+ "FROM Ingredient c\n"
			+ "WHERE c.name = c.name\n"
			+ "GROUP BY c.name", nativeQuery = true)
	List<Object[]> findIngredientsNoRepeat(); 






	

}
