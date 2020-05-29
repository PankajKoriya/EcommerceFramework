package org.guru99.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	@FindBy(how=How.NAME, using="login[username]")
	WebElement email_txt;
	
	@FindBy(how=How.NAME, using ="login[password]")
	WebElement pass_txt;
	
	@FindBy(how=How.ID ,using="send2")
	WebElement login_btn;
	
	public void login(String uName, String pass)
	{
		email_txt.sendKeys(uName);
		pass_txt.sendKeys(pass);
		login_btn.click();
	}
}
