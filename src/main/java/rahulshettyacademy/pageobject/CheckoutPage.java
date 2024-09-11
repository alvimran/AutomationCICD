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

public class CheckoutPage extends AbstractComponents {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) 
	{ // first create the object in the main class of this class and pass the argument of driver
		//then catch it in constructor 
		//this keyword here will get the life and intialize to instance driver
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);// it trigger all the webelement created by @FindBy
		
	}

	//driver.findElement(By.id("userEmail")).sendKeys("alvi123@gmail.com");
	
	@FindBy(css="input[placeholder*='Select Country")
	WebElement countryList;
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
	By list=By.cssSelector(".ta-results");
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement clickonCheck;
	
	public void addCountry()
	{
	
	Actions a= new Actions(driver);
	a.sendKeys(countryList, "india").build().perform();
	//a.sendKeys(driver.findElement(By.cssSelector("input[placeholder*='Select Country")),"india").build().perform();
	waitForElementToBeAppear(list);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	//driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	clickonCheck.click();
	}
	
	public confirmationPage submitOrder() throws InterruptedException
	{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scroll(0,500)");
	Thread.sleep(3000);
	placeOrder.click();
	confirmationPage Confirmationpage= new confirmationPage(driver);
	return Confirmationpage;
	}

}
