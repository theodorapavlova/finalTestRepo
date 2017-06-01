package exam.finalExam.pageObjects;

import exam.finalExam.util.Browser;
import static org.junit.Assert.assertEquals;

public class DashboardPageObject {

	public static void verifySuccessfulLogIn() {
		
		assertEquals("Dashboard",Browser.driver.getTitle());
		
	}

}
