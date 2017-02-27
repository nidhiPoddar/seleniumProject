package dataProvider;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ConfigReader {
	
	
	Properties pro;
	
	public ConfigReader()
	{
		File src = new File(System.getProperty("user.dir")+"/Configuration/config.properties");	
		 
		try {
			 
			FileInputStream fis= new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to load config file**  "+e.getMessage());
			e.printStackTrace();
		}
		
	}
	public String getBrowser()
	{
		
		String browser = pro.getProperty("browser");
		return browser;
	}
	
	public String getAppURL()
	{
		
		String appURL = pro.getProperty("appURL");
		return appURL;
	}

}
