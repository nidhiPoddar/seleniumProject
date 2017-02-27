package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.ITest;

import dataProvider.ConfigReader;
import factory.BrowserFactory;
import factory.ConfigFactory;
import utility.Helper;


public class BaseClass_forLoginTC5 {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	/*@BeforeSuite
	public void startReport()
	{
		
		report = new ExtentReports(System.getProperty("user.dir")+"/Reports/CRMreport"+System.currentTimeMillis()+".html");
		
		 logger = report.startTest("the CRM APPLICATION Report");
		
	}
	
	@AfterSuite
	public void closeReport(){
		
		
		report.flush();
	}*/
	
	
	
	@Parameters({"browser"})
	@BeforeTest
	public void startBrowserBaseClass(String browser)
	{
				/*// this piece of code is before setting ConfigDataFactory class in factory package
		ConfigReader obj = new ConfigReader();
		String browser = obj.getBrowser();
		String appURL = obj.getAppURL();
			
		driver = BrowserFactory.startBrowser(browser,appURL); */
		
		// following piece of code is after shifting above code in a ConfigDataFactory class
		
		//driver = BrowserFactory.startBrowser(ConfigDataFactory.setConfigReader().getBrowser(),ConfigDataFactory.setConfigReader().getAppURL());
		
		report = new ExtentReports(System.getProperty("user.dir")+"/Reports/CRMreport"+System.currentTimeMillis()+".html");
		
		 logger = report.startTest("the CRM APPLICATION Report");
		
		driver = new BrowserFactory().startBrowser(browser, ConfigFactory.setConfig().getAppURL());
	
	}
	
	
	
	@AfterTest
	public void closeBrowser()
	{
		report.endTest(logger);
		report.flush();
		driver.close();
	}
}
