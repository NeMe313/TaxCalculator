package com.sales.taxes.model;

import java.util.HashMap;

/**
 * The class is used to create a virtual shelf of the available products and
 * their category In this case the available products are fixed to the ones in
 * the assignment
 */
public class Store {

	private HashMap<String, String> productItems;

	/**
	 * Constructor with fixed products and categories given in the assignment
	 */
	public Store() {
		this.productItems = new HashMap<String, String>();
		addItemsToShelf("book", "books");
		addItemsToShelf("music CD", "standard");
		addItemsToShelf("chocolate bar", "food");
		addItemsToShelf("box of chocolates", "food");
		addItemsToShelf("bottle of perfume", "standard");
		addItemsToShelf("packet of headache pills", "medical products");
	}

	public void addItemsToShelf(String item, String category) {
		this.productItems.put(item, category);
	}

	/**
	 * Search for an Item based on the name provided
	 * 
	 * @param name
	 */
	public String searchItem(String name) {
		String item = this.productItems.get(name);
		return item;
	}

}
