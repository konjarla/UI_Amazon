package equifax.qa.amazon.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	 
	WebDriver driver;
	Properties prop;
	
	/*
	 * This method is used to initialized the driver on the basis of given browser value
	 * @param browserName
	 * @return this returns webdriver
	 */
	
	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		
		System.out.println("browser name is : "+ browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		
		else {
			System.out.println("browser is not found...please pass the correct browser name " + browserName);
		}
		
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url").trim());
		
		return driver;
		
	}
	
	/**
	 * This method is initialized the properties from .properties file
	 * @return return Properties (prop)
	 */
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
	}
	
	

}
