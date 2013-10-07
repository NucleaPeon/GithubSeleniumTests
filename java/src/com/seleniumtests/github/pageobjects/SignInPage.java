package com.seleniumtests.github.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Daniel Kettle
 * @date 2013-10-06
 * 
 * SignInPage contains all elements for username and password inputs,
 * as well as sign-in capabilities.
 * 
 * Contains methods for entering data and actual sign in.
 */
public class SignInPage {
	
	@FindBy(id = "login_field")
	public WebElement login_field = null;
	@FindBy(id = "password")
	public WebElement password = null;
	
	@FindBy(name = "commit")
	public List<WebElement> buttonClasses = null;
	
	public void enterUserName(String name)
	{
		login_field.sendKeys(name);
	}
	
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void signIn()
	{
		buttonClasses.get(0).click();
	}
	
}
