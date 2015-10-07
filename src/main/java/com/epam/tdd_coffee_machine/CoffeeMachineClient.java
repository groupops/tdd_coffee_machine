package com.epam.tdd_coffee_machine;

public class CoffeeMachineClient {

  public String createOrder(Beverage beverage, Sugar sugar) {
    String beverageSymbol = beverage.getSymbol();
    String sugarSymbol = sugar.getSymbol();
    String stickSymbol = addStick(sugarSymbol);

    StringBuilder orderCommand = new StringBuilder();
    return orderCommand
        .append(beverageSymbol)
        .append(":")
        .append(sugarSymbol)
        .append(":")
        .append(stickSymbol)
        .toString();
  }

  public String addSugar(Beverage beverage){
    String orderCommand = "";

    return orderCommand;
  }

  private String addStick(String sugarSymbol) {
    return (!sugarSymbol.equals("")) ? "0" : "";
  }

}
