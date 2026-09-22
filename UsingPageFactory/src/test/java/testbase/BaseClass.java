package testbase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver;
	  public Logger logger;
	 public Properties p;
	@BeforeClass
	@Parameters({"os","browser"})
    public void  setup(String os, String br) throws IOException {//here we are righting browser lunching
		//Loading config.properties file
		logger=LogManager.getLogger(this.getClass());
		FileReader file=new FileReader("./src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
		
		//this is the way we can add parameters to run from setup method
		 switch(br.toLowerCase())
		 {
		 case "chrome" : driver=new ChromeDriver();break;
		 case "edge" :driver=new EdgeDriver();break;
		 case "firefox" : driver=new FirefoxDriver();break;
		 default:System.out.println("Invalid browser name"); return;
		 }
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));//reading url from properties file
		driver.manage().window().maximize();
    }
	@AfterClass
	public void  tearDown() {
		driver.quit();
	}
	//generating randome Strings
	public String randomeString(){
		  String generatedstring = RandomStringUtils.randomAlphabetic(5);
		  return generatedstring;
		  
		
	}
	public String randomeNumeric() {
		String generatednumber = RandomStringUtils.randomNumeric(10);//here no give string formate
		return generatednumber;
    
	}
	public String randomeAlphaNumeric() {
		String generatedstring = RandomStringUtils.randomAlphabetic(3);
		String generatednumber = RandomStringUtils.randomNumeric(3);
		return(generatednumber+generatednumber);
				
    
	}

}
