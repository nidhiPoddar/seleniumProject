package factory;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	
	  WebDriver driver = null;
	
	 //**
	 
	public  WebDriver startBrowser(String browserName,String appURL)
	
	{
		
			if(browserName.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
				
			}
			else if(browserName.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "D:\\SELENIUM\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browserName.equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.ie.driver", "D:\\SELENIUM\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				
			}
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get(appURL);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			return driver;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
