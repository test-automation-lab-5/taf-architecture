package com.epam.decoratorpattern.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.decoratorpattern.elements.single.Button;
import com.epam.decoratorpattern.elements.single.InputTextField;
public class PasswordPage extends AbstractPage {
	private static final Logger LOG = Logger.getLogger(PasswordPage.class);

	@FindBy(xpath = "//div[@id='password']//input[@name='password']")
	//private WebElement passwordField;
	private InputTextField passwordField;
	
	@FindBy(id = "passwordNext")
	//private WebElement passwordNextButton;
	private Button passwordNextButton;

	public StartPage inputPassword(String userPassword) {
		LOG.info("START ---- PasswordPage.inputPassword() ---- ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement passField=driver.findElement(By.xpath("//div[@id='password']//input[@name='password']"));
		js.executeScript("elem=arguments[0]; elem.setAttribute('type','text'); ", passField);
		//passwordField.sendKeys(userPassword);
		passwordField.type(userPassword);
		passwordNextButton.click();
		return new StartPage();

	}

}
