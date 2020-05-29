package org.guru99.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	static Properties pro;
	
	public ConfigDataProvider()
	{
		File file = new File("./Config/Config.properties");
		
		try
		{
		FileInputStream fis = new FileInputStream(file);
		
		pro = new Properties();
		
		pro.load(fis);
		
		}
		catch(Exception e)
		{
			System.out.println("Unable to load config file: " +e.getMessage());
		}
	}
	
	public String getDataFromFile(String keyToSearch)
	{
		return pro.getProperty(keyToSearch);
	}

}
