package com.epam.model;

import java.math.BigDecimal;

public enum Drink {
	TEA(new BigDecimal("0.4")), COFFEE(new BigDecimal("0.6")), CHOCOLATE(new BigDecimal("0.5")), JUICE(new BigDecimal("0.6"));
	
	private final BigDecimal amount;
	
	Drink(BigDecimal amount) {
		this.amount = amount;
    }
	
	public BigDecimal getEmount() {
        return amount;
    }
}
