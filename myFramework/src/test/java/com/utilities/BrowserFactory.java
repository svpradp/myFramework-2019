package com.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	WebDriver driver;  //removed static keyword and method type is not static now

	public WebDriver startApplication(String browserName, String appUrl) {

		if (browserName.equalsIgnoreCase("Chrome")) {
			System.out.println("Inside Browser Factory");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "./myResources/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Browser Invoked");
		}

		else if (browserName.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "./myResources/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();

		}

		else if (browserName.contains("IE")) {
		}

		else

		{
			System.out.println("We do not support this browser");
		}

		/* Common actions for all browsers while application launch below */

		// Page load timeout
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// implicit wait - For WebElements before the script fails or throws an error
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(appUrl);

		return driver;

	}

	public static void quitBrowser(WebDriver driver) {
		// driver.close();
		driver.quit();
	}

}
