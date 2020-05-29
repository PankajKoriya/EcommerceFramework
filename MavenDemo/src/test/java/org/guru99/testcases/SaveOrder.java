package org.guru99.testcases;

import org.guru99.pages.BaseClass;
import org.guru99.pages.DashboardPage;
import org.guru99.pages.Homepage;
import org.guru99.pages.LoginPage;
import org.guru99.pages.MyOrderPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SaveOrder extends BaseClass{

	@Test
	public void saveOrderAsPdf()
	{
		logger = extent.createTest("Save order as PDF");

		Homepage hp = PageFactory.initElements(driver, Homepage.class);

		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);

		DashboardPage dp = PageFactory.initElements(driver, DashboardPage.class);

		MyOrderPage mop = PageFactory.initElements(driver, MyOrderPage.class);

		hp.clickOnAccountLink();
		logger.info("User clicked on Account link");

		hp.clickOnMyAccountLink();
		logger.info("User clicked on My Account link");

		lp.login(edp.getStringData("Login", 0, 0), edp.getStringData("Login", 0, 1));
		logger.info("User is logged into Application");

		//String orderNumber = dp.verifyOrderNumber();

		//Assert.assertTrue(orderNumber.equalsIgnoreCase("100012104"));

		//String orderStatus = dp.verifyOrderStatus();

		//Assert.assertTrue(orderStatus.equalsIgnoreCase("Pending"));

		dp.clickOnMyOrderLink();
		logger.info("User clicked on My order link");

		mop.clickOnViewOrderLink();
		logger.info("User clicked on view order link");

		//mop.clickOnPrintOrderLink();
		//logger.info("User clicked on Prine Order link");

		
	}

}
