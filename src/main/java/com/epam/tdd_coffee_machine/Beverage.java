package com.epam.tdd_coffee_machine;

import java.math.BigDecimal;

public enum Beverage implements Ingredient {

  COFFEE("C", true, new BigDecimal("0.6")),
  TEA("T", true, new BigDecimal("0.4")),
  CHOCOLATE("H", true, new BigDecimal("0.5")),
  ORANGE_JUICE("O", false, new BigDecimal("0.6"));

  private final String symbol;
  private final boolean canBeExtraHot;
  private final BigDecimal price;

  Beverage(String symbol, boolean canBeExtraHot, BigDecimal price) {
    this.symbol = symbol;
    this.canBeExtraHot = canBeExtraHot;
    this.price = price;
  }

  @Override
  public String getSymbol() {
    return symbol;
  }

  public boolean canBeExtraHot() {
    return canBeExtraHot;
  }

  public BigDecimal getPrice() {
    return price;
  }

}
