package rahulshettyacademyTestComopents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobject.LandingPage;

public class Base {

	public WebDriver driver;
	public LandingPage landingPage;
	public WebDriver initializeDriver() throws IOException
	{
		
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
												// setting path dynamically			
		prop.load(fis);
		String BrowserName=System.getProperty("browser")!=null ?  System.getProperty("browser"):prop.getProperty("browser");
		//prop.getProperty("browser");
		if(BrowserName.contains("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(BrowserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver= new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
			
			
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage	launchApplication() throws IOException
	{
		driver=initializeDriver();
		 landingPage= new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	public  List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException
	{
		//read json to string
		String JsonContent=FileUtils.readFileToString(new File(filepath)
				, StandardCharsets.UTF_8);
	
	//String to HashMap  and jackson databind dependencies
		ObjectMapper mapper=new ObjectMapper();
		//List<HashMap<String,String>> data= mapper.readValue(JsonContent, new TypeReference<List<HashMap<String,String>>>
		List<HashMap<String,String>> data	=mapper.readValue(JsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		
		return data;
		
	}
	public String getScreenShoot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		 File source=ts.getScreenshotAs(OutputType.FILE);
		 File file= new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		 FileUtils.copyFile(source, file);
		 return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
	}

