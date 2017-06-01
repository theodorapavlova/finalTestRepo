package exam.finalExam.pageObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import exam.finalExam.util.Browser;


public class ProductPageObject {

	public static void goToProductPageTest() {
		Browser.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement catalog = Browser.driver.findElement(By.id("catalog"));
		WebElement products = Browser.driver.findElement(By.xpath("//a[contains(@href,'product')]"));
		Actions actionBuilder = new Actions(Browser.driver);
		
		actionBuilder.moveToElement(catalog).moveToElement(products).click().perform();
		
	}
	
	public static void clearFilterByName () {
		Browser.driver.findElement(By.name("filter_name")).clear();
	}
	
	public static void searchProduct(String nameOfProduct){
		WebElement filterByName = Browser.driver.findElement(By.name("filter_name"));
		WebElement filterButton = Browser.driver.findElement(By.linkText("Filter"));
		
		filterByName.sendKeys(nameOfProduct);
		filterButton.click();
		clearFilterByName();
	}
	
	public static void insertProduct(String nameOfProduct){
		 Browser.driver.findElement(By.xpath("//a[contains(@href,'insert')]")).click();
		 Browser.driver.findElement(By.name("product_description[1][name]")).sendKeys(nameOfProduct);
		 Browser.driver.findElement(By.xpath("//a[@href='#tab-data']")).click();
		 Browser.driver.findElement(By.name("model")).sendKeys("Phone");
		 Browser.driver.findElement(By.linkText("Save")).click();
		 Assert.assertTrue(Browser.driver.findElement(By.className("success")).isDisplayed());
		
	}
	
	public static void deleteProduct(String nameOfProduct){
//		clearFilterByName();
		searchProduct(nameOfProduct);
		List<WebElement> existingProducts = new ArrayList<WebElement>(Browser.driver.findElements(By.name("selected[]")));
		Assert.assertFalse(existingProducts.isEmpty());
		Iterator<WebElement> iterator = existingProducts.iterator();
		while(iterator.hasNext()){
			iterator.next().click();
		}
		Browser.driver.findElement(By.linkText("Delete")).click();
		Browser.driver.switchTo().alert().accept();
		
		Assert.assertTrue(Browser.driver.findElement(By.className("success")).isDisplayed());
	}

	public static void addNewProductTest(String nameOfProduct) {
		searchProduct(nameOfProduct);
//		clearFilterByName();
		if(Browser.driver.findElement(By.xpath("//tr[2]/td[@class='center']")).getText().equalsIgnoreCase("No results!")){
			insertProduct(nameOfProduct);
		
		} else {
			deleteProduct(nameOfProduct);
			insertProduct(nameOfProduct);
		}
	
	}
	
}
