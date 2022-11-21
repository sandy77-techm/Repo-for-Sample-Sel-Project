package com.qa.hubspot.TestPages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.Constants.Constants;
import com.qa.hubspot.Pages.HomePage;
import com.qa.hubspot.Pages.LoginPage;
import com.qa.hubspot.Utils.TimeOutUtil;

public class HomePageTest {
	WebDriver driver;
	Properties prop;
	LoginPage loginpage;
	BasePage basepage;
	TimeOutUtil timeout;
	HomePage homepage;
	
	@BeforeMethod
	public void setUp()
	{

		basepage = new BasePage();
		prop = basepage.initialize_properties();
		driver = basepage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		timeout.mediumn_wait();
		loginpage = new LoginPage(driver);
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle()
	{
		Assert.assertEquals(homepage.getHomePageTitle(), Constants.Home_Page_Title,"Home Page Title is incorrect");
	}
	
	
	@Test(priority=2)
	public void  verifyHomePageHeaderTitle()
	{
		Assert.assertEquals(homepage.getHomePageHeaderTitle(), Constants.Home_Page_Header,"Header Title is incorrect");
	}
	
	@Test(priority=3)
	public void verifyAccountName()
	{
		
		Assert.assertEquals(homepage.getAccountName(), "Account Name is incorrect");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}



