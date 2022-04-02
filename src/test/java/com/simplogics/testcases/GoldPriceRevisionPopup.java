package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.simplogics.base.Testbase;
import com.simplogics.utilities.ExtentManager;
import com.simplogics.utilities.TestUtil;

public class GoldPriceRevisionPopup extends Testbase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void goldPriceRevisionPopup(Hashtable<String, String> data) throws InterruptedException, AWTException {

		if (!(TestUtil.isTestRunnable("goldPriceRevisionPopup", excel))) {

			throw new SkipException(
					"Skipping the test " + "goldPriceRevisionPopup".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {
			ExtentManager.logger.log(Status.SKIP, "Skipped Option is: " + data.get("Option"));
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		
		MywaitpresenceOfElementLocated("RevisePriceSelect_XPATH");
		select("RevisePriceSelect_XPATH", data.get("Option"));
		presstab();
		type("RevicePriceInput_XPATH", data.get("Value"));
		click("RevisePriceContinue_XPATH");
		
		MywaitpresenceOfElementLocated("ReviseEffectiveDate_XPATH");
		click("ReviseEffectiveDate_XPATH");
		type("ReviseEffectiveDate_XPATH", data.get("Date"));
		MywaitpresenceOfElementLocated("RevisePriceConfirm_XPATH");
		click("RevisePriceConfirm_XPATH"); 
	}

}
