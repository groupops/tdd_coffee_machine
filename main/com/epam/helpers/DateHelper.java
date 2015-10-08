package com.epam.helpers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateHelper {

	private static final String DATE_FORMAT = "MMMM d, yyyy";
	
	public Date getDateFromString(String date) throws ParseException {
		DateFormat format = new SimpleDateFormat(DATE_FORMAT, Locale.US);
		return format.parse(date);
	}
}
