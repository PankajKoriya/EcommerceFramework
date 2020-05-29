package org.guru99.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyOrderPage {
	
	@FindBy(xpath="(//table[@id='my-orders-table']/tbody/tr/td[6]/span/a)[1]")
	WebElement viewOrder_link;
	
	@FindBy(linkText="Print Order")
	WebElement printOrder_link;
	
	public void clickOnViewOrderLink()
	{
		viewOrder_link.click();
	}
	
	public void clickOnPrintOrderLink()
	{
		printOrder_link.click();
	}

}
