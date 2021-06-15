package equifax.qa.amazon.tests;

import org.testng.annotations.Test;

import equifax.qa.amazon.base.BaseTest;


public class AmazonPageTest extends BaseTest {
	
	@Test(priority = 1)
	public void amazonPageTest() {
		amazonPage.doSearch();
	}
	
	
	
	
	
	

}
