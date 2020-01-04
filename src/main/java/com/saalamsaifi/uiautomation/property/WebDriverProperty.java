package com.saalamsaifi.uiautomation.property;

import com.saalamsaifi.uiautomation.util.Utils;

public final class WebDriverProperty {
	private WebDriverProperty() {
		// private constructor
	}

	public static final String PROP_WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	public static final String PROP_WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";

	public static final String PROP_BROWSER = "browser";
	public static final String PROP_OS = "os";
	public static final String PROP_REPORT_PATH = "report.path";
	public static final String PROP_REPORT_FILENAME = "report.filename";
	public static final String PROP_DRIVER_CONFIG = "driver.config";
	public static final String PROP_DRIVER_PATH_CHROME = "driver.path.chrome";
	public static final String PROP_DRIVER_PATH_FIREFOX = "driver.path.firefox";

	public static final String PROP_DEFAULT_BROWSER = "chrome";
	public static final String PROP_DEFAULT_OS = "mac";
	public static final String PROP_DEFAULT_REPORT_PATH = Utils.USER_DIR;
	public static final String PROP_DEFAULT_REPORT_FILENAME = "/ExtentReport.html";
	public static final String PROP_DEFAULT_DRIVER_CONFIG = "auto";
	public static final String PROP_DEFAULT_DRIVER_PATH_CHROME = "/drivers/mac/chromedriver";
	public static final String PROP_DEFAULT_DRIVER_PATH_FIREFOX = "/drivers/mac/geckodriver";

}
