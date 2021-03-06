package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	 
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	@FindBy(name="username") WebElement uname;
	
	@FindBy(name="password") WebElement password;
	 @FindBy(xpath="//input[@value='Login']") WebElement LoginButton;
	 
	 public void LoginToCRM(String AppnUserName, String AppnPassword)
	 {
		 try {
				 uname.sendKeys(AppnUserName);
				 password.sendKeys(AppnPassword);
				 LoginButton.click();
				 	Thread.sleep(5000);
           } catch (InterruptedException e) 
	
		 {
	          }
   }

}
