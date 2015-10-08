package com.epam.translator;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.epam.helpers.DateHelper;
import com.epam.model.Drink;
import com.epam.model.Order;
import com.epam.model.Sale;
import com.epam.report.Report;

public class OrderTranslatorTest {
	
	private static final BigDecimal NOT_ENOUGH_MONEY_AMOUNT = new BigDecimal("0.1");
	private static final BigDecimal ENOUGH_MONEY_AMOUNT = new BigDecimal("10");
	private static final BigDecimal EXPECTED_DAILY_INCOME = new BigDecimal("1.0");
	private static final boolean WITH_STICK = true;
	private static final boolean WITHOUT_STICK = false;
	private static final boolean EXTRA_HOT = true;
	private static final boolean NOT_EXTRA_HOT = false;

	private Report report;
	
	@Before
	public void before() {
		report = new Report();
	}
	
	@After
	public void after() {
		
	}
	
	@Test
	public void drinkMakerReceivesTForTea() {
		OrderTranslator orderSender = new OrderTranslator(new Order(Drink.TEA, 1, WITHOUT_STICK, NOT_EXTRA_HOT), report);
		orderSender.setupDrinkInstruction(ENOUGH_MONEY_AMOUNT);
		String instruction = orderSender.getInstruction();
		
		assertEquals("T", instruction.substring(0, 1));
	}
	
	@Test
	public void drinkMakerReceivesCForCoffee() {
		OrderTranslator orderSender = new OrderTranslator(new Order(Drink.COFFEE, 1, WITHOUT_STICK, NOT_EXTRA_HOT), report);
		orderSender.setupDrinkInstruction(ENOUGH_MONEY_AMOUNT);
		String instruction = orderSender.getInstruction();
		
		assertEquals("C", instruction.substring(0, 1));
	}
	
	@Test
	public void drinkMakerReceivesHForChocolate() {
		OrderTranslator orderSender = new OrderTranslator(new Order(Drink.CHOCOLATE, 1, WITHOUT_STICK, NOT_EXTRA_HOT), report);
		orderSender.setupDrinkInstruction(ENOUGH_MONEY_AMOUNT);
		String instruction = orderSender.getInstruction();
		
		assertEquals("H", instruction.substring(0, 1));
	}
	
	@Test
	public void drinkMakerReceivesCorrectSugarQuantity() {
		OrderTranslator orderSender = new OrderTranslator(new Order(Drink.TEA, 2, WITH_STICK, NOT_EXTRA_HOT), report);
		orderSender.setupDrinkInstruction(ENOUGH_MONEY_AMOUNT);
		String instruction = orderSender.getInstruction();
		
		assertEquals("2", instruction.substring(2, 3));
	}
	
	@Test
	public void drinkMakerReceivesStickWhenThereIsSugar() {
		OrderTranslator orderSender = new OrderTranslator(new Order(Drink.TEA, 2, WITHOUT_STICK, NOT_EXTRA_HOT), report);
		orderSender.setupDrinkInstruction(ENOUGH_MONEY_AMOUNT);
		String instruction = orderSender.getInstruction();
		
		assertEquals("0", instruction.substring(4, 5));
	}
	
	@Test
	public void drinkMakerReceivesAdjustingForSugar() {
		Order order = new Order(Drink.TEA, 2, WITHOUT_STICK, NOT_EXTRA_HOT);
		OrderTranslator orderSender = new OrderTranslator(order, report);
		orderSender.edjustSugarAmount(1);
		
		assertEquals(1, order.getSugarQuantity());
	}
	
	//TODO: sugar quantity can be between 0 and 2
	
