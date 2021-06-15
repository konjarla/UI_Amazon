package equifax.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import equifax.qa.amazon.utils.ElementUtil;

public class AmazonPage {
	
	
	private ElementUtil elementUtil;
	private WebDriver driver;
	
//	Page Objects - By locators - OR
	private By search = By.id("twotabsearchtextbox");
	private By clickSearch = By.xpath("//input[@id='nav-search-submit-button']");
	
//	constructor:
	public AmazonPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
//	page actions:
	public AmazonSearchPage doSearch() {
		elementUtil.doSendKeys(search, "qa testing for beginners");
		elementUtil.doClick(clickSearch);
		return new AmazonSearchPage(driver);
	}
	
	
	

}
