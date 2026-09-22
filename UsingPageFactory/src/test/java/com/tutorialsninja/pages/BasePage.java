package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	WebDriver driver;
     //Constrcutor
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
}
