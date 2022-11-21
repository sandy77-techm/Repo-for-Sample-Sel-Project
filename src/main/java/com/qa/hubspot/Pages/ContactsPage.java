package com.qa.hubspot.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.Utils.ElementActions;

public class ContactsPage extends BasePage{
	WebDriver driver;
	ElementActions elementactions;
	By createContact = By.xpath("//span[@text()='Create contact']");
	By secondCreateContact = By.xpath("//li//span[@text='Create contact']/span]");
	By email = By.id("uid-ctrl-1");
	By fname = By.id("uid-ctrl-2");
	By lname = By.id("uid-ctrl-3");
	By jobtitle = By.id("uid-ctrl-5");
	By designation = By.id("uid-ctrl-7");
	
	public ContactsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void createNewContact(String mailid,String firstname,String lastname,String title)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(createContact));
		elementactions.clickElement(createContact);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(email));
		elementactions.ElementsendKeys(email, mailid);
		
		wait.until(ExpectedConditions.elementToBeClickable(email));
		elementactions.ElementsendKeys(fname, firstname);
		
		wait.until(ExpectedConditions.elementToBeClickable(email));
		elementactions.ElementsendKeys(lname, lastname);
		
		
		
		
		wait.until(ExpectedConditions.elementToBeClickable(email));
		elementactions.ElementsendKeys(jobtitle, title);
		
		
		
		
		
		
		
	}
}
