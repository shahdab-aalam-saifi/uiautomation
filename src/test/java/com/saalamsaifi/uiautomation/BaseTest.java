package com.saalamsaifi.uiautomation;

import java.util.Objects;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.saalamsaifi.uiautomation.base.Configuration;
import com.saalamsaifi.uiautomation.driver.UIWebDriver;
import com.saalamsaifi.uiautomation.util.ExtentManager;

public class BaseTest {
	protected WebDriver driver;

	@BeforeSuite
	public void setupSuite() {
		Configuration.getConfiguration().load();
		driver = UIWebDriver.getInstance().getDriver();
		driver.manage().window().setSize(new Dimension(768, 1024));
	}

	@AfterSuite
	public void teardownSuite() {
		ExtentManager.getReporter().flush();
		if (Objects.nonNull(driver)) {
			driver.quit();
		}
	}
}
