package com.saalamsaifi.uiautomation;

import java.util.Objects;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.saalamsaifi.uiautomation.listener.TestNGListener;
import com.saalamsaifi.uiautomation.pages.GoogleSearchPage;

@Listeners(value = { TestNGListener.class })
public class GoogleSearchTest extends BaseTest {
	private GoogleSearchPage searchPage;

	@BeforeClass
	public void setup() {
		searchPage = new GoogleSearchPage(driver);
	}

	@Test
	public void TC1_VerifyCountry_Pass() {
		driver.get("https://www.google.co.in/");
		searchPage.verifyBrand("India");
	}

	@Test
	public void TC2_VerifyCountry_Fail() {
		driver.get("https://www.google.co.in/");
		searchPage.verifyBrand("US");
	}

	@Test
	public void TC3_VerifyCountry_Skip() {
		driver.get("https://www.google.co.in/");
		throw new SkipException("Skip");
	}

	@AfterClass
	public void tearDown() {
		if (Objects.nonNull(driver)) {
			driver.close();
		}
	}
}
