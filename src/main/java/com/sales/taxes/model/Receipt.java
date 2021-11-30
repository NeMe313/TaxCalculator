package com.sales.taxes.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The class is used for the actual, printable receipt for an order
 */
public class Receipt {

	private List<CustomOrder> orders;

	public Receipt() {
		this.orders = new ArrayList<>();
	}

	public List<CustomOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<CustomOrder> orders) {
		this.orders = orders;
	}

	/**
	 * Method used for adding an order to the receipt
	 * 
	 * @param order
	 */
	public void addOrder(CustomOrder order) {
		this.orders.add(order);
	}

	/**
	 * Method used for calculating the taxes for a specific order
	 */
	public BigDecimal getTaxes() {
		BigDecimal total = BigDecimal.ZERO;
		for( CustomOrder o : this.orders) {
			total = total.add(o.getTax());
		}
		return total;
	}

	/**
	 * Method used for calculating the sum price of all item for a specific order
	 * with taxes
	 */
	public BigDecimal getSumTaxed() {
		BigDecimal total = BigDecimal.ZERO;
		for (CustomOrder o : this.orders) {
			total = total.add(o.getOrderPriceTaxed());
		}
		return total;
	}

	/**
	 * Overrides toString() method for obtaining the textual value of a receipt
	 */
	@Override
	public String toString() {
		StringBuilder receipt = new StringBuilder();
		for (CustomOrder order : this.orders) {
			receipt.append(order.toString());
			receipt.append("\n");
		}
		return receipt.toString();
	}

}
