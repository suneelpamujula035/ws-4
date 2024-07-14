package com.mapping.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_table")
public class Customer {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int customerId;
	@Column(name = "customer_name")
	private String customerName;

	@OneToOne(cascade = CascadeType.ALL)
	private Item item;

	public Customer(String customerName) {
		super();
		this.customerName = customerName;
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	
	
}
