package com.epam.tdd_coffee_machine;

public enum Beverage implements Ingredient {

  COFFEE("C"),
  TEA("T"),
  CHOCOLATE("H");

  private final String symbol;

  Beverage(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public String getSymbol() {
    return symbol;
  }

}
