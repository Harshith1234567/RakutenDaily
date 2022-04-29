package com.example;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("orders")
public class Order {
	@MongoId
	private float price;
	private String id;
	private String item;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
}
