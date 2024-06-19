package com.training.Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;

	By SPNav = By.xpath("//span[text()='Stores & Preschools']");
	By findStores = By.xpath("//span[text()='Find Stores']");
	By searchBox = By.id("search_box");
	By searchBTN = By.className("search-button");
	By contactLink = By.xpath("//a[@href='//www.firstcry.com/contactus']");

	public HomePage(WebDriver driver) {
		this.driver=driver;
	}

	public void hoverSP() {
		WebElement SPNavElement = driver.findElement(SPNav);
		Actions actions = new Actions(driver);
		actions.moveToElement(SPNavElement).perform();
	}

	public void clickFindStore() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement findStoresElement = wait.until(ExpectedConditions.visibilityOfElementLocated(findStores));
		findStoresElement.click();
	}

	public void enterSearchKey(String val) {
		driver.findElement(searchBox).sendKeys(val);
	}

	public void searchBtnClick() {
		driver.findElement(searchBTN).click();
	}

	public void contactUsClick() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement contactLinkElement = wait.until(ExpectedConditions.visibilityOfElementLocated(contactLink));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactLinkElement);
		wait.until(ExpectedConditions.elementToBeClickable(contactLinkElement)).click();
	}
	public void switchToNewTab() {     
		String currentWindow = driver.getWindowHandle();
		List<String> handles = new ArrayList<>(driver.getWindowHandles());
		for (String handle : handles) {
			if (!handle.equals(currentWindow)) {
				driver.switchTo().window(handle);
				break;
			}
		}
	}
}
