package com.sales.taxes.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * The abstract class is used for a default tax calculation
 */
public abstract class Tax {

	public abstract BigDecimal calculateTaxBeforeRound(BigDecimal price);

	public BigDecimal calculateTax(BigDecimal price) {
		BigDecimal taxBeforeRound = this.calculateTaxBeforeRound(price);
		BigDecimal taxAfterRound = taxBeforeRound.divide(new BigDecimal("0.05"), 0, RoundingMode.UP).multiply(new BigDecimal("0.05"));
		return taxAfterRound;
	}

}