package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class StockEditApprover extends Testbase{

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void stockEditApprover(Hashtable<String, String> data) throws InterruptedException, AWTException {
		
		if (!(TestUtil.isTestRunnable("stockEditApprover", excel))) {

			throw new SkipException(
					"Skipping the test " + "stockEditApprover".toUpperCase() + "as the Run mode is NO");
		}
		
		if (!data.get("runmode").equals("Y")) {

			 throw new SkipException("Skipping the test case as the Run mode for data set is NO");
			 }
		
		
		MywaitpresenceOfElementLocated("StockEditApprover_XPATH");
		select("StockEditApprover_XPATH", data.get("Approver"));
		click("StockEditRemarks_XPATH");
		type("StockEditRemarks_XPATH", data.get("Remarks"));
		click("StockEditConfirmBtn_XPATH");

		MywaitpresenceOfElementLocated("Feedback_CSS");
		MywaitinvisibilityOfElementLocated("Feedback_CSS");
		
		 MywaitpresenceOfElementLocated("logout_XPATH");
		
	}
}
