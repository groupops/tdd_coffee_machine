package com.epam.model;

public class Order {

	private Drink type;
	private boolean stick;
	private int sugarQuantity;
	private String message;
	private boolean extraHot;
	
	public Order(Drink type, int sugarQuantity, boolean stick, boolean extraHot) {
		this.type = type;
		
		if (this.getType() == Drink.JUICE) {
			this.sugarQuantity = 0;
		} else {
			this.sugarQuantity = sugarQuantity;
		}
		
		this.stick = stick;
		
		if (this.getType() == Drink.JUICE) {
			this.extraHot = false;
		} else {
			this.extraHot = extraHot;
		}
	}

	public Drink getType() {
		return type;
	}

	public void setType(Drink type) {
		this.type = type;
	}

	public int getSugarQuantity() {
		return sugarQuantity;
	}

	public void setSugarQuantity(int sugarQuantity) {
		if (this.getType() == Drink.JUICE) {
			this.sugarQuantity = 0;
		} else {
			this.sugarQuantity = sugarQuantity;
		}
	}

	public boolean getStick() {
		return stick;
	}
	
	public void setStick(boolean stick) {
		this.stick = stick;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isExtraHot() {
		return extraHot;
	}

	public void setExtraHot(boolean extraHot) {
		if (this.getType() == Drink.JUICE) {
			this.extraHot = false;
		} else {
			this.extraHot = extraHot;
		}
	}
}