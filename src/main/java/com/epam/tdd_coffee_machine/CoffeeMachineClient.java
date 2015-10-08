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
    order.addBeverage(beverage, false);
    return order;
  }

  public Order createOrder(Beverage beverage, boolean isExtraHot) {
    order = new Order(drinkMaker);
    order.addBeverage(beverage, isExtraHot);
    return order;
  }

  public void giveMoney(BigDecimal money){
    order.setMoney(money);
  }

  public void setMessage(Message message){
    drinkMaker.sendMessage(message);
  }

}
