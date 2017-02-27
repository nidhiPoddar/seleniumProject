package testcases;


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
public class LoginNegative extends BaseClass {
	
	
	@BeforeMethod
	public void setUp()
	{
		logger.log(LogStatus.INFO, "Starting Testcase");
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		
		if(result.getStatus()== ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL, logger.addScreenCapture(Helper.screenshot(driver)));
		}
		logger.log(LogStatus.INFO, "Ending Testcase");
		report.endTest(logger);
	}
	
	@Test
	public void verifyLogin()
	{
			   
		
		OrangeLogin obj = PageFactory.initElements(driver,OrangeLogin.class);
		
		logger.log(LogStatus.INFO, "Application is loaded");
		
		obj.typeUsername(ExcelFactory.setExcel().getStringData("Login", 1, 0));
		obj.clickLogin();
		
		boolean status= obj.verifyPasswordError("Login",1,2);		
		
		if(status)
		{
			logger.log(LogStatus.PASS, "User is not able to login. the credentials are invalid");
			logger.log(LogStatus.PASS,logger.addScreenCapture(Helper.screenshot(driver)));
			
		}
		else
		{
			logger.log(LogStatus.FAIL, "User is able to login. the credentials are valid");
			logger.log(LogStatus.FAIL,logger.addScreenCapture(Helper.screenshot(driver)));
			Assert.assertTrue(status);
		}
		
		
		
		
		
	}

}
