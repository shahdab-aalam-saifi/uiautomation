package com.saalamsaifi.uiautomation.listener;

import org.apache.http.util.TextUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.saalamsaifi.uiautomation.util.ExtentManager;
import com.saalamsaifi.uiautomation.util.ExtentTestManager;

public class TestNGListener implements ITestListener {
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
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skip");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
//		context.setAttribute("WebDriver", this.driver);
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentManager.getReporter().flush();
	}

}
