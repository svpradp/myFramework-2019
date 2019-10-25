package com.pages;

import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.utilities.Helper;

public class Page_AddEmployee {

	WebDriver driver;

	public Page_AddEmployee(WebDriver ldriver) {
		this.driver = ldriver;
	}

	// Add Employee - Pop Up
	@FindBy(xpath = "//form[@id='pimAddEmployeeForm']//following::input[@id=\"firstName\"]")
	WebElement fname;
	@FindBy(xpath = "//form[@id='pimAddEmployeeForm']//following::input[@id=\"lastName\"]")
	WebElement lname;
	@FindBy(xpath = "//*[text()='Location']//following::input[@value='-- Select --']")
	WebElement location;
	@FindBy(xpath="//div[@class='select-wrapper initialized']//following::span")
	List<WebElement> loclist;
	@FindBy(xpath = "//a[text()='Next']")
	WebElement nextBut;
	
	//div[@class='select-wrapper initialized']//following::span[contains(text(),'Indian Development Center')]
	
	@FindBy(xpath="(//div[@class='picker']//following::i[text()='date_range'])[1]")
	WebElement dob;
	
	/*@FindBy(xpath="(//div[@class='picker__box']//following::div[@title='Next month'])[1]")
	WebElement nextMon;*/
	
	@FindBy(xpath="//div[@class='select-wrapper picker__select--year']")
	WebElement dob_year;
	
	
	@FindBy(xpath="//div[@class='select-wrapper picker__select--year']//following::span[contains(text(),'1972')]")
	WebElement dob_year_sel;
	
	@FindBy(xpath="//div[@class='select-wrapper picker__select--month']")
	WebElement dob_mon;
	
	@FindBy(xpath="//div[@class='select-wrapper picker__select--month']//following::span[contains(text(),'October')]")
	WebElement dob_mon_sel;
	
	@FindBy(xpath="//table//following::div[text()='25']")
	WebElement dob_date_sel;
	
	//Marital Status
	@FindBy(xpath="(//div[@id='emp_marital_status_inputfileddiv']//following::input[@value='-- Select --'])[1]")
	WebElement marital_stat;
	@FindBy(xpath="//div[@id='emp_marital_status_inputfileddiv']//following::span[contains(text(),'Married')]")
	WebElement marital_stat_sel;
	
	//Gender
	@FindBy(xpath="//label[@for='emp_gender_1' and text()='Male']")
	WebElement gender;
	
	//Nationality
	@FindBy(xpath="//div[@id='nation_code_inputfileddiv']")
	WebElement nationality;
	@FindBy(xpath="//div[@id='nation_code_inputfileddiv']//following::span[text()='Indian']")
	WebElement nationality_sel;
	
	//Expiry Date
	@FindBy(xpath="(//div[@class='picker']//following::i[text()='date_range'])[2]")
	WebElement dl_exp_dateicon;
	
	@FindBy(xpath="(//div[@class='picker__box']//following::div[@title='Next month'])[2]")
	WebElement dl_exp_next;
	
	@FindBy(xpath="(//div[@class='select-wrapper picker__select--year'])[2]")
	WebElement dl_exp_year;
	
	@FindBy(xpath="(//div[@class='select-wrapper picker__select--year'])[2]//following::span[contains(text(),'2022')]")
	WebElement dl_year_sel;
	
	@FindBy(xpath="(//table[@class='picker__table']//following::div[text()='22'])[2]")
	WebElement dl_date_sel;
	
	@FindBy(xpath="//label[@for='smoker']")
	WebElement smoker_chkbox;
	
	@FindBy(xpath="//div[@id='1_inputfileddiv']")
	WebElement bldgrp;
	
	@FindBy(xpath="//div[@id='1_inputfileddiv']//following::span[text()='O']")
	WebElement bldgrp_sel;
	
	@FindBy(xpath="//*[text()='Hobbies']//preceding::*[@id=\"5\" and @type='text']")
	WebElement hobbies;
	
	@FindBy(xpath="//*[text()='Hobbies']//preceding::*[@id=\"5\" and @type='text']//following::button[text()='Next']")
	WebElement next_form_submit;
	
