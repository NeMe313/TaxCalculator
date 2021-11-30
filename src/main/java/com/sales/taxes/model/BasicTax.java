package com.sales.taxes.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * The class is used for base tax calculation extending the abstract class Tax
 */
public class BasicTax extends Tax {

	public static final String[] NO_TAX_CATEGORIES = new String[] { "books", "food", "medical products" };

	@Override
	public BigDecimal calculateTaxBeforeRound(BigDecimal price) {
		BigDecimal beforeRoundPrice = price.multiply( new BigDecimal("0.1"));
		// Round up the price
		BigDecimal tax = beforeRoundPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
		return tax;
	}

	/**
	 * Method is used to check if a basic tax is applicable to the item or if the
	 * item is excluded from basic taxation
	 * 
	 * @param item
	 */
	public static Boolean isTaxable(Item item) {
		// Get a list of excluded items from the final string Array of predefined
		// exemptions
		List<String> excluded = Arrays.asList(NO_TAX_CATEGORIES);
		// Tidying up the item name (as it comes with double spaces in the input file)
		String name = item.getName().trim().replaceAll(" +", " ").replaceAll("\\s+(?=\\p{Punct})", "");
		// Creating a store instance so it initialises the values of the store shelf
		Store store = new Store();
		// Search the item by the name
		String category = store.searchItem(name);
		// Check if the item is taxable
		Boolean isTaxable = !excluded.contains(category);

		return isTaxable;
	}

}
