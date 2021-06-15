package equifax.qa.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import equifax.qa.amazon.base.BaseTest;
import equifax.qa.amazon.utils.Constants;

public class AmazonAddToCartPageTest extends BaseTest {
	
	@BeforeClass
	public void AccSetUp() {
		amazonSearchPage = amazonPage.doSearch();
	}
	
	@Test(priority = 1)
	public void amazonAddTocartPageTest() {
		amazonAddToCartPage = amazonSearchPage.doSelectFirstImage();
//		amazonProceedToCheckOutPage = amazonAddToCartPage.doClickOnAddToCart();
		amazonProceedToCheckOut = amazonAddToCartPage.doClickOnAddToCart();
		Assert.assertEquals(amazonAddToCartPage.getProductPriceFromAddToCartPage(), Constants.Price);
	 

}
}