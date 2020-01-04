package com.saalamsaifi.uiautomation.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.util.TextUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	private ExtentTestManager() {
		// private constructor
	}

	private static Map<Long, ExtentTest> map = new HashMap<>();
	private static ExtentReports extent = ExtentManager.getReporter();

	/**
	 * @return
	 */
	public static synchronized ExtentTest getTest() {
		return map.get(Thread.currentThread().getId());
	}

	/**
	 * @param name
	 * @param description
	 * @return
	 */
	public static synchronized ExtentTest startTest(String name, String description) {
		ExtentTest test = TextUtils.isBlank(description) ? extent.createTest(name)
				: extent.createTest(name, description);

		map.put(Thread.currentThread().getId(), test);

		return test;
	}
}
