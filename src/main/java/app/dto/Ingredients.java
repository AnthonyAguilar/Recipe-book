package app.dto;

import java.io.Serializable;

public class Ingredients implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private double amount;
	
	public Ingredients() {}
	
	public Ingredients(String name, double amount) {
		this.name = name;
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
