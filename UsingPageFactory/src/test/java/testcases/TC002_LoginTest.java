package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.MyAccountPage;

import testbase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test
	public void verify_login()
	{
		logger.info("******Starting TC002_LoginTest *******");
		
		try {
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();		
		hp.clicklogin();
	
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		Thread.sleep(3000);
	        lp.setEmail(p.getProperty("email"));
	        Thread.sleep(3000);
	        lp.setpassword(p.getProperty("password"));
	        Thread.sleep(3000);
	        lp.btnLogin();
	        
	        //MyAccount
	        MyAccountPage ap=new MyAccountPage(driver);
	            boolean tagetPage = ap.isAccountPageExists();
//	            Assert.assertEquals(tagetPage, true,"Login Failed");
	            Assert.assertTrue(tagetPage);
		}
		catch(Exception e)
		{
		Assert.fail();	
		}
	            logger.info("******Finished TC002_LoginTest *******");
		
		
	}

}
