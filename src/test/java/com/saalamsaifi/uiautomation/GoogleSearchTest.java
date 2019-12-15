package com.saalamsaifi.uiautomation;

import java.util.Objects;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.saalamsaifi.uiautomation.base.BaseTest;
import com.saalamsaifi.uiautomation.pages.GoogleSearchPage;

public class GoogleSearchTest extends BaseTest {
	private GoogleSearchPage searchPage;

	@BeforeClass
	public void setup() {
		searchPage = new GoogleSearchPage(driver);
	}

	@Test
	public void TC1_VerifyCountry() throws InterruptedException {
		driver.get("https://www.google.co.in/");

		searchPage.verifyBrand("India");
	}

	@AfterClass
	public void tearDown() {
		if (Objects.nonNull(driver)) {
			driver.close();
		}
	}
}
