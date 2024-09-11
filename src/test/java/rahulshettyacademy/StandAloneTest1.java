package rahulshettyacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest1 {

	public static void main(String[] args) throws InterruptedException {
		String ProductName="ZARA COAT 3";
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("alvi123@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Imrankhan123");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
	List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	
WebElement prod=	products.stream().filter(product->product.
			findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
			
			prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
		//#ng-animating
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#ng-animating")));
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
			
			driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
			
	List<WebElement> cartProducts=	driver.findElements(By.cssSelector(".cartSection h3"));
	Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(ProductName));
	Assert.assertTrue(match);
	driver.findElement(By.cssSelector(".totalRow button")).click();
	
//	driver.findElement(By.cssSelector("input[placeholder*='Select Country']")).sendKeys("Ind");
//	List<WebElement> li=driver.findElements(By.cssSelector(".ta-item"));
//	for(WebElement list:li)
//	{
//		if(list.getText().equalsIgnoreCase("India"))
//		{;
//	list.click();
//	break;
//		}
//	}
	
	Actions a= new Actions(driver);
	a.sendKeys(driver.findElement(By.cssSelector("input[placeholder*='Select Country")),"india").build().perform();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scroll(0,500)");
	Thread.sleep(3000);
	driver.findElement(By.cssSelector(".action__submit")).click();
	
	String ConfirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	System.out.println("Done");
	
	}

}
