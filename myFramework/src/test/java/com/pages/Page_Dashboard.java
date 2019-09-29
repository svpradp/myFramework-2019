package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utilities.Helper;

public class Page_Dashboard {

	WebDriver driver;

	Helper helper;

	public Page_Dashboard(WebDriver ldriver) {
		this.driver = ldriver;
	}

	// Training Menu
	@FindBy(xpath = "//li[contains(@id,'defaultTrainingModulePage')]")
	WebElement ele_trainingmenu;

	@FindBy(xpath = "//li[contains(@id,'defaultTrainingModulePage')]//div[@class='collapsible-body']/ul/li[@class='level2']")
	List<WebElement> ele_list_tra_submenu;

	// Courses under Training
	@FindBy(xpath="//*[@id=\"menu_training_viewCourseList\"]") WebElement ele_viewcourselist;

	// Courses iframe
	@FindBy(xpath = "//iframe[@id='noncoreIframe']")
	WebElement ele_iframe_courses;

	// Courses icon
	@FindBy(xpath = "//span[text()='Courses']")
	WebElement courses;
	
	//Add Course + icon
	@FindBy(xpath="//i[contains(.,'add')]") WebElement addCourse;

	public void fn_traningmenucheck() {

		ele_trainingmenu.click();

		int i = 1;

		for (WebElement ele : ele_list_tra_submenu) {

			System.out.println("Submenu under traing: " + i + ":" + ele.getText());

			i = i + 1;
		}

	}

	public void fn_swithtoCoursesframe() {

		Helper.waitforWebElement(driver, ele_viewcourselist, 20).click();
	
		Helper.switchtoFrame(driver, ele_iframe_courses);
		
		Helper.waitforWebElement(driver, courses, 20).click();
		
		Helper.waitforWebElement(driver, addCourse, 10).click();
	}

}
