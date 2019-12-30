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
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.utilities.BrowserFactory;
import com.utilities.ConfigDataProvider;
import com.utilities.ExcelDataProvider;
import com.utilities.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public Helper helper;
	
	/* Extent Report Related */
	public ExtentHtmlReporter htmlreporter;
	public static ExtentReports extentReport; //--> From Mukesh - changed to static
	public ExtentTest extentTest;
	
	//public ExtentReports extentReport;
	
	
	// Excel gets loaded before test suite executes
	@BeforeSuite 
	public void invokeObjects() {
		
		Reporter.log("Before Suite invoked", true);
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		//htmlreporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./myResources/Reports/"+Helper.getCurrentDate()+".html"));
		
		htmlreporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./myResources/Reports/TestExecutionReport.html"));
		
	    //configuration items to change the look and feel
        //add content, manage tests etc
		htmlreporter.config().setReportName("Test Results Report");
		htmlreporter.config().setAutoCreateRelativePathMedia(true);
		htmlreporter.config().setDocumentTitle("Orange HRM Report");
		htmlreporter.config().setEncoding("utf-8");
		htmlreporter.config().setJS("Status Report");
		htmlreporter.config().setProtocol(Protocol.HTTPS);
		htmlreporter.config().setTheme(Theme.STANDARD);
		htmlreporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		
		extentReport = new ExtentReports();
		
		extentReport.attachReporter(htmlreporter);
		
		Reporter.log("Before Suite invocation done, report initiated", true);
		
	}
	
	@Parameters({"browser","appURL"})
	@BeforeClass
	public void launchdriver(String browser, String url) {
		
		Reporter.log("BeforeClass, driver initiation started", true);
		
		//System.out.println("launchdriver driver val:"+driver);

		//driver = BrowserFactory.startApplication(config.getBrowser(), config.getqaURL()); --> From Mukesh
		
		//driver = new BrowserFactory().startApplication(new ConfigDataProvider().getBrowser(), new ConfigDataProvider().getqaURL());
		
		BrowserFactory browserObj = new BrowserFactory();
		
		driver = browserObj.startApplication(browser,url);
		
		//driver = new BrowserFactory().startApplication(browser, url);
		
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
	
	
	/*Runs after each method though there is an error inside the method
	  ITestResult is from TestNG
	  Flushes the status of the test through report.flush */	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Aftermethod initited. Test is about to end.", true);

		int status = result.getStatus();
		
		String testName = result.getName();
		
		System.out.println("Running After method Test executed with below status");
		
		System.out.println("Current Test Name: "+result.getName());  //Prints the current @Test Method before flushing the report
		
		// status values :: 1=Pass, 2 = Fail, 3=Skip
		
		System.out.println("Result Status: " + status);
		
		if(status==ITestResult.FAILURE) //ITestResult is an interface with final values - Success, Failure, Skip
		{	
			
			//The below will fail the test after the method, attaches the screenshot to the extent report at test level
			
			extentTest.log(Status.FAIL, "Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
			extentTest.fail(result.getThrowable());
		}
		
		else if(status==ITestResult.SUCCESS) 
		{
			//The below with fail the test after the method, attaches the screenshot to the extent report at test level
			extentTest.log(Status.PASS, "Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
		
		else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println(testName+"Test SKIPPED - Test is not executed");
			
			extentTest.skip(result.getThrowable());
		}
		
		extentReport.flush();
		
		Reporter.log("Report appended with this test result", true);
		
		
	
	}

}
