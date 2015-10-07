package com.epam.tdd_coffee_machine;

public enum Stick implements Ingredient {

  NONE(""),
  ONE("0");

  private final String symbol;

  Stick(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public String getSymbol() {
    return symbol;
  }

}
