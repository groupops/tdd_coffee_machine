package com.epam.tdd_coffee_machine;

import java.math.BigDecimal;

public class CoffeeMachineClient {

  private Message message;

  public Order createOrder(Beverage beverage) {
    Order order = new Order();
    order.addBeverage(beverage);

    return order;
  }

  public Message sendMessage(Message message){
    return message;
  }

  public String getMessage(){
    return message.getContent();
  }

  public BigDecimal giveMoney(BigDecimal money){
    return money;
  }

}
