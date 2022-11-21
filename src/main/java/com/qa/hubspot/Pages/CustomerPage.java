package com.qa.hubspot.Pages;

import org.openqa.selenium.WebDriver;

import com.qa.hubspot.BasePage.BasePage;

public class CustomerPage extends BasePage {

	WebDriver driver;
	
	public CustomerPage(WebDriver driver)
	{
		this.driver = driver;
	}
}
