package app.dto;

public class IngredietItem {
	
	public String name;
	public Double amount;
	
	public IngredietItem(String name, Double amount) {
		this.name = name;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	

}
