package org.guru99.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Homepage {
	
	@FindBy(how=How.XPATH, using=".//div[@class='account-cart-wrapper']/a/span[2]") 
	WebElement account_link;
	
	@FindBy(how=How.XPATH, using=".//div[@id='header-account']/div/ul/li//a[text()='My Account']")
	WebElement myAccount_link;
	
	public void clickOnAccountLink()
	{
		account_link.click();
	}
	
	public void clickOnMyAccountLink()
	{
		myAccount_link.click();
	}

}
