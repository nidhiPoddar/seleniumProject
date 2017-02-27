package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class syncElement {

	@Test
	public static WebElement waitForElement(WebElement ele,WebDriver ldriver){
		
		WebDriverWait wait =new WebDriverWait(ldriver,10);
		
		WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));
		return element;
		
		
	}
}
