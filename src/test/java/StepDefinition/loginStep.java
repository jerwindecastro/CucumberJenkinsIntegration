package StepDefinition;

import java.io.FileInputStream;

import com.pom.basetest.TestBase;
import com.pom.page.HomePageTest;
import com.pom.page.LoginTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class loginStep extends TestBase {
	@Before
	public void beforeTest() {
		initBrowser();
	}
	
	@After
	public void afterTest() {
		quitDriver();
	}
    
	LoginTest login;
	HomePageTest homepage;
	@Given("User is on the landing page")
	public void user_is_on_the_landing_page() {
		System.out.println("Opening Free CRM Web Page");
		openUrl("url");
		login= new LoginTest();
		login.verifyPageTitle("Free CRM Software - Customer Relationship Management");
	}

	@Then("User click on the Login button")
	public void user_click_on_the_login_button() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		login.Login();
	}

	@Then("User enter username and password")
	public void user_enter_username_and_password() {
		System.out.println("Entering credentials");
		// Write code here that turns the phrase above into concrete actions
		homepage = login.enterCredentials();
	}

}
