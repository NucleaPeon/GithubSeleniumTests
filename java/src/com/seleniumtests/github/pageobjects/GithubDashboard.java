/**
 * 
 */
package com.seleniumtests.github.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Daniel Kettle
 * @date 2013-10-06
 * 
 * GithubDashboard is the PageObject that contains dashboard information
 * and links for navigating github for obtaining useful information,
 * then for logging out.
 */
public class GithubDashboard {
	
	/**	
	 * This variable will not be null if the elements are found -- aka
	 * the uesr has been logged in successfully.
	 * WebElement is found by class name "logged_in"
	 */
	@FindBy(className = "logged_in")
	public List<WebElement> body = null; 
	
	/**
	 * Logout element is a a href link to logout. This should exist as well as
	 * logged_in element, which we want to click to get to our repository screen.
	 */
	private WebElement logout = null;
	
	@FindBy(className = "name")
	public List<WebElement> usernameLink = null; 
	

}
