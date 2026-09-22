package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
	
	//this the mandatory step for every page 
	public RegistrationPage(WebDriver driver) 
	{
		super(driver);
	 
	 }
	//Locators
	     
        @FindBy(xpath="//input[@id='input-firstname']")
        WebElement txtFirstname;
        
        @FindBy(xpath="//input[@id='input-lastname']")
        WebElement txtLastname;
        
        @FindBy(xpath="//input[@id='input-email']")
        WebElement txtemail;
        
        @FindBy(xpath="//input[@id='input-telephone']")
        WebElement txtTelephone;
        		
        @FindBy(xpath="//input[@id='input-password']")
        WebElement txtpwd;
        
        @FindBy(xpath="//input[@id='input-confirm']")
        WebElement txtcpwd;
        
        @FindBy(xpath="//input[@name='agree']")
        WebElement checkpolicy;
        
        @FindBy(xpath="//input[@value='Continue']")
        WebElement btnCountinue;
        
        @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
        WebElement msgConfirmation;		


//Action Methods
public void setFirstName(String fname) {
	txtFirstname.sendKeys(fname);

   }
public void setLastName(String lname) {
	txtLastname.sendKeys(lname);
	
 }
public void setEmail(String email) {
	
	txtemail.sendKeys(email);
 }
public void setTelephone(String Telephone) {
	
	txtTelephone.sendKeys(Telephone);
 }


public void setpwd(String pwd) {
	txtpwd.sendKeys(pwd);

 }
public void setconformpwd(String cpwd) {
	txtcpwd.sendKeys(cpwd);
 }

public void  setPrivacyPolicy(){
	checkpolicy.click();
 }

public void  btncountinue(){
	btnCountinue.click();
 }

public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	}catch(Exception e) {
	return (e.getMessage());
	}
}


}
