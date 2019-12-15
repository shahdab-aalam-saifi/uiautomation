package com.saalamsaifi.uiautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.saalamsaifi.uiautomation.base.BasePage;

public class GoogleSearchPage extends BasePage {
	@FindBy(xpath = "//span[@class='Q8LRLc']")
	private WebElement country;

	public GoogleSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void verifyBrand(String country) {
		Assert.assertEquals(this.country.getText(), country);
	}

}
