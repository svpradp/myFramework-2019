package com.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pages.Page_AddEmployee;
import com.pages.Page_Dashboard;
import com.pages.Page_LoginPageHRM;
import com.pages.Page_Logout;
import com.utilities.ExcelDataProvider;

public class AddEmployee extends BaseClass {

	Page_LoginPageHRM loginPageObj;
	Page_Dashboard dashboardObj;
	Page_AddEmployee addEmpObj;
	Page_Logout logoutPageObj;

	@Test
	public void TC004_AddEmployee() throws Exception {

		Reporter.log("TC004 - Add Employee", true);

		// Page Objects initiation using PageFactory
		loginPageObj = PageFactory.initElements(driver, Page_LoginPageHRM.class);
		addEmpObj = PageFactory.initElements(driver, Page_AddEmployee.class);
		dashboardObj = PageFactory.initElements(driver, Page_Dashboard.class);
		logoutPageObj = PageFactory.initElements(driver, Page_Logout.class);

		extentTest = BaseClass.extentReport.createTest("TC004_AddEmployee");

		loginPageObj.fn_login(new ExcelDataProvider().getStringData("Sheet1", 1, 0),
				new ExcelDataProvider().getStringData("Sheet1", 1, 1));

		extentTest.log(Status.INFO, "Login Data provided succesfully");

		loginPageObj.validateURL();

		dashboardObj.fn_addEmployeenav();

		addEmpObj.enterDetails();

		Reporter.log("TC004 - Add Employee End", true);

		extentTest.log(Status.INFO, "Details submitted succesfully");

		logoutPageObj.logout();

		//extentTest.log(Status.INFO, "Logged Out");
		

	}

}
