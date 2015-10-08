package com.epam.translator;

import java.math.BigDecimal;

import com.epam.model.Drink;
import com.epam.model.Order;

public class OrderTranslator {
	
	private Order order;
	private String instruction;
	
	public OrderTranslator(Order order) {
		this.order = order;
	}
	
	public void setupDrinkInstruction(BigDecimal moneyAmount) {
		StringBuilder instruction = new StringBuilder();
		
		if (checkMoneyAmount(moneyAmount)) {
			setStick();
			
			switch (order.getType()) {
			case TEA: 
				instruction.append("T");
				break;
			case COFFEE: 
				instruction.append("C");
				break;
			case CHOCOLATE: 
				instruction.append("H");
				break;
			case JUICE:
				instruction.append("O");
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
		order.setStick(order.getSugarQuantity() > 0);
	}
}
