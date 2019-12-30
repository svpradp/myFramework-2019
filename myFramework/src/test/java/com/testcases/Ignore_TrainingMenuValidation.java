package com.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.pages.Page_Dashboard;
import com.pages.Page_LoginPageHRM;
import com.pages.Page_Logout;

public class Ignore_TrainingMenuValidation extends BaseClass{
	
	Page_LoginPageHRM login;
	Page_Dashboard dashboard;
	Page_Logout logout;
	
	//private static Logger mylog4j = Logger.getLogger(Ignore_TrainingMenuValidation.class);
	
	@Test
	public void TC003_FetchTrainingtabSubmenu()
	{
	
		Reporter.log("TC003 Started", true);
		
		//logger=report.createTest("TC003_FetchTrainingtabSubmenu");  --> From Mukesh
		
		extentTest= BaseClass.extentReport.createTest("TC003_FetchTrainingtabSubmenu");
		
		login = PageFactory.initElements(driver, Page_LoginPageHRM.class);
		
		logout = PageFactory.initElements(driver, Page_Logout.class);

		login.fn_login(excel.getStringData("Sheet1", 1, 0), excel.getStringData("Sheet1", 1, 1)); //--> Mukesh correction
		
		//login.fn_login(new ExcelDataProvider().getStringData("Sheet1", 1, 0), new ExcelDataProvider().getStringData("Sheet1", 1, 1));
		
		login.validateURL();
		
		//validating dashboard page
		
		dashboard = PageFactory.initElements(driver, Page_Dashboard.class);
		
		dashboard.fn_traningmenucheck();
		
		dashboard.fn_swithtoCoursesframe();
			
		extentTest.pass("Fetched all the submenus under training");
		
		Reporter.log("TC003 Complete", true);
		
		logout.logout();
		
	}
	
}
