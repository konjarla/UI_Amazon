package equifax.qa.amazon.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import equifax.qa.amazon.utils.ElementUtil;

public class AmazonProceedToCheckOut {
	private ElementUtil elementUtil;
	private WebDriver driver;
	
	
//	Page Objects - By locators - OR
	private By proceedToCheckOut = By.id("hlb-ptc-btn-native");
	private By priceProceedToCheckOut = By.xpath("//*[@id=\"subtotals-marketplace-table\"]/tbody/tr[1]/td[2]");
	
//	constructor:
	public AmazonProceedToCheckOut(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);	
	}
	

	public void doClickProceedToCheckOut() {
		elementUtil.doClick(proceedToCheckOut);	
	}
	
	public double getProductPriceFromCheckOutPage() {
		String priceWithDollar;
		try {
		WebElement findElement = driver.findElement(priceProceedToCheckOut);
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
