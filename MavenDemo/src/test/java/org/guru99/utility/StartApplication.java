package org.guru99.utility;

import org.guru99.pages.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class StartApplication extends BaseClass{
	
	public static WebDriver startApp(String browser, WebDriver driver, String url)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			
			System.setProperty(cdp.getDataFromFile("chromeKey"), cdp.getDataFromFile("chromeDriverLocation"));
			
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty(cdp.getDataFromFile("firefoxkey"), cdp.getDataFromFile("firefoxDriverLocation"));
			
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty(cdp.getDataFromFile("iekey"), cdp.getDataFromFile("ieDriverLocation"));
			
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Requested browser is not supported.");
		}
	
		driver.manage().window().maximize();
		
		driver.get(url);
		
		return driver;
		
	}
	
	

}
