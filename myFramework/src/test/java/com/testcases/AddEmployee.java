package com.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.pages.Page_AddEmployee;
import com.pages.Page_Dashboard;
import com.pages.Page_LoginPageHRM;
import com.pages.Page_Logout;
import com.utilities.ExcelDataProvider;

public class AddEmployee extends BaseClass{
	
	Page_LoginPageHRM loginPageObj;
	Page_Dashboard dashboardObj;
	Page_AddEmployee addEmpObj;
	Page_Logout logoutPageObj;
	
	
	@Test
	public void addEmployee() throws Exception
	{
		
		Reporter.log("TC004 - Add Employee Started",true);
		
		//Page Objects initiation using PageFactory
		loginPageObj = PageFactory.initElements(driver, Page_LoginPageHRM.class);
		addEmpObj = PageFactory.initElements(driver, Page_AddEmployee.class);
		dashboardObj = PageFactory.initElements(driver, Page_Dashboard.class);
		logoutPageObj = PageFactory.initElements(driver, Page_Logout.class);
		
		logger = BaseClass.report.createTest("TC004_AddEmployee");
		
		//FACING NULL POINTER HERE - TRIED BOTH THE OPTIONS BELOW
		
		//loginPageObj.fn_login(excel.getStringData("Sheet1", 1, 0), excel.getStringData("Sheet1", 1, 1));
		
		loginPageObj.fn_login(new ExcelDataProvider().getStringData("Sheet1", 1, 0), new ExcelDataProvider().getStringData("Sheet1", 1, 1));
		
		logger.pass("Login Data provided succesfully");
		
		loginPageObj.validateURL();
		
		dashboardObj.fn_addEmployeenav();
		
		addEmpObj.enterDetails();
		
		Reporter.log("TC004 - Add Employee End",true);
		
		logoutPageObj.logout();
		
	}
	
}
