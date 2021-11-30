package com.sales.taxes.model;

import java.math.BigDecimal;

/**
 * Item class for item details like the name and price of the item, as well as
 * if the item is imported
 */
public class Item {

	private String name;
	private BigDecimal price;
	private boolean imported;

	/**
	 * Constructor
	 */
	public Item(String name, BigDecimal price, Boolean imported) {
		this.name = name;
		this.price = price;
		this.imported = imported;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public boolean isImported() {
		return imported;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}


	/**
	 * Overrides toString() method for obtaining the textual value of an item
	 */
	@Override
	public String toString() {
		String item = this.name + " " + this.price.toString() + " " + this.imported;
		return item;
	}

}
