package com.saalamsaifi.uiautomation;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.saalamsaifi.uiautomation.driver.UIWebDriver;
import com.saalamsaifi.uiautomation.pages.GoogleSearchPage;

public class GoogleSearchTest {
	private WebDriver driver;
	private GoogleSearchPage searchPage;

	@BeforeClass
	public void setup() {
		this.driver = UIWebDriver.getDriver("chrome");
		this.searchPage = new GoogleSearchPage(this.driver);
	}

	@Test
	public void TC1_VerifyCountry() throws InterruptedException {
		this.driver.get("https://www.google.co.in/");

		Thread.sleep(2000);
		
		this.searchPage.verifyBrand("India");
	}

	@AfterClass
	public void tearDown() {
		if (Objects.nonNull(driver)) {
			driver.quit();
		}
	}
}
