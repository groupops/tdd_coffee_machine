package com.epam.tdd_coffee_machine;

public enum Sugar implements Ingredient {

  ONE("1"),
  TWO("2");

  private final String symbol;

  Sugar(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public String getSymbol() {
    return symbol;
  }

}
