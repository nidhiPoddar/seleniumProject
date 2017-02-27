package testcases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.OrangeLogin;
import utility.Helper;

import dataProvider.ExcelDataProvider;
import factory.ExcelFactory;
public class LoginTestCase5 extends BaseClass_forLoginTC5 {
	
	
	@BeforeMethod
	public void setUp()
	{
		logger.log(LogStatus.INFO, "Starting Testcase");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		
		/*if(result.getStatus()== ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL, logger.addScreenCapture(Helper.screenshot(driver)));
		}*/
		logger.log(LogStatus.INFO, "Ending Testcase");
		
	}
	
	@Test
	public void verifyLogin()
	{
			   
	 for(int i=1;i<4;i++)
	 {	
		
		 
		 
		 OrangeLogin obj = PageFactory.initElements(driver,OrangeLogin.class);
		
		logger.log(LogStatus.INFO, "Application is loaded");
		
		obj.login(ExcelFactory.setExcel().getStringData("Login", i, 0), ExcelFactory.setExcel().getStringData("Login", i, 1));
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		String myURL = driver.getCurrentUrl();
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		boolean status=false;
		
		try {
			WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='menu_admin_viewAdminModule']")));
			
			status = ele.isDisplayed();
		} catch (Exception e) {
			System.out.println("the Admin tab is not present");
		}
		
		if(status)
		{
			logger.log(LogStatus.PASS, "User is able to login. the credentials are valid");
			logger.log(LogStatus.PASS,logger.addScreenCapture(Helper.screenshot(driver)));
			driver.findElement(By.xpath(".//*[@id='welcome']")).click();
			driver.findElement(By.xpath(".//*[@id='welcome-menu']/ul/li[2]/a")).click();
			
		}
		else
		{
			logger.log(LogStatus.FAIL, "User is not able to login. the credentials are invalid");
			//logger.log(LogStatus.PASS,logger.addScreenCapture(Helper.screenshot(driver)));
			//Assert.assertTrue(status);
		}
		
		
		if(myURL.contains("dashboard"))
		{
			logger.log(LogStatus.PASS, "the User has logged in");
		}
		else
		{
			logger.log(LogStatus.FAIL, "User has not logged in. ");
			logger.log(LogStatus.PASS,logger.addScreenCapture(Helper.screenshot(driver)));
			
		}
		
		
	}
	}
}
