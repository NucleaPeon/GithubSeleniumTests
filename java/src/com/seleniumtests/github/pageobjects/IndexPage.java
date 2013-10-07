package com.seleniumtests.github.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @date 2013-10-06
 * @author Daniel Kettle
 * 
 * IndexPage is a class that contains information on the GitHub main page
 *
 * Use methods for actions, use variables for attributes that do not change.
 * It may be prudent to have both Tests and PageObjects in the same package
 * so attributes do not have to be public, for security.
 */
public class IndexPage {

	public String title = "GitHub";
	public int signInElements = 1;
	
	@FindBy(className = "signin")
	public List<WebElement> webSignInButton = null;
	
	public void clickOnSignInButton()
	{
		this.webSignInButton.get(0).click();
	}
}
