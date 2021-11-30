package com.sales.taxes.model;

import java.math.BigDecimal;

/**
 * The class is used for imported tax calculation extending the abstract class Tax
 */
public class ImportedTax extends Tax{
	
	private final BigDecimal imported = new BigDecimal("0.05");

    @Override
    public BigDecimal calculateTaxBeforeRound(final BigDecimal price) {
        BigDecimal beforeRoundPrice = price.multiply(imported);
        final BigDecimal result = beforeRoundPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
        return result;
    }
}
