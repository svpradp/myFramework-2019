package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utilities.Helper;

public class Page_Logout {
	
	WebDriver driver;
	
	public Page_Logout(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
	@FindBy(xpath="//i[text()='keyboard_arrow_down']") WebElement navlogoutMenu;
	
	@FindBy(xpath="//a[text()='Logout']") WebElement logout;
	
	
	public void logout()
	{
		
		Helper.waitforWebElement(driver, navlogoutMenu, 20).click();
		
		Helper.waitforWebElement(driver, logout, 20).click();
		
	}

}
