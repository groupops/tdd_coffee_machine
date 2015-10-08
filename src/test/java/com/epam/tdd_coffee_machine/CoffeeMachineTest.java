package com.epam.tdd_coffee_machine;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CoffeeMachineTest {

  CoffeeMachineClient client;
  DrinkMaker drinkMaker;
  Screen screen;

  @Before
  public void setUp(){
    screen = new Screen();
    drinkMaker = new DrinkMaker(screen);
    client = new CoffeeMachineClient(drinkMaker);
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
    String messageContent = screen.getMessage().getContent();

    assertEquals(sampleMessageContent, messageContent);
  }

  @Test
  public void shouldCreateCoffeeOrderWithEnoughMoneyTest(){
    Order order = client.createOrder(Beverage.COFFEE);
    BigDecimal coffeeCost = new BigDecimal("0.6");
    BigDecimal money = new BigDecimal("0.6");
    BigDecimal moneyFromClient = client.giveMoney(money);
    order.setMoney(moneyFromClient);

    assertEquals(coffeeCost, order.getMoney());
  }

  @Test
  public void shouldCreateCoffeeOrderWithTooMuchMoneyTest(){
    Order order = client.createOrder(Beverage.COFFEE);
    BigDecimal money = new BigDecimal("0.7");
    BigDecimal moneyFromClient = client.giveMoney(money);
    order.setMoney(moneyFromClient);

    assertThat(order.isEnoughMoneyFor(Beverage.COFFEE), is(equalTo(true)));
  }

  @Test
  public void shouldNotCreateCoffeeOrderWithNotEnoughMoneyTest(){
    BigDecimal money = new BigDecimal("0.5");
    BigDecimal moneyFromClient = client.giveMoney(money);
    Order order = client.createOrder(Beverage.COFFEE);
    order.setMoney(moneyFromClient);

    assertThat(order.isEnoughMoneyFor(Beverage.COFFEE), is(equalTo(false)));
  }

  @Test
  public void shouldSendMessageWhenNotEnoughMoneyTest(){
    String expectedMessage = "You have given not enough money for this drink";
    Order order = client.createOrder(Beverage.COFFEE);
    BigDecimal money = new BigDecimal("0.5");
    BigDecimal moneyFromClient = client.giveMoney(money);
    order.setMoney(moneyFromClient);
    String messageContent = screen.getMessage().getContent();

    assertEquals(expectedMessage, messageContent);
  }

}
