package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	List<WebElement> locationSel;
	@FindBy(xpath = "//a[text()='Next']")
	WebElement nextBut;

	// Add Employee Personal Details Screen
	// https://sqa.stackexchange.com/questions/22995/how-to-select-a-value-form-drop-down-list-using-page-object-model/22996

	public void fn_selectloc() {

		for(WebElement ele : locationSel) {

			String eachLoc = ele.getText();

			System.out.println("Location: " + eachLoc);

			if (eachLoc.contains("Indian Development Center")) {

				ele.click();
				break;
			}

		}

	}

}
