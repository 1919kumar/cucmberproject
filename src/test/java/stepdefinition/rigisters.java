package stepdefinition;

import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.Driverfactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.accountSucessPage;
import pages.homePage;
import pages.registerPage;

public class rigisters {
	
	WebDriver driver = null;
	private registerPage registerpage;
	
	@Given("user navigate to Register page")
	public void user_navigate_to_Register_page()	{
		driver = Driverfactory.getDriver();
		homePage homepage = new homePage(driver);
		homepage.clickonmyaccount();
		homepage.selectRegisterOption();
		registerpage = new registerPage(driver);
	}

	@When("User enter below details into the fields")
	public void User_enter_below_details_into_the_fields(DataTable datatable) {
		Map<String, String> map = datatable.asMap(String.class, String.class);
		
		registerpage.enterFirstName(map.get("firstname"));
		registerpage.enterLastName(map.get("lastname"));
		registerpage.enterEmailId();
		registerpage.enterTelehoneNumber(map.get("telephone"));
		registerpage.enterPassword(map.get("password"));
		registerpage.enterConfirmPassword(map.get("confirmpassword"));
	}
	
	@And("Select Privacy policy field")
	public void Select_Privacy_policy_field()	{
		registerpage.selectPrivacyPolicy();
	}
	
	@And("Click on Continue button")
	public void Click_on_Continue_button()	{
		registerpage.clickOnConitnueButton();
	}
	
	@Then("Account should get sucessfully created")
	public void Account_should_get_sucessfully_created()	{
		accountSucessPage accountsucesspage = new accountSucessPage(driver);
		Assert.assertEquals("Your Account Has Been Created!", accountsucesspage.getPageHeading());
	}
	
	@And("Select yes for News letter")
	public void Select_yes_for_News_letter()	{
		registerpage.selectNewLetterYes();
	}
	
	@When("User dont enter details into any field")
	public void User_dont_enter_details_into_any_field()	{
		registerpage.enterFirstName("");
	}
	
	@Then("Warning message should be displayed for all the mandatory field")
	public void Warning_message_should_be_displayed_for_all_the_mandatory_field()	{
		Assert.assertEquals("Warning: You must agree to the Privacy Policy!", registerpage.getPrivacyWarningMessage());
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerpage.getFirstNameWarningMessage());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerpage.getLastNameWarningMessage());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerpage.getEmailWarningMessage());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerpage.getTelephoneWarningMessage());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerpage.getPasswordWarningMessage());
	}
	
	@Then("waning message informating the user about duplicate email should be displayed")
	public void waning_message_informating_the_user_about_duplicate_email_should_be_displayed()	{
		Assert.assertEquals("Warning: E-Mail Address is already registered!", registerpage.getDuplicateEmailIdWarningMessage());
	}
}
