package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobject.cartPage;
import rahulshettyacademy.pageobject.orderPage;

public class AbstractComponents {

	WebDriver driver;
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForElementToBeAppear(By FindBy)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	public void waitForWebElementToBeAppear(WebElement FindBy)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(FindBy));
	}
	public void waitForElementToBeDisappear(WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartHeader;
	@FindBy(css="[routerlink*='/dashboard/myorders']")
	WebElement orderHistory;
	//driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
	public cartPage goToCartPage()
	{
		cartHeader.click();
		cartPage Cartpage= new cartPage(driver);
		return Cartpage;
	}
	public orderPage goToOrdersPage()
	{
		orderHistory.click();
		orderPage Orderpage= new orderPage(driver);
		return Orderpage;
	}
	
}
