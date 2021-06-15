package equifax.qa.amazon.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import equifax.qa.amazon.factory.DriverFactory;
import equifax.qa.amazon.pages.AmazonAddToCartPage;
import equifax.qa.amazon.pages.AmazonPage;
import equifax.qa.amazon.pages.AmazonProceedToCheckOut;
import equifax.qa.amazon.pages.AmazonSearchPage;


public class BaseTest {
	private WebDriver driver;
	Properties prop;
	DriverFactory df;
	public AmazonPage amazonPage;
	public AmazonSearchPage amazonSearchPage;
	public AmazonAddToCartPage amazonAddToCartPage;
	public AmazonProceedToCheckOut amazonProceedToCheckOut;
	
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		amazonPage = new AmazonPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
