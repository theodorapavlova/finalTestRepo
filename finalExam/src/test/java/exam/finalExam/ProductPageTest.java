package exam.finalExam;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exam.finalExam.pageObjects.DashboardPageObject;
import exam.finalExam.pageObjects.LogInPageObject;
import exam.finalExam.pageObjects.ProductPageObject;
import exam.finalExam.util.Browser;

public class ProductPageTest {

	@Before
	public void setUp(){
		Browser.browserInit();
		LogInPageObject.goToLogInPage();
		LogInPageObject.logIn("admin", "parola");
		DashboardPageObject.verifySuccessfulLogIn();		
	}
	
	@After
	public void lastStep(){
		Browser.shutDown();
	}
	
	@Test
	public void productPageTest() throws Throwable {
		ProductPageObject.goToProductPageTest();
		ProductPageObject.searchProduct("Samsung S6");
		Thread.sleep(1000);
		ProductPageObject.addNewProductTest("Samsung S6");
		Thread.sleep(1000);
	}
}
