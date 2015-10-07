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

    String order = client.createOrder(Beverage.COFFEE, Sugar.NONE);

    Assert.assertEquals("C::", order);
  }

  @Test
  public void shouldCreateTeaOrderTest() {
    CoffeeMachineClient client = new CoffeeMachineClient();
    String order = client.createOrder(Beverage.TEA, Sugar.NONE);

    Assert.assertEquals("T::", order);
  }

  @Test
  public void shouldCreateChocolateOrderTest() {
    CoffeeMachineClient client = new CoffeeMachineClient();
    String order =
        client.createOrder(Beverage.CHOCOLATE, Sugar.NONE);

    Assert.assertEquals("H::", order);
  }

  @Test
  public void shouldCreateCoffeeWithOneSugarOrderTest() {
    CoffeeMachineClient client = new CoffeeMachineClient();
    String order = client.createOrder(Beverage.COFFEE, Sugar.ONE);

    Assert.assertEquals("C:1:0", order);
  }

}
