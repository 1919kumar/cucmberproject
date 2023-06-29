package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {

	WebDriver driver;
	public homePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement Myaccount;
	
	public void clickonmyaccount() {
		Myaccount.click();
	}
	
	@FindBy(linkText="Login")
	private WebElement LoginOption;
	
	public void selectLoginOption() {
		LoginOption.click();
	}
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	public void selectRegisterOption() {
		registerOption.click();
	}
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBox;
	
	public void searchTheProduct(String str) {
		searchBox.sendKeys(str);
	}
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
}
