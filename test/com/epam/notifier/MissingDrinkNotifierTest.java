package com.epam.notifier;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.epam.model.Email;

public class MissingDrinkNotifierTest {

	private static final String EMAIL_RECEIVER = "alex@gmail.com";
	private static final String EMAIL_SUBJECT = "Shortages of drink";
	MissingDrinkNotifier missingDrinkNotifier;
	
	@Before
	public void before() {
		missingDrinkNotifier = new MissingDrinkNotifier();
	}
	
	@Test
	public void notifierBuildsEmailCorrectly() {
		String drink = "milk";
		
		missingDrinkNotifier.notifyMissingDrink(drink);
		
		Email expectedEmail = new Email(EMAIL_RECEIVER, EMAIL_SUBJECT, "Please, fill the coffee machine with " + drink);
		
		assertEquals(expectedEmail, missingDrinkNotifier.getEmail());
	}

}
