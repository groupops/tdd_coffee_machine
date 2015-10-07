package com.epam.tdd_coffee_machine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoffeeMachineTest {

  CoffeeMachineClient client;

  @Before
  public void setUp(){
    client = new CoffeeMachineClient();
  }

  @Test
  public void shouldCreateCoffeeOrderTest() {
    Order order = client.createOrder(Beverage.COFFEE);

    assertEquals("C::", order.getCommand());
  }

  @Test
  public void shouldCreateTeaOrderTest() {
    Order order = client.createOrder(Beverage.TEA);

    assertEquals("T::", order.getCommand());
  }

  @Test
  public void shouldCreateChocolateOrderTest() {
    Order order = client.createOrder(Beverage.CHOCOLATE);

    assertEquals("H::", order.getCommand());
  }

  @Test
  public void shouldAddOneSugarToCoffeeOrderTest() {
    Order order = client.createOrder(Beverage.COFFEE);
    order.addSugar(Sugar.ONE);

    assertEquals("C:1:0", order.getCommand());
  }

  @Test
  public void shouldAddOneSugarToTeaOrderTest() {
    Order order = client.createOrder(Beverage.TEA);
    order.addSugar(Sugar.ONE);

    assertEquals("T:1:0", order.getCommand());
  }

  @Test
  public void shouldAddOneSugarToChocolateOrderTest() {
    Order order = client.createOrder(Beverage.CHOCOLATE);
    order.addSugar(Sugar.ONE);

    assertEquals("H:1:0", order.getCommand());
  }

  @Test
  public void shouldAddTwoSugarsToCoffeeOrderTest() {
    Order order = client.createOrder(Beverage.COFFEE);
    order.addSugar(Sugar.TWO);

    assertEquals("C:2:0", order.getCommand());
  }

  @Test
  public void shouldAddTwoSugarsToTeaOrderTest() {
    Order order = client.createOrder(Beverage.TEA);
    order.addSugar(Sugar.TWO);

    assertEquals("T:2:0", order.getCommand());
  }

  @Test
  public void shouldAddTwoSugarsToChocolateOrderTest() {
    Order order = client.createOrder(Beverage.CHOCOLATE);
    order.addSugar(Sugar.TWO);

    assertEquals("H:2:0", order.getCommand());
  }

  @Test
  public void shouldForwardMessageReceivedByCoffeeMachine(){
    String sampleMessageContent = "message-content";
    Message message = new Message(sampleMessageContent);
    String messageContent = client.getMessage(message);

    assertEquals("M:message-content", messageContent);
  }

}
