package org.stepdef1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Fb {

	WebDriver driver;

	@Given("User is on fb page on chrome browser")
	public void user_is_on_fb_page_on_chrome_browser() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://facebook.com/");
		driver.manage().window().maximize();

	}

	@When("user enter the username and password")
	public void user_enter_the_username_and_password() throws Exception {

		driver.findElement(By.id("email")).sendKeys("ganapathi.manoharan");
		driver.findElement(By.id("pass")).sendKeys("welcome");

	}

	@When("click login button")
	public void click_login_button() throws Exception {

		driver.findElement(By.name("login")).click();
	}

	@Then("user check homepage is visible or not")
	public void user_check_homepage_is_visible_or_not() throws Exception {

		System.out.println("invalid");

	}

}
