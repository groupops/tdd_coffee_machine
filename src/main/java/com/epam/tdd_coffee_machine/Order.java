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

  public boolean isEnoughMoneyFor(Beverage beverage) {
    boolean isEnoughMoney;
    BigDecimal moneyFromClient = getMoney();
    int result = moneyFromClient.compareTo(beverage.getPrice());

    if (result >= 0) {
      isEnoughMoney = true;
    } else {
      Message message =
          new Message("You have given not enough money for this drink");
      drinkMaker.forwardMessage(message);
      isEnoughMoney = false;
    }
    return isEnoughMoney;
  }

  public void setMoney(BigDecimal money) {
    this.money = money;
  }

  public void addBeverage(Beverage beverage) {
    if (isEnoughMoneyFor(beverage)) {

      String beverageSymbol = beverage.getSymbol();

      String command = new StringBuilder()
          .append(beverageSymbol)
          .append(":")
          .append(":")
          .toString();
      this.setCommand(command);
    }
  }

  public void addSugar(Sugar sugar) {
    StringBuilder orderCommandBuilder = new StringBuilder(command);
    command = orderCommandBuilder
        .replace(2, 3, sugar.getSymbol())
        .append(":")
        .append(Stick.ONE.getSymbol())
        .toString();
  }

}
