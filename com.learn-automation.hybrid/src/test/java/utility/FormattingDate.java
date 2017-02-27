package utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class FormattingDate {
	
	@Test
	public static String getCurrentTime()
	{
		DateFormat dateformat = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
		 Date date = new Date();
		 return dateformat.format(date);
	}

}
