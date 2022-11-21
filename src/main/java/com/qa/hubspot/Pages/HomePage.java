package com.qa.hubspot.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.Utils.ElementActions;
import com.qa.hubspot.Utils.TimeOutUtil;

public class HomePage extends BasePage{

	WebDriver driver;
	Properties prop;
	ElementActions elementactions;
	TimeOutUtil timeout;

	By pageheader = By.xpath("//div[@class='private-header__inner']");
	By accountname = By.xpath("//div[@class='user-info-email']");
	By contacts = By.id("nav-primary-contacts-branch");
	By secondcontacts = By.id("nav-secondary-contacts");

	public HomePage()
	{
		this.driver = driver;
	}

	public String getHomePageTitle()
	{
		return elementactions.getTitle();
	}

	public String getHomePageHeaderTitle()
	{
		return elementactions.getHeaderTitle(pageheader, driver);
	}


	public WebElement getAccountName()
	{
		return elementactions.getElement(accountname);


	}

	public void clickonContacts()
	{
		elementactions.clickElement(contacts);
		timeout.short_wait();
		elementactions.clickElement(secondcontacts);
		
	}
	
	public ContactsPage gotoContacts()
	{
		clickonContacts();
		return new ContactsPage(driver);
	}






}