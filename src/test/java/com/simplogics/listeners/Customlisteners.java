package com.simplogics.listeners;

import java.io.IOException;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.simplogics.utilities.ExtentManager;

import com.simplogics.utilities.TestUtil;

public class Customlisteners extends ExtentManager implements ITestListener, ISuiteListener {

	public void onTestStart(ITestResult result) {

		logger = extent.createTest(result.getName());

	}

	public void onTestSuccess(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, "Pass Testcase is " + result.getName());

		}
	}

	public void onTestFailure(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Testcase Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Testcase Failed", ExtentColor.RED));
			try {
				// TestUtil.captureScreenshot();
				// logger.fail("Details",
				// MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenshotName).build());
				logger.fail("Please check the below Screenshot :",
						MediaEntityBuilder.createScreenCaptureFromBase64String(TestUtil.getbase64()).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void onTestSkipped(ITestResult result) {

		if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, "Skipped Testcase is " + result.getName());
		}

	}

	public void onFinish(ITestContext context) {

	}

}
