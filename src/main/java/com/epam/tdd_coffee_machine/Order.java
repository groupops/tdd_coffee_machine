package com.epam.tdd_coffee_machine;

import java.math.BigDecimal;

public class Order {

  private String command;
  private BigDecimal money;
  private DrinkMaker drinkMaker;

  public Order(DrinkMaker drinkMaker) {
    this.drinkMaker = drinkMaker;
  }

  private void setCommand(String command) {
    this.command = command;
  }

  public String getCommand() {
    return command;
  }

  public BigDecimal getMoney() {
    return money;
  }

  public void setMoney(BigDecimal money) {
    this.money = money;
  }

  public void addBeverage(Beverage beverage, boolean isExtraHot) {
    String beverageSymbol = beverage.getSymbol();

    String extraHotSymbol =
        beverage.canBeExtraHot() ? addExtraHot(isExtraHot) : "";

    String command = new StringBuilder()
        .append(beverageSymbol)
        .append(extraHotSymbol)
        .append(":")
        .append(":")
        .toString();
    this.setCommand(command);
  }

  public void addSugar(Sugar sugar) {
    StringBuilder orderCommandBuilder = new StringBuilder(command);
    command = orderCommandBuilder
        .replace(2, 3, sugar.getSymbol())
        .append(":")
        .append(Stick.ONE.getSymbol())
        .toString();
  }

  public String addExtraHot(boolean isExtraHot) {
    return isExtraHot ? "h" : "";
  }

}
