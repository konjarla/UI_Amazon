package equifax.qa.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import equifax.qa.amazon.base.BaseTest;

import equifax.qa.amazon.utils.Constants;

public class AmazonSearchPageTest extends BaseTest {
	
	@BeforeClass
	public void AccSetUp() {
		amazonSearchPage = amazonPage.doSearch();
	}
	
	@Test(priority = 1)
	public void amazonSearchPageTest() {
		amazonAddToCartPage = amazonSearchPage.doSelectFirstImage();
		
		Assert.assertEquals(amazonSearchPage.getProductPriceFromSearcgPage(), Constants.Price);
	}
	
	
	
	
}
