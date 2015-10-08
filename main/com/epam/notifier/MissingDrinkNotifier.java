package com.epam.notifier;

import com.epam.model.Email;

public class MissingDrinkNotifier implements EmailNotifier {

	private Email email;
	
	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	@Override
	public void notifyMissingDrink(String drink) {
		String receiver = "alex@gmail.com";
		String subject = "Shortages of drink";
		String body = "Please, fill the coffee machine with " + drink;
		
		setEmail(new Email(receiver, subject, body));
		sendEmail();
	}

	private void sendEmail() {
		// send
	}

}
