package utility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HandleAlerts {
	
	
	
	@Test
	public static void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	public static void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public static String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
}
