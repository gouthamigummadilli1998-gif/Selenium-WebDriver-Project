package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	//Constructor
	public LoginPage(WebDriver driver) 
	{
		super(driver);
	 
	 }
	//Locators

	@FindBy(xpath="//input[@id='input-email']")
	   WebElement txtEmailAddress; 
	@FindBy(xpath="//input[@id='input-password']")
	   WebElement txtpassword ;
	@FindBy(xpath="//input[@value='Login']")
	    WebElement clicklogin;
	
	//Action Methods

	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
			
	 }
	public void setpassword(String pwd) {
		
		txtpassword.sendKeys(pwd);
		
	 }
	public void btnLogin() {
		clicklogin.click();
		
	}

}