	//Region
	@FindBy(xpath="(//*[text()='Region']//preceding::input[@type='text' and contains(@value,'Select')])[6]")
	WebElement region;
	@FindBy(xpath="(//*[text()='Region']//preceding::input[@type='text' and contains(@value,'Select')])[6]//following::span[text()='Region-3']")
	WebElement region_sel;
	
	
	//FTE
	@FindBy(xpath="(//*[text()='Region']//following::input[@type='text' and contains(@value,'Select')])[1]")
	WebElement fte;
	@FindBy(xpath="(//*[text()='Region']//following::input[@type='text' and contains(@value,'Select')])[1]//following::span[text()='1']")
	WebElement fte_sel;
	
	//Temp Dept
/*	@FindBy(xpath="((//*[text()='Region']//following::input[@type='text' and contains(@value,'Select')])[1]")
	WebElement dept;
	@FindBy(xpath="(//*[text()='Region']//following::input[@type='text' and contains(@value,'Select')])[1]//following::span[text()='Sub unit-1']")
	WebElement dept_sel;*/
	
	@FindBy(xpath="(//div[@class='select-wrapper initialized'])[6]")
	WebElement dept;
	
	@FindBy(xpath="(//div[@class='select-wrapper initialized'])[6]//following::span[text()='Sub unit-3']")
	WebElement dept_sel;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement save;
	
	@FindBy(xpath="//div[@class=\"toast toast-success\"]/div")
	WebElement saveSuccess;


	// Add Employee Personal Details Screen
	// https://sqa.stackexchange.com/questions/22995/how-to-select-a-value-form-drop-down-list-using-page-object-model/22996

	
	public void enterDetails() throws InterruptedException
	{
		
		Helper.waitforWebElement(driver, fname, 20).sendKeys("Learn");
		Helper.waitforWebElement(driver, lname, 20).sendKeys("Automation");
		Helper.waitforWebElement(driver, location, 20).click();
		fn_selectloc();
		Helper.waitforWebElement(driver, nextBut,20).click();
		
		//addEmployee popup to mainscreen
		Helper.waitforWebElement(driver,dob, 20).click();
		Helper.waitforWebElement(driver,dob_year, 20).click();
		Helper.waitforWebElement(driver,dob_year_sel, 20).click();
		Helper.waitforWebElement(driver,dob_mon, 20).click();
		Helper.waitforWebElement(driver,dob_mon_sel, 20).click();		
		Helper.waitforWebElement(driver,dob_date_sel, 20).click();
		
		//Marital Status
		Helper.waitforWebElement(driver, marital_stat, 20).click();
		Helper.waitforWebElement(driver, marital_stat_sel, 20).click();
		
		//Gender
		Helper.waitforWebElement(driver, gender, 20).click();
		
		//Helper.scrollintoview(driver, nationality);
		
		Helper.waitforWebElement(driver, nationality, 20).click();
		Helper.waitforWebElement(driver, nationality_sel, 20).click();
		
		//DL
		Helper.waitforWebElement(driver, dl_exp_dateicon, 20).click();
		Helper.waitforWebElement(driver, dl_exp_next, 20).click();
		Helper.waitforWebElement(driver, dl_exp_next, 20).click();
		Helper.waitforWebElement(driver, dl_exp_year, 20).click();
		Helper.waitforWebElement(driver,dl_year_sel, 20).click();
		Helper.waitforWebElement(driver, dl_date_sel, 20).click();
		
		Helper.waitforWebElement(driver,bldgrp, 20).click();
		
		Helper.waitforWebElement(driver, bldgrp_sel, 20).click();
		
		Helper.waitforWebElement(driver, hobbies, 20).sendKeys("My Hobbies");
		
		Helper.waitforWebElement(driver, next_form_submit, 20).click();
		
		Helper.waitforWebElement(driver, region, 20).click();
		Helper.waitforWebElement(driver, region_sel, 20).click();
		
		Helper.waitforWebElement(driver, fte, 20).click();
		Helper.waitforWebElement(driver, fte_sel, 20).click();
		
		Helper.waitforWebElement(driver, dept, 20).click();
		Helper.waitforWebElement(driver, dept_sel, 20).click();
		
		Helper.waitforWebElement(driver, save, 20).click();
		
		String successtext = Helper.waitforWebElement(driver, saveSuccess, 20).getText();
		
		SoftAssert sAssert= new SoftAssert();
		sAssert.assertEquals(successtext, "Successfully Saved");
		
		sAssert.assertAll();
		
		Thread.sleep(2000);
	}
	
	
	
	public void fn_selectloc() {

		for(WebElement ele : loclist) {

			String eachLoc = ele.getText();

			System.out.println("Location: " + eachLoc);

			if (eachLoc.contains("Indian Development Center")) {

				ele.click();
				break;
			}

		}

	}

}
