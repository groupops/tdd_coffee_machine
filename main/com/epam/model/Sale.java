package com.epam.model;

import java.util.Date;

public class Sale {

	private Drink drink;
	private Date soldDate;
	
	public Sale(Drink drink, Date soldDate) {
		this.drink = drink;
		this.soldDate = soldDate;
	}

	public Drink getDrink() {
		return drink;
	}
	
	public void setDrink(Drink drink) {
		this.drink = drink;
	}
	
	public Date getDate() {
		return soldDate;
	}
	
	public void setDate(Date date) {
		this.soldDate = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drink == null) ? 0 : drink.hashCode());
		result = prime * result + ((soldDate == null) ? 0 : soldDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		if (drink != other.drink)
			return false;
		if (soldDate == null) {
			if (other.soldDate != null)
				return false;
		} else if (!soldDate.equals(other.soldDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sale [drink=" + drink + ", soldDate=" + soldDate + "]";
	}
}
