package com.epam.report;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.epam.helpers.DateHelper;
import com.epam.model.Drink;
import com.epam.model.Sale;

public class ReportTest {

	@Test
	public void reportReturnsSalesForTheGivenDate() throws ParseException {
		Report report = new Report();
		report.addSale(new Sale(Drink.TEA, new DateHelper().getDateFromString("January 2, 2015")));
		report.addSale(new Sale(Drink.COFFEE, new DateHelper().getDateFromString("January 2, 2015")));
		report.addSale(new Sale(Drink.TEA, new DateHelper().getDateFromString("January 3, 2015")));
		
		List<Sale> actualDailySales = report.getDailyReport(new DateHelper().getDateFromString("January 2, 2015"));
		
		assertEquals(createExpectedSales(), actualDailySales);
	}

	private List<Sale> createExpectedSales() throws ParseException {
		List<Sale> expectedSales = new ArrayList<Sale>();
		expectedSales.add(new Sale(Drink.TEA, new DateHelper().getDateFromString("January 2, 2015")));
		expectedSales.add(new Sale(Drink.COFFEE, new DateHelper().getDateFromString("January 2, 2015")));
		return expectedSales;
	}

}
