package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class cartPage extends AbstractComponents {
	WebDriver driver;

	public cartPage(WebDriver driver) 
	{ // first create the object in the main class of this class and pass the argument of driver
		//then catch it in constructor 
		//this keyword here will get the life and intialize to instance driver
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);// it trigger all the webelement created by @FindBy
		
	}

	//driver.findElement(By.id("userEmail")).sendKeys("alvi123@gmail.com");
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	
	public Boolean verifyProductDisplay(String ProductName)
	{
	
	
	Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(ProductName));
	return match;
	}
	
 public CheckoutPage	goToCheckOutPage()
	{
	checkoutEle.click();
	CheckoutPage checkoutpage= new CheckoutPage(driver);
	return  checkoutpage;
	}
}
