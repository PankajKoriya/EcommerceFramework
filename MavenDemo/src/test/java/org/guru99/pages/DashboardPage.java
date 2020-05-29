package org.guru99.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {
	
	@FindBy(xpath="//table[@id='my-orders-table']/tbody//tr[@class='first odd']//td[@class='number']")
	WebElement orderNumber_lbl;
	
	@FindBy(xpath="//a[text()='My Orders']")
	WebElement myOrders_link;
	
	@FindBy(xpath="(//table[@id='my-orders-table']/tbody/tr/td[5])[1]")
	WebElement orderStatus_lbl;
	
	public String verifyOrderNumber()
	{
		return orderNumber_lbl.getText();
	}
	
	public String verifyOrderStatus()
	{
		return orderStatus_lbl.getText();
	}
	
	public void clickOnMyOrderLink()
	{
		myOrders_link.click();
	}
	
	

}
