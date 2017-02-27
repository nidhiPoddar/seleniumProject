package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportsDemo {
	
	
	@Test
	public void verifyReports()
	{
		System.setProperty("webdriver.chrome.driver","D:\\SELENIUM\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/");
		
		ExtentReports report = new ExtentReports(System.getProperty("user.dir")+"/Reports/report1.html");
		
		ExtentTest logger = report.startTest("Login to CRM Orange application");
		
		logger.log(LogStatus.INFO, "Application is loaded");
			
		
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
		
		logger.log(LogStatus.PASS,"User is able to Login");
		
		report.endTest(logger);
		
		report.flush();
		
		driver.quit();
		
	}
	
	

}
