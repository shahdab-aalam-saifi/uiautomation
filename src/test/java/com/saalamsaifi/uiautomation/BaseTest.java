package com.saalamsaifi.uiautomation;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.saalamsaifi.uiautomation.driver.UIWebDriver;

public class BaseTest {
	protected WebDriver driver;

	@BeforeSuite
	public void setupSuite() {
		driver = UIWebDriver.getDriver("chrome");
	}

	@AfterSuite
	public void teardownSuite() {
		if (Objects.nonNull(driver)) {
			driver.quit();
		}
	}
}
