package com.massmutual.Cucumber.StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.massmutual.Cucumber.pages.ValuesPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ValuesSteps {

	WebDriver driver = null;
	ValuesPage p = new ValuesPage(driver);

	@Before
	public void beforeScenario() {
		System.out.println("This will run before the Scenario");
		WebDriverManager.chromedriver().arch32().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void afterScenario() {
		System.out.println("This will run after the Scenario");
		driver.close();
		driver.quit();
	}

	@Given("Launch the Login Page")
	public void Launch_the_Login_Page() {
		System.out.println("LoginPage is initialized ");
	}

	@Given("Login to the application \"([^\"]*)\" , \"([^\"]*)\"$")
	public void login_to_the_application(String Username, String Password) {
		driver.get("https://www.exercise1.com/values");
		// driver.get("https://www.google.com");
		p.enterLoginCredentials(Username, Password);
	}

	@Then("verify count of lables and text boxes values")
	public void verify_count_of_lables_and_text_boxes_values() {
		p.verifyLabelSizetextValues();
	}

	@Then("verify text box value great than zero")
	public void verify_text_box_value_great_than_zero() {
		p.verifyTextBoxContentGreatThanZero();
	}

	@Then("verify total balance with values listed on the screen")
	public void verify_total_balance_with_values_listed_on_the_screen() {
		p.verifyvalueslistedonthescreen();
	}

	@Then("verify text box content format")
	public void verify_text_box_content_format() {
		p.verifyTextBoxFormat();
	}

	@Then("verify total balance")
	public void verify_total_balance() {
		p.verifySumOfValues();
	}
}
