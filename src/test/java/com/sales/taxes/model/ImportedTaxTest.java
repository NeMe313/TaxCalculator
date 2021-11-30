package com.sales.taxes.model;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ImportedTaxTest {

	private ImportedTax importedTax;

    @Before
    public void setUp() {
    	importedTax = new ImportedTax();
    }
	@Test
	public void calculateTaxRoundUp() {
		BigDecimal price = new BigDecimal("12.89");
		BigDecimal expectedResult = new BigDecimal("0.65");
		BigDecimal result = importedTax.calculateTax(price);
		Assert.assertEquals(expectedResult, result);
	}

	@Test
	public void calculateTaxZeroAsPrice() {
		BigDecimal price = new BigDecimal("0.00");
		BigDecimal expectedResult = new BigDecimal("0.00");
		BigDecimal result = importedTax.calculateTax(price);
		Assert.assertEquals(expectedResult, result);
	}
	
    @After
    public void teardown() {
    	importedTax = null;
    }
}
