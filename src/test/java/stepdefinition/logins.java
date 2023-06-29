package stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.Driverfactory;
import io.cucumber.java.en.*;
import pages.accountPage;
import pages.homePage;
import pages.loginPage;

public class logins {

	WebDriver driver = null;
	private loginPage loginpage;
	
	@Given("^User navigate to login page$")
	public void user_navigate_to_login_page() {
		driver = Driverfactory.getDriver();	
		homePage page = new homePage(driver);
		page.clickonmyaccount();
		page.selectLoginOption();
		loginpage = new loginPage(driver);
	}

	@When("^User enters valid email address (.+)$")
	public void user_enters_valid_email_address(String email) {
		loginpage.enterEmail(email);
	}

	@When("^Enters valid password (.+)$")
	public void enters_valid_password(String password) {
		
		loginpage.enterPassword(password);
	}
	
	@When("User enter valid email address {string}")
	public void user_enter_valid_email_address(String email) {
		loginpage.enterEmail(email);
	}

	@When("Enter valid password {string}")
	public void enter_valid_password(String password) {
		loginpage.enterPassword(password);
	}

	@When("User enters invalid email address {string}")
	public void user_enters_invalid_email_address(String email) {
		loginpage.enterEmail(email);
	}

	@When("Enter invalid password {string}")
	public void enter_invalid_password(String password) {
		loginpage.enterPassword(password);
	}
	
	@When("^clicks on Login button$")
	public void clicks_on_login_button() {
		loginpage.clickOnLoginButton();
	}

	@Then("^User should Login Successfully$")
	public void user_should_login_successfully() {	
		accountPage accountpage = new accountPage(driver);
		Assert.assertTrue(accountpage.displayedStatusOfEdityouraccountinformation());
	}

	@Then("^User should get a proper warning message$")
	public void user_should_get_a_proper_warning_message() {
		Assert.assertTrue(loginpage.getWarningMessage());
	}

	@When("^User dont enter any credentials$")
	public void user_dont_enter_any_credentials() {
		loginpage.enterEmail("");
	}
}
