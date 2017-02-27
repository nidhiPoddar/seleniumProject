package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HandleFrames {
	
	@Test
	public static void switchFrameUsingName(WebDriver driver, String frameName)
	{
		driver.switchTo().frame(frameName);
	}
	
	public static void switchFrameUsingId(WebDriver driver, int frameId)
	{
		driver.switchTo().frame(frameId);
	}
	
	
	public static void switchFrameUsingElement(WebDriver driver, WebElement frameEle)
	{
		driver.switchTo().frame(frameEle);
	}
	public static void switchDefaultPage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
}
