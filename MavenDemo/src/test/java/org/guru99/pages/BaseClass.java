package org.guru99.pages;

import java.io.IOException;

import org.guru99.utility.ConfigDataProvider;
import org.guru99.utility.ExcelDataProvider;
import org.guru99.utility.Helper;
import org.guru99.utility.StartApplication;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	
	public WebDriver driver;
	public static ConfigDataProvider cdp;
	public static ExcelDataProvider edp;
	public ExtentReports extent;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUp()
	{
		Reporter.log("Test suite setup is started", true);
		
		cdp = new ConfigDataProvider();
		edp=new ExcelDataProvider();
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(cdp.getDataFromFile("extentReport") + Helper.getCurrentDate()+".html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		Reporter.log("Test suite setup is completed", true);
		
	}
	
	@Parameters({"browser","urlToBeTested"})
	@BeforeClass
	public void startApp(String browser, String url)
	{
		Reporter.log("Application is started in browser", true);
		
		driver=StartApplication.startApp(browser, driver,url);
		
		Reporter.log("Application is opened in the browser", true);
	}
	
	@AfterMethod
	public void verifyTest(ITestResult result) throws InterruptedException
	{
		Reporter.log("After Test method execution is started", true);
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			try {
				Thread.sleep(3000);
				logger.pass("Test is pass", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				
				System.out.println("Unable to save screenshot: " + e.getMessage());
			}
		}
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try {
				
				Thread.sleep(3000);
				logger.pass("Test is fail", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				
				System.out.println("Unable to save screenshot: " + e.getMessage());
			}
		}
		extent.flush();
		
		Reporter.log("After Test method execution is ended", true);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		
		Reporter.log("Browser is closed successfully", true);
	}
	

}
