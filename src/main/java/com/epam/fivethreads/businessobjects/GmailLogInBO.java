package com.epam.fivethreads.businessobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.epam.fivethreads.page.LogInPage;
import com.epam.fivethreads.page.PasswordPage;
import com.epam.fivethreads.page.StartPage;

public class GmailLogInBO extends BasicBO{
	private static final Logger LOG = Logger.getLogger(GmailLogInBO.class);
	
	public void login(String userLogin, String userPassword) {
		LOG.info(" ---- GmailLogInBO.loginGmail() ---- ");
		LogInPage logInPage = new LogInPage();
		logInPage.openPage();	
		PasswordPage passwordPage=logInPage.inputLogIn(userLogin);
		passwordPage.inputPassword(userPassword);
		//return isUserLoggedIn();
	}
	
	public boolean isUserLoggedIn() {
		LOG.info(" ---- GmailLogInBO.isUserLoggedIn() ---- ");
		StartPage startPage = new StartPage();
		return startPage.isOpened();
	}

}
