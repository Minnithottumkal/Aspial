package com.simplogics.testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;
@Test()
public class StockManagement  extends Testbase {
	public void Stockmanagement() {
		if (!(TestUtil.isTestRunnable("Stockmanagement", excel))) {

			throw new SkipException("Skipping the test " + "Stockmanagement".toUpperCase() + "as the Run mode is NO");
		}
		MywaitpresenceOfElementLocated("stockmenu_CSS");
		click("stockmenu_CSS");
		MywaitvisibilityOfElementLocated("Bulklistingstockmenu_ID");
		click("Bulklistingstockmenu_ID");
	}

}
