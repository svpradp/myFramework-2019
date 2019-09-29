package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.utilities.Helper;

public class Page_LoginPageHRM {
	
	WebDriver driver;
	
	public Page_LoginPageHRM(WebDriver ldriver) 
	{
		
		this.driver = ldriver;
	}
	
	@FindBy(xpath="//input[contains(@id,'txtUsername')]") WebElement ele_uname;
	@FindBy(xpath="//input[contains(@id,'txtPassword')]") WebElement ele_pwd;
	@FindBy(xpath="//input[contains(@id,'btnLogin')]") WebElement ele_submit_button;
	
	
	
	
	public void fn_login(String username,String password)
	{
	/*	ele_uname.clear();
		ele_uname.sendKeys(username);
		
		ele_pwd.clear();
		ele_pwd.sendKeys(password);
		submit_button.click();*/
		
		//Updated info using Helper class for highlighting
		
		Helper.waitforWebElement(driver, ele_uname, 20).clear();
		
		Helper.waitforWebElement(driver, ele_uname, 20).sendKeys(username);
		
		Helper.waitforWebElement(driver, ele_pwd, 20).clear();
		
		Helper.waitforWebElement(driver, ele_pwd, 20).sendKeys(password);
		
		Helper.waitforWebElement(driver, ele_submit_button, 20).click();;
		
		 	
	}
	
	public void validateURL()
	{
		
		String title=driver.getTitle();
		
		Assert.assertEquals(title, "OrangeHRM");
	}
	

}
