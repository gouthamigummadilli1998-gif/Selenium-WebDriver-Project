package com.tutorialsninja.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage {
	WebDriver driver;
	//Constructor
	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
	 
	 }
	//Locators

	@FindBy(xpath="//h2[text()='My Account']")//MyAccount Page heading
	    WebElement msgHeading; 
	
	 @FindBy(xpath="//a[normalize-space()='Logout']")// added in step no 6
	  WebElement lnkLogout;
	 
	public boolean isAccountPageExists() {
		try {
			return(msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
			
		}
		
		
	}
	 public void clickLogout() {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        wait.until(ExpectedConditions.elementToBeClickable(lnkLogout));

	        lnkLogout.click();
	    }

}
