package com.training.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ContactUsPage {
	WebDriver driver;
	WebDriverWait wait;

	By details = By.id("contactdet");
	By customerCare = By.id("customercare");
	By ccEmail = By.xpath("//span[text()='customercare@firstcry.com']");
	
	public ContactUsPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	private WebElement visAndClick(By locator){
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}
	
	public void detailsClick() {
	    WebElement detailsElement = visAndClick(details);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", detailsElement);
        detailsElement.click();
	}
	
	public void customerCareExpand() {
		WebElement ccElement = visAndClick(customerCare);
   		ccElement.click();
	}
	
	public void validateEmail() {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(ccEmail));
        String actualText = emailElement.getText();
        String expectedText = "customercare@firstcry.com";
        Assert.assertEquals(expectedText, actualText);

	}
}
