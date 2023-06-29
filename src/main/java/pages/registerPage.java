package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utiles.CommonUtils;

public class registerPage {

	WebDriver driver;
	public registerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	private WebElement fName;
	
	public void enterFirstName(String str) {
		fName.sendKeys(str);
	}
	
	@FindBy(id="input-lastname")
	private WebElement lName;
	
	public void enterLastName(String str) {
		lName.sendKeys(str);
	}
	
	@FindBy(id="input-email")
	private WebElement emailId;
	
	public void enterEmailId() {
		CommonUtils email = new CommonUtils();
		emailId.sendKeys(email.getEmailWithTimeStamp());
	}
	
	@FindBy(id="input-telephone")
	private WebElement telephoneNumber;
	
	public void enterTelehoneNumber(String str) {
		telephoneNumber.sendKeys(str);
	}
	
	@FindBy(id="input-password")
	private WebElement password;
	
	public void enterPassword(String str) {
		password.sendKeys(str);
	}
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	
	public void enterConfirmPassword(String str) {
		confirmPassword.sendKeys(str);
	}
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement privacyPolicy;
	
	public void selectPrivacyPolicy() {
		privacyPolicy.click();
	}
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement continueButton;
	
	public void clickOnConitnueButton() {
		continueButton.click();
	}
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement newsLetter;
	
	public void selectNewLetterYes() {
		newsLetter.click();
	}
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privacyWarning;
	
	public String getPrivacyWarningMessage() {
		return privacyWarning.getText();
	}
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	public String getFirstNameWarningMessage() {
		return firstNameWarning.getText();
	}
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	public String getLastNameWarningMessage() {
		return lastNameWarning.getText();
	}
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	public String getEmailWarningMessage() {
		return emailWarning.getText();
	}
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	public String getTelephoneWarningMessage() {
		return telephoneWarning.getText();
	}
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	public String getPasswordWarningMessage() {
		return passwordWarning.getText();
	}
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement duplicateEmailIdWarning;
	
	public String getDuplicateEmailIdWarningMessage() {
		return duplicateEmailIdWarning.getText();
	}
}
