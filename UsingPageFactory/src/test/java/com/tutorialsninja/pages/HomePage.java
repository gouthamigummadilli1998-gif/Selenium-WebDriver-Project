package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HomePage extends BasePage {
	
	//Constructor without this constructor we can't invoke the parent page constructor
public HomePage(WebDriver driver) 
{
	super(driver);
 
 }
//Locators

@FindBy(xpath = "//span[normalize-space()='My Account']")
   WebElement lnkmyAccount; 
@FindBy(xpath="//a[normalize-space()='Register']")
   WebElement lnkclickrigister;
@FindBy(xpath="//a[normalize-space()='Login']")
    WebElement lnkclicklogin;
   		 

//Action Methods

public void clickMyaccount() {
	lnkmyAccount.click();
		
 }
public void clickregister() {
	
	lnkclickrigister.click();
	
 }
public void clicklogin() {
	lnkclicklogin.click();
	
}


	}
