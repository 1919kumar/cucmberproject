package stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.Driverfactory;
import io.cucumber.java.en.*;
import pages.homePage;
import pages.searchResultPage;

public class searchs {
	
	WebDriver driver;
	private homePage homepage;
	private searchResultPage searchresultpage;

	@Given("User open the Application")
	public void user_open_the_application() {
	    driver = Driverfactory.getDriver();
	    homepage = new homePage(driver);
	}

	@When("User enters Valid product {string} into search field")
	public void user_enters_valid_product_into_search_field(String product) {
		homepage.searchTheProduct(product);
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		homepage.clickOnSearchButton();
		searchresultpage = new searchResultPage(driver);
	}

	@Then("Valid product should get displayed in search results")
	public void valid_product_should_get_displayed_in_search_results() {
		
		Assert.assertTrue(searchresultpage.displayedStatusOfHpProduct());
	}

	@When("User enter non-existing product {string} into search field")
	public void user_enter_non_existing_product_into_search_field(String product) {
		homepage.searchTheProduct(product);
	}

	@Then("Proper text informing the user about no product matching should be displayed")
	public void proper_text_informing_the_user_about_no_product_matching_should_be_displayed() {
		Assert.assertEquals("There is no product that matches the search criteria.", searchresultpage.getTextOfInvalidProduct());
		Assert.fail();
	}

	@When("User dont enter any product into search field")
	public void user_dont_enter_any_product_into_search_field() {
		homepage.searchTheProduct("");
	}
}
