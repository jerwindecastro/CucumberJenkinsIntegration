package StepDefinition;

import com.pom.page.AddDealsTest;
import com.pom.page.HomePageTest;

import io.cucumber.java.en.Then;

public class homepageStep {
	HomePageTest homepage = new HomePageTest();
	AddDealsTest addDeals;
	@Then("User is on the homepage")
	public void user_is_on_the_landing_homepage() {
	    homepage.verifyPageTitle("Cogmento CRM");
	}
	@Then("User hover to deals menu")
	public void user_hover_to_deals_menu() {
	    // Write code here that turns the phrase above into concrete actions
		addDeals = homepage.mouseHover();
	}

}
