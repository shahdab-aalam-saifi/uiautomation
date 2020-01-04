package com.saalamsaifi.uiautomation.util;

import static com.saalamsaifi.uiautomation.property.WebDriverProperty.PROP_DEFAULT_REPORT_FILENAME;
import static com.saalamsaifi.uiautomation.property.WebDriverProperty.PROP_DEFAULT_REPORT_PATH;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.saalamsaifi.uiautomation.base.Configuration;

public class ExtentManager {
	private ExtentManager() {
		// private constructor
	}

	private static final String PROP_OS_NAME = "os.name";
	private static final String PROP_OS_VERSION = "os.version";
	private static final String PROP_OS_ARCH = "os.arch";
	private static final String PROP_JAVA_VERSION = "java.version";

	private static ExtentReports extent;

	/**
	 * @return
	 */
	public static synchronized ExtentReports getReporter() {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			Configuration configuration = Configuration.getConfiguration();
			extent.attachReporter(new ExtentHtmlReporter((String) configuration.getProperty(PROP_DEFAULT_REPORT_PATH)
					+ (String) configuration.getProperty(PROP_DEFAULT_REPORT_FILENAME)));
			extent.setSystemInfo("OS Name", System.getProperty(PROP_OS_NAME));
			extent.setSystemInfo("OS Version", System.getProperty(PROP_OS_VERSION));
			extent.setSystemInfo("OS Architecture", System.getProperty(PROP_OS_ARCH));
			extent.setSystemInfo("Java Version", System.getProperty(PROP_JAVA_VERSION));
		}
		return extent;
	}
}
