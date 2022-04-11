package app.dto;

import java.io.Serializable;
import java.util.List;

public class RequestNewRecipe implements Serializable{

	private static final long serialVersionUID = 1L;
	private  String name;
	private  String description;
	private  String imagePath;
	private  List<Ingredients> ingredients;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public List<Ingredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}

}
