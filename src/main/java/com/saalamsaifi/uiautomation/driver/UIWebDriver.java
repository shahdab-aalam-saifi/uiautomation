package com.saalamsaifi.uiautomation.driver;

import static com.saalamsaifi.uiautomation.property.WebDriverProperty.PROP_BROWSER;
import static com.saalamsaifi.uiautomation.property.WebDriverProperty.PROP_DRIVER_PATH_CHROME;
import static com.saalamsaifi.uiautomation.property.WebDriverProperty.PROP_DRIVER_PATH_FIREFOX;
import static com.saalamsaifi.uiautomation.property.WebDriverProperty.PROP_WEBDRIVER_CHROME_DRIVER;

import java.util.Objects;
import java.util.logging.Level;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.saalamsaifi.uiautomation.base.Configuration;
import com.saalamsaifi.uiautomation.util.ExtentManager;
import com.saalamsaifi.uiautomation.util.Utils;

public class UIWebDriver {
	private static UIWebDriver webUiWebDriver;
	private WebDriver driver;

	private UIWebDriver() {
		driver = createDriver();
	}

	/**
	 * @return
	 */
	public static UIWebDriver getInstance() {
		if (Objects.isNull(webUiWebDriver)) {
			webUiWebDriver = new UIWebDriver();
		}
		return webUiWebDriver;
	}

	/**
	 * @return
	 */
	public WebDriver getDriver() {
		return driver;
	}

	private synchronized WebDriver createDriver() {
		final String uiDriver = (String) Configuration.getConfiguration().getProperty(PROP_BROWSER);
		WebDriver webDriver;
		switch (uiDriver.toLowerCase()) {
		case "chrome":
			webDriver = getChromeDriver();
			break;

		case "edge":
			webDriver = null;
			break;

		case "firefox":
			webDriver = getFirefoxDriver();
			break;

		case "ie":
			webDriver = null;
			break;

		default:
			throw new IllegalArgumentException(uiDriver + " is not supported yet.");
		}

		getBrowserInfo(webDriver);
		return webDriver;
	}

	private ChromeDriver getChromeDriver() {
		System.setProperty(PROP_WEBDRIVER_CHROME_DRIVER,
				Utils.USER_DIR + Configuration.getConfiguration().getProperties().get(PROP_DRIVER_PATH_CHROME));

		ChromeOptions options = new ChromeOptions();
		LoggingPreferences logging = new LoggingPreferences();

		logging.enable(LogType.BROWSER, Level.ALL);

		options.addArguments("start-fullscreen", "no-sandbox", "disable-extensions");
		options.setCapability(CapabilityType.LOGGING_PREFS, logging);

		return new ChromeDriver(options);
	}

	private FirefoxDriver getFirefoxDriver() {
		System.setProperty(PROP_WEBDRIVER_CHROME_DRIVER,
				Utils.USER_DIR + Configuration.getConfiguration().getProperty(PROP_DRIVER_PATH_FIREFOX));
		return new FirefoxDriver();
	}

	private void getBrowserInfo(WebDriver webDriver) {
		if (Objects.nonNull(webDriver)) {
			Capabilities capabilities = ((RemoteWebDriver) webDriver).getCapabilities();
			ExtentReports extent = ExtentManager.getReporter();
			extent.setSystemInfo("Browser Name", capabilities.getBrowserName());
			extent.setSystemInfo("Browser Version", capabilities.getVersion());
		}
	}

	/**
	 * @return
	 */
	public JavascriptExecutor getJSExecutor() {
		if (driver instanceof JavascriptExecutor) {
			return (JavascriptExecutor) driver;
		}
		throw new IllegalArgumentException("JavascriptExecutor is not supported");
	}

	/**
	 * @return
	 */
	public CommandExecutor getCommandExecutor() {
		return getRemoteWebDriver().getCommandExecutor();
	}

	/**
	 * @return
	 */
	public RemoteWebDriver getRemoteWebDriver() {
		return (RemoteWebDriver) driver;
	}
}
