package com.epam.tdd_coffee_machine;

public class Order {

  private String command;

  private void setCommand(String command) {
    this.command = command;
  }

  public String getCommand() {
    return command;
  }

  public void addBeverage(Beverage beverage){
    String beverageSymbol = beverage.getSymbol();

    String command = new StringBuilder()
        .append(beverageSymbol)
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

}
