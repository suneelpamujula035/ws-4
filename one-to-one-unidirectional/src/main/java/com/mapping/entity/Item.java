package com.mapping.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_table")
public class Item {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int customerId;
	@Column(name = "item_name")
	private String itemName;
	
	public Item(String itemName) {
		super();
		this.itemName = itemName;
	}
	
	
}
