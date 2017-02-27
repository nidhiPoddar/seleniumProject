package testcases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageObjects.OrangeLogin;



public class LoginTestCase2 extends BaseClass {
	
	@Test
	public void verifyLogin()
	{
			   
		
		OrangeLogin obj = PageFactory.initElements(driver,OrangeLogin.class);
		obj.login("admin", "admin");
	}

}
