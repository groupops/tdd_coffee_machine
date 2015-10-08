package com.epam.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.epam.model.Sale;

public class Report {
	
	private List<Sale> sales = new ArrayList<Sale>();

	public void addSale(Sale sale) {
		sales.add(sale);
	}
	
	public List<Sale> getDailyReport(Date date) {
		List<Sale> dailySales = new ArrayList<Sale>();
		for (Sale sale : sales) {
			if (sale.getDate().equals(date)) {
				dailySales.add(sale);
			}
		}
		return dailySales;
	}

	public BigDecimal getDailyIncome(Date date) {
		BigDecimal dailyIncome = new BigDecimal("0");
		
		for (Sale sale : sales) {
			dailyIncome = dailyIncome.add(sale.getDrink().getEmount());
		}
		
		return dailyIncome;
	}
}
