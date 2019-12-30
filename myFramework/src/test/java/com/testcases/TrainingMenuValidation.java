package com.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pages.Page_Dashboard;
import com.pages.Page_LoginPageHRM;
import com.pages.Page_Logout;
import com.utilities.ExcelDataProvider;

public class TrainingMenuValidation extends BaseClass {

	Page_LoginPageHRM loginObj;
	Page_Logout logoutObj;
	Page_Dashboard dashObj;

	@Test
	public void TC003_FetchTrainingMenu() {

		Reporter.log("TC003_FetchTrainingMenu Started", true);

		extentTest = BaseClass.extentReport.createTest("TC003_FetchTrainingMenu");

		Reporter.log("TC003_Initiating Page objects", true);

		loginObj = PageFactory.initElements(driver, Page_LoginPageHRM.class);
		logoutObj = PageFactory.initElements(driver, Page_Logout.class);
		dashObj = PageFactory.initElements(driver, Page_Dashboard.class);

		Reporter.log("TC003_Initiating Page objects - Done", true);

		loginObj.fn_login(new ExcelDataProvider().getStringData("Sheet1", 1, 0),
				new ExcelDataProvider().getStringData("Sheet1", 1, 1));

		loginObj.validateURL();

		dashObj.fn_traningmenucheck();

		dashObj.fn_swithtoCoursesframe();

		//extentTest.pass("Fetched all the submenus under training");
		
		extentTest.log(Status.INFO, "Fetched all the submenus under Training");

		Reporter.log("TC003_FetchTrainingMenu", true);

		logoutObj.logout();

	}

}
