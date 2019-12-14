package com.saalamsaifi.uiautomation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.saalamsaifi.uiautomation.property.WebDriverProperty;
import com.saalamsaifi.uiautomation.util.Utils;

public class UIWebDriver {
	private UIWebDriver() {
		// private constructor
	}

	public static WebDriver getDriver(String uiDriver) {
		switch (uiDriver.toLowerCase()) {
		case "chrome":
			return getChromeDriver();

		case "edge":
			return null;

		case "firefox":
			return getFirefoxDriver();

		case "ie":
			return null;

		default:
			throw new IllegalArgumentException(uiDriver + " is not supported yet.");
		}
	}

	private static ChromeDriver getChromeDriver() {
		System.setProperty(WebDriverProperty.PROP_WEBDRIVER_CHROME_DRIVER,
				Utils.USER_DIR + "/drivers/mac/chromedriver");

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extenstions");
		options.addArguments("--disable-infobars");

		return new ChromeDriver(options);
	}

	private static FirefoxDriver getFirefoxDriver() {
		return new FirefoxDriver();
	}
}
