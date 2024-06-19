package com.training.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StoreLocatorPage {
	WebDriver driver;
	WebDriverWait wait;
	
	By storeType = By.id("storetype");
	By state = By.name("state");
	By city = By.name("city");
	By srchBtn = By.xpath("//input[@value='Search']");

	public StoreLocatorPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void navAssert() {
		String urlActual = driver.getCurrentUrl();
		String urlExpected = "https://www.firstcry.com/store-locator?ref2=topstrip";
		Assert.assertEquals(urlExpected, urlActual);
	}
	
	public void selectStore(String value) {
		Select storedd = new Select(driver.findElement(storeType));
		storedd.selectByValue(value);
	}
	
	public void selectState(String value) {
		Select statedd = new Select(driver.findElement(state));
		statedd.selectByValue(value);
	}
	public void selectCity(String value) {
		Select citydd = new Select(driver.findElement(city));
		citydd.selectByValue(value);
	}
	public void clickSearch() {
		driver.findElement(srchBtn).click();
	}
}


