package com.epam.translator;

import java.math.BigDecimal;
import java.util.Date;

import com.epam.model.Drink;
import com.epam.model.Order;
import com.epam.model.Sale;
import com.epam.report.Report;

public class OrderTranslator {
	
	private static final int NO_SUGAR = 0;
	private Order order;
	private String instruction;
	private Report report;
	
	public OrderTranslator(Order order, Report report) {
		this.order = order;
		this.report = report;
	}
	
	public void setupDrinkInstruction(BigDecimal moneyAmount) {
		StringBuilder instruction = new StringBuilder();
		
		//TODO: check water and milk
		if (checkMoneyAmount(moneyAmount)) {
			setStick();
			
			switch (order.getType()) {
			case TEA:
				instruction.append("T");
				report.addSale(new Sale(Drink.TEA, new Date()));
				break;
			case COFFEE: 
				instruction.append("C");
				report.addSale(new Sale(Drink.COFFEE, new Date()));
				break;
			case CHOCOLATE: 
				instruction.append("H");
				report.addSale(new Sale(Drink.CHOCOLATE, new Date()));
				break;
			case JUICE:
				instruction.append("O");
				report.addSale(new Sale(Drink.JUICE, new Date()));
				break;
			}
			
			instruction.append(order.isExtraHot() ? "h" : "");
			instruction.append(":");
			instruction.append((order.getType() == Drink.JUICE) ? "" : order.getSugarQuantity());
			instruction.append(":");
			instruction.append(order.getStick() ? "0" : "");
			
			setInstruction(instruction.toString());
		}
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	private boolean checkMoneyAmount(BigDecimal moneyAmount) {
		if (moneyAmount.compareTo(order.getType().getEmount()) == -1) {
			BigDecimal moneyAmountMissing = order.getType().getEmount().subtract(moneyAmount);
			setInstruction("M:Not enough money! Please add " + moneyAmountMissing + " euro");
			return false;
		}
		return true;
	}

	public void edjustSugarAmount(int sugarQuantity) {
		if (sugarQuantity > -1 && sugarQuantity < 3) {
			order.setSugarQuantity(sugarQuantity);
		} else {
			System.out.println("Alowed amount of suger is: 0, 1, 2");
		}
		setStick();
	}
	
	private void setStick() {
		order.setStick(order.getSugarQuantity() > NO_SUGAR);
	}
}
