package com.epam.decoratorpattern.businessobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.epam.decoratorpattern.page.LogInPage;
import com.epam.decoratorpattern.page.PasswordPage;
import com.epam.decoratorpattern.page.StartPage;

public class GmailLogInBO extends BasicBO{
	private static final Logger LOG = Logger.getLogger(GmailLogInBO.class);
	
	public boolean login(String userLogin, String userPassword) {
		LOG.info(" ---- GmailLogInBO.loginGmail() ---- ");
		LogInPage logInPage = new LogInPage();
		logInPage.openPage();	
		PasswordPage passwordPage=logInPage.inputLogIn(userLogin);
		passwordPage.inputPassword(userPassword);
		return isUserLoggedIn();
	}
	
	public boolean isUserLoggedIn() {
		LOG.info(" ---- GmailLogInBO.isUserLoggedIn() ---- ");
		StartPage startPage = new StartPage();
		return startPage.isOpened();
	}

}
