package StepDefinition;

import com.pom.page.AddDealsTest;

import io.cucumber.java.en.Then;

public class addDealsStep {
	AddDealsTest addDeals = new AddDealsTest();
	@Then("User is on the deals page")
	public void user_is_on_the_deals_page() {
	    addDeals.clickAddBtn();
	}
	@Then("User fill up title and company name")
	public void user_fill_up_title_and_company_name() {
	    addDeals.enterData();
	}
	@Then("User click on the save button")
	public void user_click_on_the_save_button() {
	    addDeals.saveData();
	}

}
