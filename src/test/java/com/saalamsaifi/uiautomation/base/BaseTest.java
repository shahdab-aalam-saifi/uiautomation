package com.saalamsaifi.uiautomation.base;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.saalamsaifi.uiautomation.driver.UIWebDriver;

public class BaseTest {
	protected WebDriver driver;

	@BeforeSuite
	public void setupSuite() {
		this.driver = UIWebDriver.getDriver("chrome");
	}

	@Test
	public void TC1_VerifyWebDriver() {

	}

	@AfterSuite
	public void teardownSuite() {
		if (Objects.nonNull(driver)) {
			driver.quit();
		}
	}
}
