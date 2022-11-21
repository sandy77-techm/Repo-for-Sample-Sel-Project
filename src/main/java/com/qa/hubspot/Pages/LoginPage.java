package com.qa.hubspot.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.Utils.ElementActions;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	Properties prop;
	ElementActions elementactions;
	
	By email = By.id("username");
	By password = By.id("password");
	By SignUpLink =By.linkText("Sign up");
	By loginbtn = By.id("loginBtn");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		elementactions = new ElementActions();
	}
	
	
	
	public String  getLoginPageTitle()
	{
		return elementactions.getTitle();
	}
	
		
	public boolean getSignUpLink()
	{
		return elementactions.getElement(SignUpLink).isDisplayed();
	}
	
	
	public HomePage doLogin(String un,String pwd)
	{
		elementactions.ElementsendKeys(email, "un");
		elementactions.ElementsendKeys(password, pwd);
		elementactions.clickElement(loginbtn);
		return new HomePage();
	}
	
	

}
