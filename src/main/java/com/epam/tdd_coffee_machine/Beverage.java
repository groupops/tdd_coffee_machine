package com.epam.tdd_coffee_machine;

import java.math.BigDecimal;

public enum Beverage implements Ingredient {

  COFFEE("C", new BigDecimal("0.6")),
  TEA("T", new BigDecimal("0.4")),
  CHOCOLATE("H", new BigDecimal("0.5"));

  private final String symbol;
  private final BigDecimal price;

  Beverage(String symbol, BigDecimal price) {
    this.symbol = symbol;
    this.price = price;
  }

  @Override
  public String getSymbol() {
    return symbol;
  }

  public BigDecimal getPrice() {
    return price;
  }

}
