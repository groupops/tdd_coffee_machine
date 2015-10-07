package com.epam.tdd_coffee_machine;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoffeeMachineTest {

  CoffeeMachineClient client;

  @Before
  public void setUp(){
    client = new CoffeeMachineClient();
  }

  @Test
  public void shouldCreateCoffeeOrderTest() {
    Order order = client.createOrder(Beverage.COFFEE);

    Assert.assertEquals("C::", order.getCommand());
  }

  @Test
  public void shouldCreateTeaOrderTest() {
    Order order = client.createOrder(Beverage.TEA);

    Assert.assertEquals("T::", order.getCommand());
  }

  @Test
  public void shouldCreateChocolateOrderTest() {
    Order order = client.createOrder(Beverage.CHOCOLATE);

    Assert.assertEquals("H::", order.getCommand());
  }

  @Test
  public void shouldAddOneSugarToCoffeeOrderTest() {
    Order order = client.createOrder(Beverage.COFFEE);
    order.addSugar(Sugar.ONE);

    Assert.assertEquals("C:1:0", order.getCommand());
  }

  @Test
  public void shouldAddOneSugarToTeaOrderTest() {
    Order order = client.createOrder(Beverage.TEA);
    order.addSugar(Sugar.ONE);

    Assert.assertEquals("T:1:0", order.getCommand());
  }

  @Test
  public void shouldAddOneSugarToChocolateOrderTest() {
    Order order = client.createOrder(Beverage.CHOCOLATE);
    order.addSugar(Sugar.ONE);

    Assert.assertEquals("H:1:0", order.getCommand());
  }

  @Test
  public void shouldAddTwoSugarsToCoffeeOrderTest() {
    Order order = client.createOrder(Beverage.COFFEE);
    order.addSugar(Sugar.TWO);

    Assert.assertEquals("C:2:0", order.getCommand());
  }

  @Test
  public void shouldAddTwoSugarsToTeaOrderTest() {
    Order order = client.createOrder(Beverage.TEA);
    order.addSugar(Sugar.TWO);

    Assert.assertEquals("T:2:0", order.getCommand());
  }

  @Test
  public void shouldAddTwoSugarsToChocolateOrderTest() {
    Order order = client.createOrder(Beverage.CHOCOLATE);
    order.addSugar(Sugar.TWO);

    Assert.assertEquals("H:2:0", order.getCommand());
  }

}
