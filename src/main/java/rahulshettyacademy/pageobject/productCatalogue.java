package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class productCatalogue extends AbstractComponents {
	WebDriver driver;

	public productCatalogue(WebDriver driver) 
	{ // first create the object in the main class of this class and pass the argument of driver
		//then catch it in constructor 
		//this keyword here will get the life and intialize to instance driver
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);// it trigger all the webelement created by @FindBy
		
	}

	//driver.findElement(By.id("userEmail")).sendKeys("alvi123@gmail.com");
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));

	 public List<WebElement> getProductList()
	 {
		 waitForElementToBeAppear(productsBy);
		 return products;
	 }
	 public WebElement getProductByName(String ProductName)
	 {
		 WebElement prod=getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(ProductName)
					).findFirst().orElse(null);
		 return prod;
	 }
	public void addProductToCart(String ProductName)
	{
		WebElement prod=getProductByName(ProductName);
		prod.findElement(addToCart).click();
		waitForElementToBeAppear(toastMessage);
		waitForElementToBeDisappear(spinner);
		
		
	}
}
