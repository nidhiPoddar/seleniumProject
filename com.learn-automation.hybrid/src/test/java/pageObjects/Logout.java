package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

import utility.syncElement;

public class Logout {
	
	WebDriver driver;
	
	@Test
	public Logout(WebDriver ldriver)
	{
		this.driver = ldriver;
		
	}
	
	@FindBy(how=How.ID,using="welcome")WebElement WelcomeLink;
	@FindBy(how=How.XPATH,using="//a[text()='Logout']")WebElement logoutLink;
	
	
	
	
	public void logout()
	{
		
		syncElement.waitForElement(WelcomeLink, driver).click();
		syncElement.waitForElement(logoutLink, driver).click();
	}

}
