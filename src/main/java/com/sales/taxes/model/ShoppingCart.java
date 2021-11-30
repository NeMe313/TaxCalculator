package com.sales.taxes.model;

import java.util.ArrayList;
import java.util.List;

/* Class that creates the current order */

public class ShoppingCart {

	private List<CustomOrder> orders;

	public List<CustomOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<CustomOrder> orders) {
		this.orders = orders;
	}

	/**
	 * Constructor
	 */
	public ShoppingCart() {
		this.orders = new ArrayList<>();
	}

	/**
	 * Method for adding an order to the cart
	 */
	public void addOrder(CustomOrder order) {
		this.orders.add(order);
	}

	/**
	 * Overrides toString() method for obtaining the textual value of all the orders
	 * inside the Shopping Cart
	 */
	@Override
	public String toString() {
		StringBuilder cart = new StringBuilder();
		for (CustomOrder order : this.orders) {
			cart.append(order.toString());
			cart.append("\n");
		}
		return cart.toString();
	}
}
