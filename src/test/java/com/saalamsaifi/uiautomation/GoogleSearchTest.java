package com.saalamsaifi.uiautomation;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Objects;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.saalamsaifi.uiautomation.js.Performance;
import com.saalamsaifi.uiautomation.listener.TestNGListener;
import com.saalamsaifi.uiautomation.pages.GoogleSearchPage;
import com.saalamsaifi.uiautomation.util.ExtentTestManager;
import com.saalamsaifi.uiautomation.util.Utils;

@Listeners(value = { TestNGListener.class })
public class GoogleSearchTest extends BaseTest {
	private GoogleSearchPage searchPage;

	@BeforeClass
	public void setup() throws IOException {
		searchPage = new GoogleSearchPage(driver);

		driver.get("https://www.google.co.in/");

	}

	@Test
	public void TC1_VerifyCountry() {
		searchPage.verifyBrand("India");
	}

	@Test
	public void TC2_VerifyPageLoadTime() throws JsonProcessingException {
		ExtentTest test = ExtentTestManager.getTest();
		Performance performance = Utils.performance();

		Set<Cookie> cookies = driver.manage().getCookies();

		cookies.forEach(cookie -> {
			test.info(cookie.getName() + ": " + cookie.getValue());
		});
		test.info("navigationStart: " + performance.getTiming().getNavigationStart());
		test.info("loadEventEnd: " + performance.getTiming().getLoadEventEnd());

		System.out.println(performance);

		assertTrue(performance.getTiming().getLoadEventEnd() - performance.getTiming().getNavigationStart() < 5000);
	}

	@AfterClass
	public void tearDown() {
		if (Objects.nonNull(driver)) {
			driver.close();
		}
	}
}
