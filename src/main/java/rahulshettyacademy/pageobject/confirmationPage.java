package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class confirmationPage extends AbstractComponents {
	WebDriver driver;

	public confirmationPage(WebDriver driver) 
	{ // first create the object in the main class of this class and pass the argument of driver
		//then catch it in constructor 
		//this keyword here will get the life and intialize to instance driver
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);// it trigger all the webelement created by @FindBy
		
	}

	//driver.findElement(By.id("userEmail")).sendKeys("alvi123@gmail.com");
	
	@FindBy(css=".hero-primary")
	WebElement confirmMessage;
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
	By list=By.cssSelector(".ta-results");
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement clickonCheck;
	
	
	
	public String getConfimationMessage()
	{
		CheckoutPage cp = new CheckoutPage(driver);
	return confirmMessage.getText();
	//Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	//return ConfirmMessage;
	
	}
}
