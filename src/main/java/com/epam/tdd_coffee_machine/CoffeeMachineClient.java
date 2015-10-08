package com.epam.tdd_coffee_machine;

import java.math.BigDecimal;

public class CoffeeMachineClient {

  private DrinkMaker drinkMaker;
  private Order order;

  public CoffeeMachineClient(DrinkMaker drinkMaker) {
    this.drinkMaker = drinkMaker;
  }

  public Order createOrder(Beverage beverage) {
    order = new Order(drinkMaker);
    order.addBeverage(beverage);
    return order;
  }

  public void setMessage(Message message){
    drinkMaker.sendMessage(message);
  }

  public void giveMoney(BigDecimal money){
    order.setMoney(money);
  }

}
