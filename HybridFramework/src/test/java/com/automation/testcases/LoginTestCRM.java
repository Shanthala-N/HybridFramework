package com.automation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;

public class LoginTestCRM extends BaseClass
{
	@Test
	public void LoginApp()
	{
	 
	  logger=	report.createTest("Login to CRM");
			
      LoginPage login_page=PageFactory.initElements(driver,LoginPage.class);
      
      logger.info("Starting Application");
     
	  login_page.LoginToCRM(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
	  
	  logger.pass("Login Succesful");
	}
	
		
		}


 
