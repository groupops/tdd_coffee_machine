package com.epam.helpers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateHelper {

	public Date getDateFromString(String date) throws ParseException {
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.US);
		return format.parse(date);
	}
}
