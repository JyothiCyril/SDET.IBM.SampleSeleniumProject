package TestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Pages.GooglePages;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	WebDriver driver;
	GooglePages GoogleOR;
	
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void setUp(String Browser, String Url) {
		
		if(Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();		
		}else if(Browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if(Browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			
		}else if(Browser.equalsIgnoreCase("Edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		
		
		GoogleOR = new GooglePages(driver);
		driver.get(Url);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		
	}

}
