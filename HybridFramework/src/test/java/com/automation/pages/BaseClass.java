package com.automation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigDataProvider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass 
{
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void SetUpSuite()
	{
		Reporter.log("Setting up report and test is getting ready", true);
	excel= new ExcelDataProvider();
	config= new ConfigDataProvider(); 
	ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.getCurrentDateTime()+".html"));
	report = new ExtentReports();
	report.attachReporter(extent);
	}
	@Parameters({"browser","urlTobeTested"})
	@BeforeClass
	public void openBrowser(String browser ,String url)
	{   Reporter.log("Setting done and test can be started", true);
		//driver=BrowserFactory.startApplication(driver, config.getBrowser(),config.getStagingURL());
		driver=BrowserFactory.startApplication(driver,browser,url);

	}
		
		@AfterClass
		public void closeBrowser()
		{
			 System.out.println("The Title of the Application is:"+driver.getTitle());
			 BrowserFactory.quitBrowser(driver);
	}
		@AfterMethod
		public void TearDown(ITestResult result) throws IOException
		{
			if(result.getStatus()==ITestResult.FAILURE)
			{
				logger.fail("Test failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			}
			else if(result.getStatus()==ITestResult.SUCCESS)
			{
				logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

			}
			else if(result.getStatus()==ITestResult.SKIP)
			{
				logger.skip("Test Skipped",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

			}

			report.flush();
			Reporter.log("Reports generated", true);
			
		}	
		

}
