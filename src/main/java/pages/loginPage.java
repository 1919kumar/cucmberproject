package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	WebDriver driver;
	public loginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement emailId;
	
	public void enterEmail(String str) {
		emailId.sendKeys(str);
	}
	
	@FindBy(id="input-password")
	private WebElement password;
	
	public void enterPassword(String str) {
		password.sendKeys(str);
	}
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningMessage;
	
	public boolean getWarningMessage() {
		return warningMessage.getText().contains("Warning: No match for E-Mail Address and/or Password.");
	}
}
