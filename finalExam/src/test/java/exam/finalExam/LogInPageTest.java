package exam.finalExam;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exam.finalExam.pageObjects.DashboardPageObject;
import exam.finalExam.pageObjects.LogInPageObject;
import exam.finalExam.util.Browser;

public class LogInPageTest {
	
	@Before
	public void setUp(){
		Browser.browserInit();
		
	}
	
	@Test
	public void logInTest(){
		LogInPageObject.goToLogInPage();
		LogInPageObject.logIn("admin", "parola");
		DashboardPageObject.verifySuccessfulLogIn();
	}
	
	@After
	public void lastStep(){
		Browser.shutDown();
	}
}
