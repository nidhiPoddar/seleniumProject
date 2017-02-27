package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Helper {
	
	@Test
	public static String screenshot(WebDriver driver)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		String path=System.getProperty("user.dir")+"/Screenshots/CRMscreenshot"+FormattingDate.getCurrentTime()+".png";
		File src = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("unable to take screenshot");
			e.printStackTrace();
		}
		return path;
	}

}
