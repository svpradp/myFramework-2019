package com.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

	/*
	 * To Capture Screenshot To Handle Frames To Handle Alerts Multiple windows
	 * method to sync issues JavaScript Executor Highlight Element
	 */

	// Methods related to waits
	WebDriverWait wait;

	public Helper(WebDriver driver, int time) {

		wait = new WebDriverWait(driver, 30);

		// wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	// Switch to Frame. Wait until frame to be available and then switch to it

	public static void switchtoFrame(WebDriver driver, WebElement frameEle) {
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameEle));
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameEle));
	}

	// Wait for webelement to disappear - Helps in proper clicking of an element -
	// Method overloading

	public boolean waitforElementDisappear(String xpath) {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}

	public boolean waitforElementDisappear(WebElement ele) {
		return wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	//this method returns currrent date in the expected format
	public static String getCurrentDate() {
		
		DateFormat customFormat = new SimpleDateFormat("MM-dd-yy_HH_mm_ss");

		Date currentDate = new Date();

		return customFormat.format(currentDate);
	}

	/*
	 * Important Method
	 */

	public static WebElement waitforWebElement(WebDriver driver, WebElement ele, int time) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele)); // ensure the element is visible to the driver

		//Not sure why below is required, hence commented
		wait.until(ExpectedConditions.elementToBeClickable(ele));

		highlightElement(driver, ele); // highlight that element per method below

		return ele;
	}

	// Capture Screenshot with date and time in the screenshot name
	public static String captureScreenshot(WebDriver driver) {

		String screenshotpath = System.getProperty("user.dir") + "./myResources/Screenshots/screenshot_"
				+ getCurrentDate() + ".png";

		try {
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			File src = ts.getScreenshotAs(OutputType.FILE);

			FileHandler.copy(src, new File(screenshotpath));

		} catch (Exception e) {

			System.out.println("Error at Taking screenshot --> " + e.getMessage());
		}

		return screenshotpath;

	}

	public static void highlightElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);

		try {
			Thread.sleep(1000);

		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", ele);

	}

}
