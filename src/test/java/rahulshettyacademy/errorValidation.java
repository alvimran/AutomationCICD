package rahulshettyacademy;

import java.io.IOException;
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
import org.testng.annotations.Test;

import rahulshettyacademy.Data.Retry;
import rahulshettyacademy.pageobject.CheckoutPage;
import rahulshettyacademy.pageobject.LandingPage;
import rahulshettyacademy.pageobject.cartPage;
import rahulshettyacademy.pageobject.confirmationPage;
import rahulshettyacademy.pageobject.productCatalogue;
import rahulshettyacademyTestComopents.Base;

public class errorValidation extends Base {

	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)  // need to rerun this test asmight be this will fail
	public void LoginErrorValidation() throws IOException, InterruptedException {
		String ProductName = "ZARA COAT 3";

		landingPage.loginApplications("alvi123@gmail.com", "Imrankhan1231");
		//Assert.assertEquals("Incorrect email or password.", landingPage.getErroMessage());
		Assert.assertEquals("Incorrect email or password.", landingPage.getErroMessage());

	}

	@Test
	public void productErrorValidation() throws IOException, InterruptedException {
		String ProductName = "ZARA COAT 3";

		productCatalogue ProductCatalogue = landingPage.loginApplications("imran123@gmail.com", "Imran123@");
		List<WebElement> products = ProductCatalogue.getProductList();
		ProductCatalogue.addProductToCart(ProductName);

		cartPage Cartpage = ProductCatalogue.goToCartPage();
		Boolean match = Cartpage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);

	}

}
