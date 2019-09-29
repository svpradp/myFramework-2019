package com.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.pages.Page_LoginPageHRM;
import com.pages.Page_Logout;
import com.utilities.ExcelDataProvider;

public class LoginTestHRM extends BaseClass {
	
	private static Logger mylog4j = Logger.getLogger(LoginTestHRM.class);

	// WebDriver driver; ---> driver is from Baseclass
	
	Page_LoginPageHRM loginpageObj;
	Page_Logout logout;

	@Test(description="Test Description - Logging to HRM Portal ",priority=1)
	public void TC001_LogintoHRM() {

		/*
		 * excel.getStringData("Sheet1", 1, 0); sheetname, row, column report -
		 * extentreport for hmtlreporter is for reporter logger is for extenttest logger
		 * is from Extentreport used as a logger for our framework
		 */

		/*
		 * =============================================================================
		 */
		
		// For Log4j
		mylog4j.debug("This is debug message");
		mylog4j.info("This is info message");
		mylog4j.warn("This is warn message");
		mylog4j.fatal("This is fatal message");
		mylog4j.error("This is error message");
		
		
		Reporter.log("TC001 Started", true);
		
		logger = report.createTest("TC001_LogintoHRM");

		loginpageObj = PageFactory.initElements(driver, Page_LoginPageHRM.class);

		//loginpageObj.fn_login(excel.getStringData("Sheet1", 1, 0), excel.getStringData("Sheet1", 1, 1)); --> commented after cross browser testing
		
		loginpageObj.fn_login(new ExcelDataProvider().getStringData("Sheet1", 1, 0), new ExcelDataProvider().getStringData("Sheet1", 1, 1));

		logger.pass("Login Data input provided succesfully");
		
		loginpageObj.validateURL();
		
		Reporter.log("TC001 Complete", true);
		
		

	}

	@Test(dependsOnMethods = "TC001_LogintoHRM")
	public void TC002_LogoutTest() {
		
		// For Log4j
		mylog4j.debug("This is debug message");
		mylog4j.info("This is info message");
		mylog4j.warn("This is warn message");
		mylog4j.fatal("This is fatal message");
		mylog4j.error("This is error message");
		
		
		Reporter.log("TC002 Started", true);

		logger = report.createTest("TC002_LogoutTest");

		logout = PageFactory.initElements(driver, Page_Logout.class);
		
		logout.logout();
		
		Reporter.log("TC002 LogoutTest Complete", true);

	}

}
