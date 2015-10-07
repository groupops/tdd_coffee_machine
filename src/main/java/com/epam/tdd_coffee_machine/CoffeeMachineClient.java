package com.epam.tdd_coffee_machine;

public class CoffeeMachineClient {

  public Order createOrder(Beverage beverage) {
    Order order = new Order();
    order.addBeverage(beverage);

    return order;
  }

  public String getMessage(Message message){
    return message.getContent();
  }

}
