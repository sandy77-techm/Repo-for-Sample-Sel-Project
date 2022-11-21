package com.qa.hubspot.BasePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.hubspot.Utils.TimeOutUtil;

public class BasePage {
WebDriver driver;
Properties prop;
TimeOutUtil timeout;
	public WebDriver initialize_driver(Properties prop)
	{
	  String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome"))
				{
			System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
				}
		else
		{
			System.out.println("Driver is not properly intiliazed");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//timeout.mediumn_wait();
		return driver;
	}
	
	public Properties initialize_properties()
	{
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Selenium\\Selenium_Workspace\\HubSpotPOM\\src\\main\\java\\com\\qa\\hubspot\\Configuration\\Config.Properties");
		    try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}
}
