package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.ExcelFactory;
import utility.Validations;
import utility.syncElement;

public class OrangeLogin {
	
	 WebDriver driver;
	
	public OrangeLogin(WebDriver ldriver){
		this.driver = ldriver;
	}
		
	@FindBy(id="txtUsername") WebElement username;
	@FindBy(name="txtPassword") WebElement password;
	@FindBy(xpath="//input[@id='btnLogin']") WebElement loginButton;
	@FindBy(xpath="//*[text()='Password cannot be empty']")WebElement passwordErrorMsg;
	
	//Methods
	
	public void login(String uname,String myPassword)
	{
		syncElement.waitForElement(username, driver).sendKeys(uname);
		//username.sendKeys(uname);
		
		syncElement.waitForElement(password, driver).sendKeys(myPassword);
		//password.sendKeys(myPassword);
		
		syncElement.waitForElement(loginButton, driver).click();
		//loginButton.click();
	}
	
	public boolean verifyPasswordError(String sheetName,int row,int col)
	{
		String actual=passwordErrorMsg.getText();
		System.out.println("Error msg captured is >>> "+actual);
		ExcelFactory.setExcel().writeData(sheetName, row, col, actual);
		
		
		
		String expected = "Password cannot be empty";
		boolean status = Validations.verifyErrorMsg(actual, expected);
		return status;
	}
	
	public void typeUsername(String uname)
	{
		syncElement.waitForElement(username, driver).sendKeys(uname);
		
	}
	
	public void clickLogin()
	{
		syncElement.waitForElement(loginButton, driver).click();
		
	}
}
