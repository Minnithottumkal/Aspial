package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.simplogics.base.Testbase;
import com.simplogics.utilities.ExtentManager;
import com.simplogics.utilities.TestUtil;

public class Relogin extends Testbase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void relogin(Hashtable<String, String> data) throws InterruptedException, AWTException {

		if (!(TestUtil.isTestRunnable("relogin", excel))) {

			throw new SkipException("Skipping the test " + "relogin".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {
			ExtentManager.logger.log(Status.SKIP, "Skipped User is: " + data.get("username"));
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}

		MywaitpresenceOfElementLocated("loginbtn_ID");
		MywaitpresenceOfElementLocated("username_ID");
		type("username_ID", data.get("username"));
		type("password_ID", data.get("password"));
		click("loginbtn_ID");
	}
}
