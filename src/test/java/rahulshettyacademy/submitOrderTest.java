package rahulshettyacademy;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.pageobject.CheckoutPage;
import rahulshettyacademy.pageobject.LandingPage;
import rahulshettyacademy.pageobject.cartPage;
import rahulshettyacademy.pageobject.confirmationPage;
import rahulshettyacademy.pageobject.orderPage;
import rahulshettyacademy.pageobject.productCatalogue;
import rahulshettyacademyTestComopents.Base;

public class submitOrderTest extends Base {
	String ProductName = "ZARA COAT 3";
	@Test(dataProvider="getData",groups={"purchase"})
	public void submitOrder(HashMap<String,String>input) throws IOException, InterruptedException {
		

		productCatalogue ProductCatalogue = landingPage.loginApplications(input.get("email"), input.get("Password"));
		List<WebElement> products = ProductCatalogue.getProductList();
		ProductCatalogue.addProductToCart(input.get("Product"));

		cartPage Cartpage = ProductCatalogue.goToCartPage();

		Boolean match = Cartpage.verifyProductDisplay(input.get("Product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutpage = Cartpage.goToCheckOutPage();
		checkoutpage.addCountry();
		confirmationPage Confirmationpage = checkoutpage.submitOrder();

		String message = Confirmationpage.getConfimationMessage();
		System.out.println("Display Message-------" +message);
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods={"submitOrder"})
	public void orderHistoryTest()
	{
		productCatalogue ProductCatalogue = landingPage.loginApplications("alvi123@gmail.com", "Imrankhan123");
		orderPage Orderpage=ProductCatalogue.goToOrdersPage();
	Assert.assertTrue(Orderpage.verifyOrderDisplay(ProductName));
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		HashMap<String,String> map=new HashMap<String,String>();
//		map.put("email", "alvi123@gmail.com");
//		map.put("Password", "Imrankhan123");
//		map.put("Product", "ZARA COAT 3");
//		HashMap<String,String> map1=new HashMap<String,String>();
//		map1.put("email", "imran123@gmail.com");
//		map1.put("Password", "Imran123@");
//		map1.put("Product", "ADIDAS ORIGINAL");
		//return  new Object[][] {{"alvi123@gmail.com","Imrankhan123","ZARA COAT 3"},{"imran123@gmail.com", "Imran123@","ADIDAS ORIGINAL"}};
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\Data\\PurchaseOrder.json");
		return  new Object[][] {{data.get(0)},{data.get(1)}};
	}
}
