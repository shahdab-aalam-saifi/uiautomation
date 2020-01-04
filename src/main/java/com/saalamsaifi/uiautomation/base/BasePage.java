package com.saalamsaifi.uiautomation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @return
	 */
	public String getTitle() {
		return driver.getTitle();
	}

	/**
	 * 
	 */
	public void explicitWait() {
		wait = new WebDriverWait(driver, 40);
	}

	/**
	 * @param element
	 */
	public void waitVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * @param element
	 */
	public void waitElementClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * @param element
	 */
	public void click(WebElement element) {
		waitVisibility(element);
		waitElementClickable(element);
		element.click();
	}

	/**
	 * @param element
	 * @param text
	 */
	public void writeText(WebElement element, String text) {
		waitVisibility(element);
		element.sendKeys(text);
	}

	/**
	 * @param element
	 * @return
	 */
	public String readText(WebElement element) {
		waitVisibility(element);
		return element.getText();
	}

	/**
	 * @param element
	 * @param expectedText
	 */
	public void assertEquals(WebElement element, String expectedText) {
		waitVisibility(element);
		Assert.assertEquals(readText(element), expectedText);
	}

	/**
	 * @param element
	 */
	public void assertTrue(WebElement element) {
		waitVisibility(element);
		boolean flag = element.isEnabled();
		Assert.assertTrue(flag);
	}

	/**
	 * @param element
	 */
	public void assertFalse(WebElement element) {
		waitVisibility(element);
		boolean flag = element.isEnabled();
		Assert.assertFalse(flag);
	}
}
