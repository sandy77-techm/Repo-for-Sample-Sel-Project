package com.qa.hubspot.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.BasePage.BasePage;

public class ElementActions extends BasePage{
	WebDriver driver;

	public ElementActions()
	{
		this.driver = driver;
	}

	public WebElement  getElement(By locator)
	{
		WebElement element = getElement(locator);
		return element;
	}

	public void ElementsendKeys(By locator,String value)
	{
      getElement(locator).sendKeys(value);
	}
	
	public void clickElement(By locator)
	{
		getElement(locator).click();
	}
	
	public String getTitle()
	{
		
	
		String title = driver.getTitle();
		
		return title;
	}
	
	public String getHeaderTitle(By locator,WebDriver driver)
	{
		WebElement element = getElement(locator);
		String title = driver.getTitle();
		return title;
	}

}