	@Test
	public void drinkMakerDoesNotMakeTeaIfNotEnoughMoney() {
		OrderTranslator orderSender = new OrderTranslator(new Order(Drink.TEA, 1, WITHOUT_STICK, NOT_EXTRA_HOT), report);
		orderSender.setupDrinkInstruction(NOT_ENOUGH_MONEY_AMOUNT);
		String instruction = orderSender.getInstruction();
		
		assertEquals("M:Not enough money! Please add " + Drink.TEA.getEmount().subtract(NOT_ENOUGH_MONEY_AMOUNT) + " euro", instruction);
	}
	
	@Test
	public void drinkMakerReceivesThForExtraHotTea() {
		OrderTranslator orderSender = new OrderTranslator(new Order(Drink.TEA, 1, WITHOUT_STICK, EXTRA_HOT), report);
		orderSender.setupDrinkInstruction(ENOUGH_MONEY_AMOUNT);
		String instruction = orderSender.getInstruction();
		
		assertEquals("Th", instruction.substring(0, 2));
	}
	
	//TODO: do the same for extra hot coffee and chocolate
	
	@Test
	public void drinkMakerCantMakeExtraHotJuice() {
		OrderTranslator orderSender = new OrderTranslator(new Order(Drink.JUICE, 0, WITHOUT_STICK, EXTRA_HOT), report);
		orderSender.setupDrinkInstruction(ENOUGH_MONEY_AMOUNT);
		String instruction = orderSender.getInstruction();
		
		assertEquals("O::", instruction);
	}
	
	@Test
	public void drinkMakerCantMakeJuiceWithSugar() {
		OrderTranslator orderSender = new OrderTranslator(new Order(Drink.JUICE, 2, WITHOUT_STICK, NOT_EXTRA_HOT), report);
		orderSender.setupDrinkInstruction(ENOUGH_MONEY_AMOUNT);
		String instruction = orderSender.getInstruction();
		
		assertEquals("O::", instruction);
	}
	
	@Test
	public void drinkMakerDoesNotMakeJuiceIfNotEnoughMoney() {
		OrderTranslator orderSender = new OrderTranslator(new Order(Drink.JUICE, 0, WITHOUT_STICK, NOT_EXTRA_HOT), report);
		orderSender.setupDrinkInstruction(NOT_ENOUGH_MONEY_AMOUNT);
		String instruction = orderSender.getInstruction();
		
		assertEquals("M:Not enough money! Please add " + Drink.JUICE.getEmount().subtract(NOT_ENOUGH_MONEY_AMOUNT) + " euro", instruction);
	}
	
	@Test
	public void drinkMakerGeneratesDailyReport() {
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order(Drink.JUICE, 0, WITHOUT_STICK, NOT_EXTRA_HOT));
		orders.add(new Order(Drink.TEA, 0, WITHOUT_STICK, NOT_EXTRA_HOT));
		
		for (Order order : orders) {
			OrderTranslator orderSender = new OrderTranslator(order, report);
			orderSender.setupDrinkInstruction(ENOUGH_MONEY_AMOUNT);
		}
		
		List<Sale> sales = report.getDailyReport(new Date());
		
		assertEquals(createExpectedSalesForDaylyReport(), sales);
	}

	private Object createExpectedSalesForDaylyReport() {
		List<Sale> expectedSales = new ArrayList<Sale>();
		expectedSales.add(new Sale(Drink.JUICE, new Date()));
		expectedSales.add(new Sale(Drink.TEA, new Date()));
		return expectedSales;
	}
	
	@Test
	public void drinkMakerCalculatesDailyIncome() {
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order(Drink.JUICE, 0, WITHOUT_STICK, NOT_EXTRA_HOT));
		orders.add(new Order(Drink.TEA, 0, WITHOUT_STICK, NOT_EXTRA_HOT));
		
		for (Order order : orders) {
			OrderTranslator orderSender = new OrderTranslator(order, report);
			orderSender.setupDrinkInstruction(ENOUGH_MONEY_AMOUNT);
		}
		
		BigDecimal dailyIncome = report.getDailyIncome(new Date());
		
		assertEquals(EXPECTED_DAILY_INCOME, dailyIncome);
	}

}
