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
	private WebElement recursiveWebElementByClass(WebElement we, String[] classNames)
	{
		if (classNames.length == 1) return we.findElement(By.className(classNames[0])); 
		else {
			return recursiveWebElementByClass(we.findElement(
					By.className(classNames[0])),
					Arrays.copyOfRange(classNames, 1, classNames.length));
		}
	}
	
	public List<String> getRepositories()
	{
		List<String> a = new ArrayList<String>(10);
		System.out.println(String.format("div_repolist %s", div_repolist.toString()));
		WebElement repo = div_repolist.get(0);
		List<WebElement> repoItems = repo.findElements(By.className("source"));
		System.out.println("Repository Items Under 'repolist' class " + repoItems.size());
		String[] strArray = {"repo-stats", "language"};
		a.add(recursiveWebElementByClass(repoItems.get(0), strArray).getText());
		return a;
	}
	
}
