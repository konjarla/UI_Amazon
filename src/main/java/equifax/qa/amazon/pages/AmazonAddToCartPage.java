package equifax.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import equifax.qa.amazon.utils.ElementUtil;

public class AmazonAddToCartPage {
	
	private ElementUtil elementUtil;
	private WebDriver driver;
	
//	Page Objects - By locators - OR
	private By addToCart = By.xpath("//input[@id='add-to-cart-button']");
	private By priceAtAddToCartPage = By.xpath("//*[@id=\"hlb-subcart\"]/div[1]/span/span[2]");
	
//	constructor:
	public AmazonAddToCartPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);	
	}
//	page actions:
	public AmazonProceedToCheckOut doClickOnAddToCart() {
		elementUtil.doClick(addToCart);
		return new AmazonProceedToCheckOut(driver);
		
	}
	public double getProductPriceFromAddToCartPage() {
		String priceWithDollar;
		try {
		WebElement findElement = driver.findElement(priceAtAddToCartPage);
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
