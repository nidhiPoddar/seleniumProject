package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import factory.BrowserFactory;
import factory.ConfigFactory;
import utility.FormattingDate;


public class BaseClass {
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
	
	
	
	//@Parameters({"browser"})
	// this header is used if parameter above stmt is used
	//public void startBrowserBaseClass(String browser)
	@BeforeTest
	public void startBrowserBaseClass()
	{
				/*// this piece of code is before setting ConfigDataFactory class in factory package
		ConfigReader obj = new ConfigReader();
		String browser = obj.getBrowser();
		String appURL = obj.getAppURL();
			
		driver = BrowserFactory.startBrowser(browser,appURL); */
		
		// following piece of code is after shifting above code in a ConfigDataFactory class
		
		//driver = BrowserFactory.startBrowser(ConfigDataFactory.setConfigReader().getBrowser(),ConfigDataFactory.setConfigReader().getAppURL());
		
		report = new ExtentReports(System.getProperty("user.dir")+"/Reports/CRMreport"+FormattingDate.getCurrentTime()+".html");
		
		 logger = report.startTest("the CRM APPLICATION Report");
		 System.out.println("============Starting Browser============");
		
		driver = new BrowserFactory().startBrowser(ConfigFactory.setConfig().getBrowser(), ConfigFactory.setConfig().getAppURL());
		
		 System.out.println("============Browser is up n running============");
	
	}
	
	
	
	@AfterTest
	public void closeBrowser()
	{
		report.flush();
		driver.close();
	}
}
