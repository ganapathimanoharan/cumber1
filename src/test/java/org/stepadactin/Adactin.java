package org.stepadactin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import baseClass.GanaBaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Adactin extends GanaBaseClass{

	//WebDriver driver;

	@Given("^User is on adactinHotel page on chrome browser$")
	public void user_is_on_adactinHotel_page_on_chrome_browser() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

	}

	@When("^user enter the \"([^\"]*)\"and\"([^\"]*)\"$")
	public void user_enter_the_and(String arg1, String arg2) throws Exception {

		findElementByXpath("//input[@id='username']").sendKeys(arg1);

		findElementByXpath("//input[@id='password']").sendKeys(arg2);

	}

	@When("^user click the login button$")
	public void user_click_the_login_button() throws Exception {

		findElementByXpath("//input[@id='login']").click();

	}

	@When("^user check search hotel page visible or not$")
	public void user_check_search_hotel_page_visible_or_not() throws Exception {

		String text = findElementByXpath("//td[text()='Search Hotel ']").getText();
		Assert.assertTrue("verify Tittle in search hotel", text.contains("Search Hotel"));
		sysout(text);

	}

	@When("^user enter the details in search hote page \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"and\"([^\"]*)\"$")
	public void user_enter_the_details_in_search_hote_page_and(String arg1, String arg2, String arg3, String arg4,
			String arg5, String arg6) throws Exception {

		findElementByXpath("//select[@id='location']").sendKeys(arg1);

		findElementByXpath("//select[@id='hotels']").sendKeys(arg2);

		findElementByXpath("//select[@id='room_type']").sendKeys(arg3);

		findElementByXpath("//select[@id='room_nos']").sendKeys(arg4);

		findElementByXpath("//select[@id='adult_room']").sendKeys(arg5);

		findElementByXpath("//select[@id='child_room']").sendKeys(arg6);

	}

	@When("^user click the search button$")
	public void user_click_the_search_button() throws Exception {

		findElementByXpath("//input[@id='Submit']").click();

	}

	@When("^user check select hotel page visible or not$")
	public void user_check_select_hotel_page_visible_or_not() throws Exception {

		String text1 = findElementByXpath("//td[text()='Select Hotel ']").getText();
		Assert.assertTrue("verify Tittle in select hotel", text1.contains("Select Hotel"));
		sysout(text1);

	}

	@When("^user select the hotel and click the search button$")
	public void user_select_the_hotel_and_click_the_search_button() throws Exception {

		findElementById("radiobutton_0").click();

		findElementById("continue").click();

	}

	@When("^user check booking page visible or not$")
	public void user_check_booking_page_visible_or_not() throws Exception {

		String text2 = findElementByXpath("//td[text()='Book A Hotel ']").getText();
		Assert.assertTrue("verify Tittle in Book hotel", text2.contains("Book A Hotel"));
		sysout(text2);

	}

	@When("^user enter the details in booking page \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"and\"([^\"]*)\"$")
	public void user_enter_the_details_in_booking_page_and(String arg1, String arg2, String arg3, String arg4,
			String arg5, String arg6, String arg7, String arg8) throws Exception {

		findElementByXpath("//input[@id='first_name']").sendKeys(arg1);

		findElementByXpath("//input[@id='last_name']").sendKeys(arg2);

		findElementByXpath("//textarea[@id='address']").sendKeys(arg3);

		findElementByXpath("//input[@id='cc_num']").sendKeys(arg4);

		findElementByXpath("//select[@id='cc_type']").sendKeys(arg5);

		findElementById("cc_exp_month").sendKeys(arg6);

		findElementById("cc_exp_year").sendKeys(arg7);

		findElementByXpath("//input[@id='cc_cvv']").sendKeys(arg8);

	}

	@When("^user click the booking button$")
	public void user_click_the_booking_button() throws Exception {

		findElementById("book_now").click();

	}

	@When("^user get the PNR code and cancel the booking$")
	public void user_get_the_PNR_code_and_cancel_the_booking() throws Exception {

		String attribute = findElementById("order_no").getAttribute("value");
		sysout(attribute);

		String text = findElementByXpath("//td[text()='Booking Confirmation ']").getText();
		Assert.assertTrue("verify Tittle in Booking confirmation", text.contains("Booking Confirmation"));
		sysout(text);

		findElementByXpath("//a[text()='Booked Itinerary']").click();

		findElementByXpath("//input[@name='order_id_text']").sendKeys(attribute);

		findElementById("search_hotel_id").click();

		findElementByXpath("//input[contains(@name,'btn_id_')]").click();

		alert();

		String text2 = findElementById("search_result_error").getText();
		sysout(text2);

	}

}
