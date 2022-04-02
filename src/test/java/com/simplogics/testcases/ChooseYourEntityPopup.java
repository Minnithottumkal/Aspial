package com.simplogics.testcases;

import java.util.Hashtable;

import org.testng.SkipException;

import com.simplogics.utilities.ExtentManager;
import com.simplogics.utilities.TestUtil;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.simplogics.base.Testbase;

@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
public class ChooseYourEntityPopup extends Testbase {

	public void chooseyourentity(Hashtable<String, String> data) throws InterruptedException {
		if (!(TestUtil.isTestRunnable("chooseyourentity", excel))) {

			throw new SkipException("Skipping the test " + "chooseyourentity".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			ExtentManager.logger.log(Status.SKIP, "Skipped Entity is: " + data.get("Entity"));
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");

		}
		// super.timedelay();
		MywaitpresenceOfElementLocated("entity1_CSS");
		Thread.sleep(5000);
		entitySelection(data.get("Entity"));
		Thread.sleep(1000);
		SubaccountSelection(data.get("Subaccount"));

		// String ActualpageURL = driver.getCurrentUrl().toString();
		// String ExpectedpageURL =
		// "https://aspial-tst.outsystemsenterprise.com/IMSLogin/Home";
		// assertEquals (ActualpageURL, ExpectedpageURL);

	}
}
