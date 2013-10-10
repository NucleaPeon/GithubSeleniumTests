/**
 * 
 */
package com.seleniumtests.github.pageobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Daniel Kettle
 *
 */
public class GithubRepositoryPage {

	@FindBy(className = "repolist")
	public List<WebElement> div_repolist = null; 
	
	/**
	 * Recursively searches for WebElements by Class Name, picking the first object found
	 * until all the classNames parameters have been used.
	 * 
	 * Example: Search for ["source", "repo-stats", "language"] for github.com will result
	 * in getting the programming language value for a repository, provided you start
	 * searching from the "repolist" WebElement.
	 * 
	 * Note: As stated above, it picks the first object in every list returned by fetching
	 * via the className. (Classes always return a list, no ids are used in github css for
	 * this)
	 * 
	 * @param we		 - WebElement that we start looking from
	 * @param classNames - Array of Strings that represent the classname from the
	 *                     specified WebElement to the desired WebElement value
	 *                     
	 * @return WebElement - WebElement at the end of the classNames arrays
	 */
//	private WebElement recursiveWebElementByClass(WebElement we, String[] classNames)
//	{
//		if (classNames.length == 1) return we.findElement(By.className(classNames[0])); 
//		else {
//			return recursiveWebElementByClass(we.findElement(
//					By.className(classNames[0])),
//					Arrays.copyOfRange(classNames, 1, classNames.length));
//		}
//	}
	
//	public List<String> getRepositoryLanguages()
//	{	
//		
//		List<String> a = new ArrayList<String>(6);
////		String[] strArray = {"repo-stats", "language"};
////		for ( WebElement repoItem : ) {
////			a.add(recursiveWebElementByClass(repoItem, strArray).getText());
////			System.out.println(a.get(a.size() - 1));
////		}
////		return a;
//		
//	}
//	
//
//	public List<String> getRepositoryNames() {
//		List<String> a = new ArrayList<String>(div_repolist.size());
//		String[] strArray = {"source", "repolist-name"};
//		for ( WebElement repoItem : div_repolist )
//			a.add(recursiveWebElementByClass(repoItem, strArray).getCssValue("a"));
//		return a;
//	}
	
}
