package com.qa.hubspot.TestPages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.Constants.Constants;
import com.qa.hubspot.Pages.LoginPage;
import com.qa.hubspot.Utils.TimeOutUtil;

public class LoginPageTest {
	WebDriver driver;
	Properties prop;
	LoginPage loginpage;
	BasePage basepage;
	TimeOutUtil timeout;

	@BeforeMethod
	public void setUp()
	{

		basepage = new BasePage();
		prop = basepage.initialize_properties();
		driver = basepage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		timeout.mediumn_wait();
		loginpage = new LoginPage(driver);
	}

	@Test(priority=2)
	public void verifySignUpLink()
	{
		Assert.assertTrue(loginpage.getSignUpLink(), "Sign up link is not visible");
		
	}
	
	@Test(priority=1)
	public void verifyloginpageTitle()
	{
		Assert.assertEquals(loginpage.getLoginPageTitle(), Constants.Login_Page_Title,"Login Page Title is incorrect");
	}
	
	@Test(priority=3)
	public void doLogin()
	{
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
