package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import pageObjects.OrangeLogin;

public class LoginTestCase1 {
	WebDriver driver;
	
	
	@Test
	public void verifyLogin()
	{
		
		
		
		
		
		 driver = new BrowserFactory().startBrowser("chrome", "http://opensource.demo.orangehrmlive.com/");   
		OrangeLogin obj = PageFactory.initElements(driver,OrangeLogin.class);
		obj.login("admin", "admin");
		
		

		
		
		
		
	}

}
