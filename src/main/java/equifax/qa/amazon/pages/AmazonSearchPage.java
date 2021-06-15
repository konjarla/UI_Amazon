package equifax.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import equifax.qa.amazon.utils.ElementUtil;

public class AmazonSearchPage {
	
	private ElementUtil elementUtil;
	private WebDriver driver;
	
//	Page Objects - By locators - OR
//	private By clickFirstImage = By.xpath("//span[@data-component-id=1]");
	private By clickFirstImage = By.xpath("//*[starts-with(@id,'search')]//*[@class='a-section a-spacing-medium']");
	private By searchPagePrice = By.id("newBuyBoxPrice");
	
	
	
//	constructor:
	public AmazonSearchPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);	
	}
	
//	page actions:
	public AmazonAddToCartPage doSelectFirstImage() {
		try {
		elementUtil.doClick(clickFirstImage);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return new AmazonAddToCartPage(driver);
	}
	
	public double getProductPriceFromSearcgPage() {
		String priceWithDollar;
		try {
		WebElement findElement = driver.findElement(searchPagePrice);
		priceWithDollar = findElement.getText();
		return Double.parseDouble(priceWithDollar.substring(1));
		}
		catch(NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return 0.0;
	}
	

}
