package testcases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.pages.BasePage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.RegistrationPage;

import net.bytebuddy.utility.RandomString;
import testbase.BaseClass;

public class TC001_RegistrationPage extends BaseClass {
	
	@Test
	public void verify_Account_Registration() {
		logger.info("********Strting TC001_RegistrationPage ********** ");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		logger.info("********Clicked on my account link ********** ");
		hp.clickregister();
		logger.info("********Clicked on my Register link********** ");
		RegistrationPage rigister=new RegistrationPage(driver);
		logger.info("********providing customer details********** ");
		rigister.setFirstName(randomeString().toUpperCase());
		rigister.setLastName(randomeString().toUpperCase());
//		rigister.setEmail("gouthami@adc.com");
		rigister.setEmail(randomeString()+"@gmail.com");//randmly generated the email
		        String password = randomeAlphaNumeric();
		rigister.setTelephone(randomeNumeric());
		rigister.setpwd(password);
		rigister.setconformpwd(password);
		rigister.setPrivacyPolicy();
		rigister.btncountinue();
		logger.info("********Validating expected message********** ");
		String getMsg=rigister.getConfirmationMsg();
		Assert.assertEquals(getMsg, "Your Account Has Been Created!");

	}
		catch(Exception e) {
			logger.error("Text failed...");
			logger.debug("Debug logs...");
			Assert.fail();
		}
		logger.info("********Validating finished********** ");
		
	}	
	


}
