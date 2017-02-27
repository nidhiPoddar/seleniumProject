package utility;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Validations {
	
	@Test
	public static boolean verifyErrorMsg(String actual,String expected)
	{
		boolean status = false;
		try {
			Assert.assertEquals(actual, expected);
			status= true;
		} catch (Error e) {
			
			
		}
		return status;
	}

}
