package com.mapping.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_table")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String trackingId;
	private double price;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_product_fk")
	private List<Product> products = new ArrayList<>();
	public Order(String trackingId, double price, List<Product> products) {
		super();
		this.trackingId = trackingId;
		this.price = price;
		this.products = products;
	}
	
}
