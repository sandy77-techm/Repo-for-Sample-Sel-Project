package com.qa.hubspot.TestPages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.Pages.ContactsPage;
import com.qa.hubspot.Pages.HomePage;
import com.qa.hubspot.Pages.LoginPage;
import com.qa.hubspot.Utils.ExcelUtil;
import com.qa.hubspot.Utils.TimeOutUtil;

public class ContactsPageTest {
	WebDriver driver;
	Properties prop;
	LoginPage loginpage;
	BasePage basepage;
	TimeOutUtil timeout;
	HomePage homepage;
	ContactsPage contactspage;
	
	
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
	    contactspage = homepage.gotoContacts();
	
	
	}
	
	@DataProvider(name="getContactsData")
	public Object[][] getContactsTestData()
			
	{
		Object  contactsdata [][] = ExcelUtil.getTestData("Contacts");
		return contactsdata;
		
	}
	@Test(dataProvider ="getContactsData" )
	
	public void createNewContactsTest(String email,String firstname,String lastname,String jobtitle)
	{
		contactspage.createNewContact(email,firstname,lastname,jobtitle);
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
