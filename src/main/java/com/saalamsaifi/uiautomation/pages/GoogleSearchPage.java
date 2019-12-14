package com.saalamsaifi.uiautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GoogleSearchPage {
	private WebDriver driver;

	@FindBy(xpath = "//span[@class='Q8LRLc']")
	private WebElement country;

	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void verifyBrand(String country) {
		Assert.assertEquals(this.country.getText(), country);
	}

}
