package com.saalamsaifi.uiautomation.util;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
	private ExtentManager() {
		// private constructor
	}

	private static final String REPORT_FILE_NAME = "ExtentReport.html";

	private static ExtentReports extent;

	public static synchronized ExtentReports getReporter() {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			extent.attachReporter(new ExtentHtmlReporter(REPORT_FILE_NAME));
		}
		return extent;
	}
}
