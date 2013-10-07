/**
 * 
 */
package com.seleniumtest.tests; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @author Daniel Kettle
 *
 */
public class TestGoogleCom {

	WebDriver webDriver = null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
	
	@BeforeMethod
	public void setUp()
	{
		webDriver = new FirefoxDriver();
		
		//webDriver.get("http://www.google.com");
		webDriver.navigate().to("http://www.google.com");
	}
	
	@Test
	public void testASearch() throws InterruptedException
	{
		//gbqfq
		
		WebElement searchBar = webDriver.findElement(By.id("gbqfq"));
		searchBar.sendKeys("Your Mom");
		String searchValue = searchBar.getAttribute("value");
		Assert.assertEquals(searchValue, "Your Mom", "Unrecognized Search Term");
		Assert.assertFalse(searchValue == "Not My Mom", "This should have failed");
		
		
		searchBar.submit();
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		boolean hasTitle = wait.until(ExpectedConditions.titleContains("Your Mom"));
		Assert.assertEquals(hasTitle, true);
		
		webDriver.get("http://www.google.com");
		searchBar = webDriver.findElement(By.id("gbqfq"));
		searchBar.sendKeys("My Mom");
		wait = new WebDriverWait(webDriver, 10);
		hasTitle = wait.until(ExpectedConditions.not(ExpectedConditions.titleContains("Your Mom")));
		Assert.assertEquals(hasTitle, true);
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		webDriver.quit();
	}

}
