package app.dto;

import java.io.Serializable;

public class Ingredients implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String amount;
	
	public Ingredients() {}
	
	public Ingredients(String name, String amount) {
		this.name = name;
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAmount() {
		return amount;
	}
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
}
