package com.in28minutes.junittestservice.dto;

public class Item {
	
	private int id;
	private String name;
	private double price;
	private int quantity;
	
	public Item(int id, String name, double price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
	
	

}
