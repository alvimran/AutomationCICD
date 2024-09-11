import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Selenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver= new ChromeDriver();
//	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//	driver.manage().window().maximize();
//		WebElement drop= driver.findElement(By.id("dropdown-class-example"));
//		
//		Select dropDown= new Select(drop);
//	//System.out.println(dropDown.selectByIndex(1));
//		dropDown.selectByIndex(1);
//		
//		JavascriptExecutor js= (JavascriptExecutor)driver;
//		js.executeScript("scrollBy(0,500)");
//		
//		driver.findElement(By.id("alertbtn")).click();
//		
//		driver.switchTo().alert().accept();
//		
//		driver.get("https://jqueryui.com/droppable/");
//		driver.manage().window().maximize();
//		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
//		
//		Actions a = new Actions(driver);
//		WebElement From =driver.findElement(By.id("draggable"));
//		WebElement To =driver.findElement(By.id("droppable"));
//		a.dragAndDrop(From, To).build().perform();
		
		
//		//--- Links
//		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		driver.manage().window().maximize();
//		
//	System.out.println(driver.findElements(By.tagName("a")).size());
//	WebElement footerdriver=driver.findElement(By.id("gf-BIG"));
//	System.out.println(footerdriver.findElements(By.tagName("a")).size());
//// Coulmn fotter
//	WebElement coulmnfooter=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
//	System.out.println(coulmnfooter.findElements(By.tagName("a")).size());
//	
//	for(int i=1;i<coulmnfooter.findElements(By.tagName("a")).size();i++)
//	{
//		String ClickOnTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
//		coulmnfooter.findElements(By.tagName("a")).get(i).sendKeys(ClickOnTab);
//		Thread.sleep(5000L);
//		
//	Set<String> windows=	driver.getWindowHandles();
//	Iterator <String> it=windows.iterator();
//	while(it.hasNext())
//	{
//		driver.switchTo().window(it.next());
//	System.out.println(driver.getTitle());
//	}
//	
//	
//	}
//	
//		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//input[@value='radio1']")).click();

		//mouseOver
//		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		driver.manage().window().maximize();
//		JavascriptExecutor js= (JavascriptExecutor)driver;
//		js.executeScript("scrollBy(0,900)");
//		Actions a= new Actions(driver);
//		WebElement mouseOver=driver.findElement(By.id("mousehover"));
//		a.moveToElement(mouseOver).build().perform();
		driver.get("www.google.com");
	}

}
