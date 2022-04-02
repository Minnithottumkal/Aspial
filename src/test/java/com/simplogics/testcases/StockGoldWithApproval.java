package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class StockGoldWithApproval extends Testbase{
	
	private static int i = 0;
	int rows = (excel.getRowCount("stockGoldWithApproval") - 1);

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void stockGoldWithApproval(Hashtable<String, String> data) throws InterruptedException, AWTException {

		if (!(TestUtil.isTestRunnable("stockGoldWithApproval", excel))) {

			throw new SkipException(
					"Skipping the test " + "stockGoldWithApproval".toUpperCase() + "as the Run mode is NO");
		}

		i++;
		MywaitpresenceOfElementLocated("StockEditItemNoInput_XPATH");
		Thread.sleep(5000);
		click("StockEditItemNoInput_XPATH");
		type("StockEditItemNoInput_XPATH", data.get("ItemNumber"));
		elementtobeclickable("StockEditAddBtn_XPATH");

		System.out.println("Value of i == " + i);
		MywaitinvisibilityOfElementLocated("StockEditLoader_XPATH");
		MywaitinvisibilityOfElementLocated("StockEditToast_XPATH");
		MywaitpresenceOfElementLocated("StockGoldCheckbox1_XPATH");
		click("StockGoldItemNumberDiv_XPATH");

		Tab("Activestate_CSS");
		doubleclick("Activestate_CSS");
		type("StockGoldModel_XPATH", data.get("Model"));

		Tab("StockGoldModel_XPATH");
		MywaitinvisibilityOfElementLocated("StockEditLoader_XPATH");
		doubleclick("StockGoldVersionDiv_XPATH");
		type("StockGoldVersion_XPATH", data.get("Version"));

		Tab("StockGoldVersion_XPATH");
		MywaitinvisibilityOfElementLocated("StockEditLoader_XPATH");
		doubleclick("StockGoldConfigDiv_XPATH");
		type("StockGoldConfig_XPATH", data.get("Config"));

		presstab();
		MywaitinvisibilityOfElementLocated("StockEditLoader_XPATH");

		doubleclick("StockGoldLengthDiv_XPATH");
		type("StockGoldLength_XPATH", data.get("Length/Size"));
		presstab();
		doubleclick("StockGoldUnitWtDiv_XPATH");
		type("StockGoldUnitWt_XPATH", data.get("UnitWt"));
		Tab("StockGoldUnitWt_XPATH");

		if (i == rows) {

			System.out.println("Inside if condition");
			MywaitpresenceOfElementLocated("StockGoldCheckboxAll_XPATH");
			elementtobeclickable("StockGoldCheckboxAll_XPATH");
			Thread.sleep(2000);
			System.out.println("Clicking continue button");
			click("StockGoldContinueBtn_XPATH");

		}

	}

}
