package exam.finalExam.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import exam.finalExam.util.Browser;

public class LogInPageObject {
	
	@FindBy(name = "username")
	private static WebElement username;
	@FindBy(name = "password")
	private static WebElement password;
	@FindBy(how = How.XPATH, using = "//a[@class='button']")
	private static WebElement logInButton;
	
	private static String url = "http://shop.pragmatic.bg/admin/";
	
	public static void goToLogInPage(){
		Browser.driver.get(url);
		PageFactory.initElements(Browser.driver, LogInPageObject.class);
		
	}
	
	public static void logIn(String user, String pass){
		username.sendKeys(user);
		password.sendKeys(pass);
		
		logInButton.click();
		
	}
	
}
