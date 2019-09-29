package com.testcases;

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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utilities.BrowserFactory;
import com.utilities.ConfigDataProvider;
import com.utilities.ExcelDataProvider;
import com.utilities.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public static ExtentReports report; //--> From Mukesh - changed to static
	public ExtentTest logger;
	public Helper helper;
	
	// Excel gets loaded before test suite executes
	@BeforeSuite 
	public void invokeObjects() {
		
		Reporter.log("Before Suite invoked", true);
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./myResources/Reports/"+Helper.getCurrentDate()+".html"));
		
		report = new ExtentReports();
		
		report.attachReporter(htmlreporter);
		
		Reporter.log("Before Suite invocation done, report initiated", true);
		
	}
	
	@Parameters("browser")
	@BeforeClass
	public void launchdriver(String browser) {
		
		Reporter.log("BeforeClass, driver initiation started", true);
		
		//System.out.println("launchdriver driver val:"+driver);

		//driver = BrowserFactory.startApplication(config.getBrowser(), config.getqaURL()); --> From Mukesh
		
		//driver = new BrowserFactory().startApplication(new ConfigDataProvider().getBrowser(), new ConfigDataProvider().getqaURL());
		
		driver = new BrowserFactory().startApplication(browser, new ConfigDataProvider().getqaURL());
		
		Reporter.log("BeforeClass, driver initiation done", true);
		
		System.out.println("launchdriver driver val:"+driver);
		
		helper = new Helper(driver, 30);
		
		
	}

	@AfterClass
	public void tearDownClass() {
		
		Reporter.log("AfterClass, About to quit browser", true);
		
		BrowserFactory.quitBrowser(driver);
		
		Reporter.log("AfterClass, Browser Quit done", true);
	}
	
	
	@AfterMethod
	//Runs after each method though there is an error inside the method
	//ITestResult is from TestNG
	//Flushes the status of the test through report.flush
	public void tearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Aftermethod initited. Test is about to end.", true);

		int status = result.getStatus();
		
		System.out.println("Running After method Test executed with below status");
		
		System.out.println("Current Test Name: "+result.getName());  //Prints the current @Test Method before flushing the report
		
		// status values :: 1=Pass, 2 = Fail, 3=Skip
		
		System.out.println("Result Status: " + status);
		
		if(status==ITestResult.FAILURE) //ITestResult is an interface with final values - Success, Failure, Skip
		{		
			
			//The below will fail the test after the method, attaches the screenshot to the extent report at test level
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		else if(status==ITestResult.SUCCESS) 
		{
			//The below with fail the test after the method, attaches the screenshot to the extent report at test level
			logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("Test SKIPPED - Test is not executed");
		}
		
		report.flush();
		
		Reporter.log("Aftermethod complete. Report appended with this test", true);
	
	}

}
