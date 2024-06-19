package com.BaseClassPackage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.training.Pages.ContactUsPage;
import com.training.Pages.HomePage;
import com.training.Pages.StoreLocatorPage;

public class BaseDriver {
	public static WebDriver driver;
	public HomePage hp;
	public ContactUsPage cup;
	public StoreLocatorPage slp;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.firstcry.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();

		hp = new HomePage(driver);
		cup = new ContactUsPage(driver);
		slp = new StoreLocatorPage(driver);
	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.quit();
		} 
	} 
	
	public WebDriver getDriver() {
		return driver;
	}
}