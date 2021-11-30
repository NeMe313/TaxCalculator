package com.sales.taxes.service;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import com.sales.taxes.model.BasicTax;
import com.sales.taxes.model.CustomOrder;
import com.sales.taxes.model.ImportedTax;
import com.sales.taxes.model.Item;
import com.sales.taxes.model.Receipt;
import com.sales.taxes.model.ShoppingCart;
import com.sales.taxes.model.Tax;

/**
 * The class is used for processing the order by: converting Stream<String> into
 * a List<String>, iterating through the lines, and comparing them, with
 * IMPORTED_TEXT_PATTERN using a Matcher class instance creating CustomOrder
 * object from matcher object using getCustomOrderFromLine method
 */

public class Processor {

	private static final Pattern IMPORTED_TEXT_PATTERN = Pattern
			.compile("(?<quantity>\\d+)\\s+(?<name>.+)\\s+at\\s+(?<unitPrice>\\S+)");
	private static final String IMPORTED = "imported";
	private static final String QUANTITY = "quantity";
	private static final String NAME = "name";
	private static final String UNIT_PRICE = "unitPrice";

	/**
	 * Process initialises the choice processing, creation of the cart and receipt
	 * writing
	 * 
	 * @param stream
	 * @throws FileNotFoundException
	 */
	public static void process(Stream<String> stream) throws NullPointerException {
		if (stream != null) {
			ShoppingCart cart = createShoppingCart(stream);
			Receipt receipt = createReceipt(cart);
			String finalReceiptForPrinting = writeReceipt(receipt);
			if (receipt.getOrders().size() != 0)
				System.out.println("Receipt: \n" + finalReceiptForPrinting);
		} else {
			throw new NullPointerException();
		}
	}

	/**
	 * Creation of the Shopping Cart
	 * 
	 * @param stream
	 * 
	 */
	private static ShoppingCart createShoppingCart(Stream<String> stream) throws Error {
		// Filtering the input file for empty line removal
		List<String> lines = stream.filter(line -> !Objects.equals(StringUtils.EMPTY, line))
				.collect(Collectors.toList());

		ShoppingCart cart = new ShoppingCart();

		// Iterating through the lines and creating an order based on the regex match
		for (String line : lines) {
			Matcher matcher = IMPORTED_TEXT_PATTERN.matcher(line);
			try {
				CustomOrder order = getCustomOrderFromLine(matcher);
				cart.addOrder(order);
			} catch (Exception e) {
				throw new Error("Wrong line's pattern" + line);
			}
		}

		return cart;

	}

	/**
	 * Getting the customer order from the line based on the regex match passed
	 * 
	 * @param matcher
	 * @throws Exception
	 */
	private static CustomOrder getCustomOrderFromLine(Matcher matcher) throws Exception {
		if (matcher.find()) {
			// Parameter creation from lines
			Integer quantity = Integer.parseInt(matcher.group(QUANTITY));
			Boolean imported = false;
			String name = matcher.group(NAME);
			// Checking whether the item name contains word "imported" and cutting it off
			// for easier tax category calculation
			if (name.contains(IMPORTED)) {
				name = name.replaceAll(IMPORTED, StringUtils.EMPTY).replaceAll("\\s{2,}", " ").trim();
				imported = true;
			}
			BigDecimal unitPrice = new BigDecimal(matcher.group(UNIT_PRICE));
			// Item creation
			Item item = new Item(name, unitPrice, imported);
			// Order creation
			CustomOrder order = new CustomOrder(item, quantity);
			return order;
		} else {
			throw new Exception("Next subsequence of the input sequence that matches the pattern is not found.");
		}
	}

	/**
	 * Create a receipt from the Shopping Cart
	 * 
	 * @param cart
	 * 
	 */
	private static Receipt createReceipt(ShoppingCart cart) {
		Receipt receipt = new Receipt();
		// Iterate over orders from the shopping cart, calculate their taxes and add
		// into receipt
		for (CustomOrder order : cart.getOrders()) {
			BigDecimal currentTax = calculateTax(order);
			CustomOrder orderAfterTax = new CustomOrder(order.getItem(), order.getQuantity(), currentTax);
			receipt.addOrder(orderAfterTax);
		}
		return receipt;
	}

	/**
	 * Calculate the tax of a single order
	 * 
	 * @param order
	 */
	private static BigDecimal calculateTax(CustomOrder order) {
		BigDecimal tax = BigDecimal.ZERO;
		Item item = order.getItem();
		// Check if tax is applicable and add base tax if yes
		if (BasicTax.isTaxable(item)) {
			Tax basicTax = new BasicTax();
			tax = tax.add(basicTax.calculateTax(order.getOrderPrice()));
		}
		// Check is the ordered item is imported
		if (item.isImported()) {
			Tax importTax = new ImportedTax();
			tax = tax.add(importTax.calculateTax(order.getOrderPrice()));
		}
		return tax;
	}

	/**
	 * Writing a receipt string for display
	 * 
	 * @param receipt
	 * @throws Exception
	 */
	private static String writeReceipt(Receipt receipt) {
		StringBuilder writtenReceipt = new StringBuilder();
		// Iterate over orders and add all the details to receipt string
		for (CustomOrder order : receipt.getOrders()) {
			if (order.getItem().isImported()) {
				writtenReceipt.append(order.getQuantity()).append(" ").append("imported").append(" ")
						.append(order.getItem().getName()).append(" : ").append(order.getOrderPriceTaxed())
						.append("\n");
			} else {
				writtenReceipt.append(order.getQuantity()).append(" ").append(order.getItem().getName()).append(" : ")
						.append(order.getOrderPriceTaxed()).append("\n");
			}
		}
		// Add sales taxes and total to receipt text
		writtenReceipt.append("Sales Taxes: ").append(receipt.getTaxes()).append("\nTotal: ")
				.append(receipt.getSumTaxed());
		return writtenReceipt.toString();
	}
}
