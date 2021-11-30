package com.sales.taxes.model;

import java.math.BigDecimal;

/**
* CustomerOrder class for order details like quantity, item and taxation
*/
public class CustomOrder {

	private Integer quantity;
	private Item item;
	private BigDecimal tax;

	/**
	 * Public constructor for CustomerOrder without tax
	 * 
	 * @param item, quantity
	 */
	public CustomOrder(Item item, Integer quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	/**
	 * Public constructor for CustomerOrder with tax
	 * 
	 * @param item, quantity, tax
	 * 
	 */
	public CustomOrder(Item item, Integer quantity, BigDecimal tax) {
		this.item = item;
		this.quantity = quantity;
		this.tax = tax;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getTax() {
		return this.tax;
	}

	/**
	 * Overrides .toString method in order to obtain textual data from quantity and
	 * item properties
	 */
	@Override
	public String toString() {
		String customOrder = Integer.toString(this.quantity) + " " + this.item.toString();
		return "ORDER: " + customOrder;
	}

	/**
	 * Method for obtaining the order price of an item by multiplying item price
	 * with item quantity
	 */
	public BigDecimal getOrderPrice() {
		final BigDecimal result = this.item.getPrice().multiply(new BigDecimal(this.getQuantity()));
		return result;
	}

	/**
	 * Method for obtaining taxed price
	 */
	public BigDecimal getOrderPriceTaxed() {
		return getOrderPrice().add(getTax());
	}
}