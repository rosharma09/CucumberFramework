package stepDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class loginStepDef {

	WebDriver driverObj;

	// In the loginStepDef class we are going to write the fuctions associated with
	// the feature

	@Given("^user is at the login page$")
	public void user_is_at_the_login_page() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rosharma\\Downloads\\geckoDrivers\\Chrome\\chromedriver.exe");
		driverObj = new ChromeDriver();
		
		// Page settings
		driverObj.manage().window().maximize();
		driverObj.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driverObj.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//Launch the URL
		
		driverObj.get("https://ui.freecrm.com/");

		
		String loginPageTitle = driverObj.getTitle();
		System.out.println("User is at the login page");
		System.out.println("Login Page title : "+loginPageTitle);
		Assert.assertEquals("Cogmento CRM", loginPageTitle);
	}
	
	@Then("^user enter username and password$")
	public void user_enter_username_and_password() {
	  
		WebElement emailId = driverObj.findElement(By.xpath("//*[@id=\"ui\"]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]"));
		WebElement passWord = driverObj.findElement(By.xpath("//*[@id=\"ui\"]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/input[1]"));
		
		emailId.sendKeys("sharmarahan123@gmail.com");
		passWord.sendKeys("ManhUser@090695");
		
		System.out.println("User entered the email and password");
	}
	
	@Then("^user click on login button$")
	public void user_click_on_login_button() {
	    WebElement loginBtn = driverObj.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
	    loginBtn.click();
	    System.out.println("User clicked on the login button");
	}
	
	@Then("^user is redirected to the home page$")
	public void user_is_redirected_to_the_home_page() {
	  WebElement userInfo = driverObj.findElement(By.xpath("//*[text()='Rohan Sharma']"));
	  
	  Boolean isDisplayed = userInfo.isDisplayed();
	  System.out.println("User is at the home page");
	  Assert.assertTrue("The user info is not displayed", isDisplayed);
	}
	
	@Then("^close the blowser$")
	public void close_the_browser() {
		driverObj.quit();
	}

}
