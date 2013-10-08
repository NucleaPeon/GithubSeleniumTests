/**
 * 
 */
package com.seleniumtests.github.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Daniel Kettle
 *
 */
public class GithubUserPage {

	/**
	 * Contains the body of the repository page and all desirable elements
	 * should be found here.
	 */
	@FindBy(id = "site-container")
	public WebElement site_container = null;
	
	@FindBy(className = "tabnav-tabs")
	public WebElement repoTab;
	
	
	public void clickRepositoryTab()
	{
		//List<WebElement> items = repoTab.findElements(By.cssSelector("css=li[data-tab='repo']"));
		List<WebElement> items = repoTab.findElements(By.cssSelector("li"));
		for (WebElement we : items)
		{
			if (we.getAttribute("data-tab").equals("repo"))
				we.findElement(By.cssSelector("a")).click();
				
//			{
//				System.out.println("Click");
//				we.findElement(By.cssSelector("a")).click();
//			}
		}
		
	}
	
}
