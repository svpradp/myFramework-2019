package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties prop;
	
	public ConfigDataProvider() {
		
		File src = new File("./myResources/Config/Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			prop = new Properties();
			
			prop.load(fis);
			
		} catch (Exception e) {
			
			System.out.println("Unable to load file: "+e.getMessage());
			
		} 
		
	}
	
	
	
	public String getDatafromConfig(String searchKey)
	{
		
		return prop.getProperty(searchKey);
	}
	
	public String getBrowser()
	{
		return prop.getProperty("Browser");
	}
	
	public String getqaURL()
	{
		
		return prop.getProperty("qaURL");
	}

}
