package com.saalamsaifi.uiautomation.listener;

import org.apache.http.util.TextUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.saalamsaifi.uiautomation.BaseTest;
import com.saalamsaifi.uiautomation.util.ExtentManager;
import com.saalamsaifi.uiautomation.util.ExtentTestManager;

public class TestNGListener extends BaseTest implements ITestListener {
	private final Logger logger = LogManager.getLogger();

	private String getTestName(ITestResult result) {
		if (TextUtils.isBlank(result.getTestName())) {
			return result.getName();
		} else {
			return result.getTestName();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTestManager.startTest(getTestName(result), null);
		logger.info(getTestName(result) + " Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
		logger.info(getTestName(result) + " Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		logger.info(getTestName(result) + " Test Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ExtentTestManager.getTest().log(Status.WARNING, "Test Failed Within Success Percentage");
	}

	@Override
	public void onStart(ITestContext context) {
		context.setAttribute("WebDriver", this.driver);
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentManager.getReporter().flush();
	}

}
