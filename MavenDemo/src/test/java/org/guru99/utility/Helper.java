package org.guru99.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String dest = "./Screenshots/Ecommerce_" + getCurrentDate() + ".png";
		
		try 
		{
			FileHandler.copy(src, new File(dest));
		} 
		catch (IOException e) 
		{
			System.out.println("Unable to save screenshot:" +e.getMessage());
		}
		return dest;
		
	}
	
	public static void explicitWait(WebDriver driver, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static String getCurrentDate()
	{
		Date date = new Date();
		
		SimpleDateFormat formatDate = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		return formatDate.format(date);
	}

}
