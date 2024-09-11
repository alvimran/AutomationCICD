package rahulshettyacademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	WebDriver driver;

	public LandingPage(WebDriver driver) { // first create the object in the main class of this class and pass the
											// argument of driver
											// then catch it in constructor
											// this keyword here will get the life and intialize to instance driver
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);// it trigger all the webelement created by @FindBy

	}

	// driver.findElement(By.id("userEmail")).sendKeys("alvi123@gmail.com");

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement passwordEle;

	@FindBy(id = "login")
	WebElement submit;

//	@FindBy(css = "[class*='flyInOut']")
//	WebElement errorMessage;

	@FindBy(css = ".toast-message")
	WebElement errorMessage;

	
	
	public productCatalogue loginApplications(String user, String password) {
		// TODO Auto-generated method stub
		userEmail.sendKeys(user);
		passwordEle.sendKeys(password);
		submit.click();
		productCatalogue ProductCatalogue = new productCatalogue(driver);
		return ProductCatalogue;
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public String getErroMessage() {
		waitForWebElementToBeAppear(errorMessage);
		return errorMessage.getText();
	}

}
