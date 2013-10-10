/**
 * 
 */
package com.seleniumtests.github.tests;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.seleniumtests.github.pageobjects.*;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Daniel Kettle
 * @date 2013-10-06
 *
 * Test class for http://www.github.com, class to test login and retrieving repository
 * information.
 * 
 * TODO: Grab repository names, commits, and dates related to repo.
 * TODO: Package in runnable jar file
 */
public class TestGithubCom {

	WebDriver webDriver = null; 	// Firefox Driver
	IndexPage page = null; 			// Github Page 
	private String username = null; // Username for tests
	private String password = null; // Password for tests
	
	public static final String GITHUB = "http://github.com";
	
	/**
	 * Request username and password, store for test suite
	 */
	@BeforeSuite
	public void setUpSuite()
	{
		this.username = (String)JOptionPane.showInputDialog("Enter Username:");
		JPasswordField pf = new JPasswordField();
		int okCxl = JOptionPane.showConfirmDialog(null, pf, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (okCxl == JOptionPane.OK_OPTION) {
			this.password = new String(pf.getPassword());
		}
	}
	
	/**
	 * Initialize driver and main web page for testing
	 */
	@BeforeMethod
	public void setUp()
	{
		webDriver = new FirefoxDriver();
		webDriver.navigate().to(GITHUB);
		page = PageFactory.initElements(webDriver, IndexPage.class);
		Assert.assertTrue(page != null, "Page is invalid (null)");
	}
	
	/**
	 * Close webpage after every test
	 */
	@AfterMethod
	public void tearDown()
	{
		webDriver.close();
	}
	
	/**
	 * Navigate to main page and detect title
	 */
//	@Test
//	public void testGitHubMainpage()
//	{
//		Assert.assertTrue(webDriver.getTitle().startsWith(page.title), 
//				String.format("Page title is NOT prefixed with %s", 
//							  page.title));
//	}
//	
	/**
	 * Navigate to main page and attempt to navigate to sign in page by clicking
	 * on Sign In elements, test title again and initialize the SignIn PageObject
	 */
//	@Test
//	public void testGitHubSignInButton()
//	{
//		Assert.assertTrue(page.webSignInButton.size() == page.signInElements, 
//							"More than one signin class object");
//		
//		page.clickOnSignInButton();
//		WebDriverWait wait = new WebDriverWait(webDriver, 10);
//		boolean hasTitle = wait.until(ExpectedConditions.titleContains(page.title));
//		Assert.assertEquals(hasTitle, true, 
//							String.format("Title does not have %s in the name", page.title));
//		// If we can init the sign in page, components match up and test can pass
//		SignInPage signInPage = PageFactory.initElements(webDriver, SignInPage.class);
//		Assert.assertTrue(signInPage != null);
//	}
//	
	/**
	 * Navigate to sign in page, fill out fields with data gathered from BeforeSuite 
	 * decorated method and attempt to sign on using login form
	 * 
	 * @see setUpSuite()
	 */
	@Test
	public void testGitHubSignIn()
	{
		// I *could* put my actual name and password here, but for obvious security reasons,
		// the only use case where I would would be if I had a test account, not a real one.
		
		page.clickOnSignInButton();
		SignInPage signInPage = PageFactory.initElements(webDriver, SignInPage.class);
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		WebElement loginField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login_field")));
		Assert.assertEquals(loginField, signInPage.login_field);
		signInPage.enterUserName(username);
		signInPage.enterPassword(password);
		signInPage.signIn();
		webDriver.navigate().to(webDriver.getCurrentUrl() + username);
		GithubUserPage userPage = PageFactory.initElements(webDriver, GithubUserPage.class);
		userPage.clickRepositoryTab(); // Show Click on tab showing repositories
		wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("repolist")));
		GithubRepositoryPage repos = PageFactory.initElements(webDriver, GithubRepositoryPage.class);
		Assert.assertTrue(repos != null);
		List<WebElement> repoItems = repos.div_repolist.get(0).findElements(By.cssSelector("li"));
		List<Repo> myRepos = new ArrayList<Repo>(10);
		Repo r = null;
		for ( WebElement we : repoItems )
		{
			r = new Repo("", "", 0);
			List<WebElement> repostats = we.findElements(By.cssSelector("ul[class='repo-stats']"));
			if ( repostats.size() > 0 )
			{
				for ( WebElement rs : repostats) 
				{
					r.language = rs.getText();
				}
			}
			repostats = we.findElements(By.cssSelector("h3[class='repolist-name']"));
			if ( repostats.size() > 0 )
			{
				for ( WebElement rs : repostats) 
				{
					r.reponame = rs.getText();
				}
			}
			
			repostats = we.findElements(By.cssSelector("h3[class='repolist-name']"));
			if ( repostats.size() > 0 )
			{
				for ( WebElement rs : repostats) 
				{
					r.url = String.format("%s/%s/%s", GITHUB, username, r.reponame);
				}
			}
			
			if (r.reponame != "")
				myRepos.add(r);
		}
		for ( Repo reps : myRepos )
		{
			System.out.println(reps);
		}
			
		
	}
	
//	@Test
//	public void testGetUserRepositories()
//	{
//		page.clickOnSignInButton();
//		SignInPage signInPage = PageFactory.initElements(webDriver, SignInPage.class);
//		signInPage.enterUserName(username);
//		signInPage.enterPassword(password);
//		signInPage.signIn();
//		WebDriverWait wait = new WebDriverWait(webDriver, 10);
//		GithubDashboard dashboard = PageFactory.initElements(webDriver, GithubDashboard.class);
//		System.out.println(dashboard);
//	}
	
	
	
	
	/**
	 * After all tests are run, remove sensitive data from virtual machine
	 */
	@AfterSuite
	public void tearDownSuite()
	{
		this.username = null;
		this.password = null;
		System.gc(); // Force garbage collector to remove references and data to name & pw
	}
	
	protected class Repo
	{
		String language = null;
		String reponame = null;
		String url 		= null;
		int commits 	= -1;
		
		public Repo(String language, String name, int commits)
		{
			this.url = "";
			this.language = language;
			this.reponame = name;
			this.commits = commits;
		}
		
		public Repo(String url, String language, String name, int commits)
		{
			this.url = url;
			this.language = language;
			this.reponame = name;
			this.commits = commits;
		}
		
		/**
		 * Override default toString method to determine value of repository
		 */
		public String toString()
		{
			return String.format("Repository <%s>: Written in %s with %s commits, [%s]", this.reponame, this.language, "" + this.commits, this.url);
		}
	}
	
	
}
