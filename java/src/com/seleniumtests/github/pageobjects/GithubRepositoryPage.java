/**
 * 
 */
package com.seleniumtests.github.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Daniel Kettle
 *
 */
public class GithubRepositoryPage {

	@FindBy(className = "repolist")
	public List<WebElement> div_repolist = null; 
	
}
