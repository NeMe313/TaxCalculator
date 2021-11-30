package com.sales.taxes.model;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BasicTaxTest {

	private BasicTax basicTax;

	@Before
	public void setUp() {
		basicTax = new BasicTax();
	}

	@Test
	public void testIsTaxableWithStandardItem() {
		Item item = new Item("music CD", new BigDecimal("12.00"), true);
		Boolean result = BasicTax.isTaxable(item);
		Assert.assertTrue(result);
	}

	@Test
	public void testIsTaxableWithExemptionItem() {
		Item item = new Item("chocolate bar", new BigDecimal("12.00"), true);
		Boolean result = BasicTax.isTaxable(item);
		Assert.assertFalse(result);
	}

	@Test
	public void testCalcTaxRoundUp() {
		BigDecimal price = new BigDecimal("4.89");
		BigDecimal expectedResult = new BigDecimal("0.50");
		BigDecimal result = basicTax.calculateTax(price);
		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void testCalcTaxWithZeroAsPrice() {
		BigDecimal price = new BigDecimal("0.00");
		BigDecimal expectedResult = new BigDecimal("0.00");
		BigDecimal result = basicTax.calculateTax(price);
		Assert.assertEquals(expectedResult, result);
	}

	@After
	public void teardown() {
		basicTax = null;
	}
}
