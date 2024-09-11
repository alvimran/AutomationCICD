package rahulshettyacademy.stepDefinition;



import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.pageobject.CheckoutPage;
import rahulshettyacademy.pageobject.LandingPage;
import rahulshettyacademy.pageobject.cartPage;
import rahulshettyacademy.pageobject.confirmationPage;
import rahulshettyacademy.pageobject.productCatalogue;
import rahulshettyacademyTestComopents.Base;

public class stepDefinitionImp extends Base {

	public LandingPage landingPage;
	public productCatalogue ProductCatalogue;
	public confirmationPage Confirmationpage;
	public CheckoutPage checkoutpage;
	
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_pae() throws IOException
	{
		 landingPage=launchApplication(); 		//launchApplication return landingPage object so we are chatching it here 
	}
	
	@Given("Logged in with username {string} and password {string}")
	public void logged_in_with_username_and_password(String username, String password) 
	{
		 ProductCatalogue = landingPage.loginApplications(username, password);
	}
	
	@When("I add product {string} to cart")
	public void I_add_product_to_cart(String productName)
	{
		List<WebElement> products = ProductCatalogue.getProductList();
		ProductCatalogue.addProductToCart(productName);
	}
	
	@When("Chekout {string} and submit the order")
	public void Chekout_and_submit_order(String productName) throws InterruptedException
	{
		cartPage Cartpage = ProductCatalogue.goToCartPage();

		Boolean match = Cartpage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutpage = Cartpage.goToCheckOutPage();
		checkoutpage.addCountry();
		confirmationPage Confirmationpage = checkoutpage.submitOrder();
		Thread.sleep(4000);
	}
	
	@Then("{string} message is displayed on confirmationPage")
	public void message_is_displayed_on_confirmation_page(String string) {
		
		Confirmationpage = new confirmationPage(driver);
		String message = Confirmationpage.getConfimationMessage();
		Assert.assertTrue(message.equalsIgnoreCase(string));
	    
		
	}
//	String message = Confirmationpage.getConfimationMessage();
//	System.out.println("Display Message-------" +message);
//	Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//	
	@Then("{string} message is display")
    public void something_message_is_displayed(String string) throws Throwable {
   
		Assert.assertEquals("Incorrect email or password.", landingPage.getErroMessage());
    	driver.close();
    }
	
}
