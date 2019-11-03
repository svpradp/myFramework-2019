package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateUserSteps {
	
	WebDriver driver;
	
	@Given("^Open Chrome$")
	public void open_Chrome() throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vs0322\\Downloads\\chromedriver_win32_0927_Chrome77\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://orangehrm-demo-6x.orangehrmlive.com/client/#/dashboard");
		
		
	}

	@When("^user enters valid credentials$")
	public void user_enters_valid_credentials() throws Throwable {

	driver.findElement(By.xpath("//input[@name='txtUsername']")).clear();
	driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("admin");;
	
	driver.findElement(By.xpath("//input[@name='txtPassword']")).clear();
	driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
	
	driver.findElement(By.xpath("//input[@name='Submit']")).click();
		
	}

	@When("^lands on Dashboard Page$")
	public void lands_on_Dashboard_Page() throws Throwable {
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals("OrangeHRM", title);
		
		softAssert.assertAll();
	}

	@When("^user clicks on Add User and enters details$")
	public void user_clicks_on_Add_User_and_enters_details() throws Throwable {

	}

	@When("^Click on Save$")
	public void click_on_Save() throws Throwable {
	   
	}

	@Then("^the user should get created$")
	public void the_user_should_get_created() throws Throwable {
	   
		driver.quit();
	}

}
