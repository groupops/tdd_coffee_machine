package com.epam.tdd_coffee_machine;

import java.math.BigDecimal;

public class CoffeeMachineClient {

  private DrinkMaker drinkMaker;

  public CoffeeMachineClient(DrinkMaker drinkMaker) {
    this.drinkMaker = drinkMaker;
  }

  public Order createOrder(Beverage beverage) {
    Order order = new Order(drinkMaker);
    order.addBeverage(beverage);
    return order;
  }

  public void sendMessage(Message message){
    drinkMaker.forwardMessage(message);
  }

  public BigDecimal giveMoney(BigDecimal money){
    return money;
  }

}
