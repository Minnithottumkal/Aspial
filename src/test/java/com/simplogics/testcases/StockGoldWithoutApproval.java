package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class StockGoldWithoutApproval extends Testbase{
	
	public static int i = 0;
	int rows = (excel.getRowCount("stockGoldWithoutApproval")-1);
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void stockGoldWithoutApproval(Hashtable<String, String> data) throws AWTException, InterruptedException {
		
		if (!(TestUtil.isTestRunnable("stockGoldWithoutApproval", excel))) {

			throw new SkipException("Skipping the test " + "stockGoldWithoutApproval".toUpperCase() + "as the Run mode is NO");
		}
		
		System.out.println("ROWS = " + rows);
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
		
		doubleclick("StockGoldLengthDiv_XPATH");
		type("StockGoldLength_XPATH", data.get("Length/Size"));
		Tab("StockGoldLength_XPATH");
//		doubleclick("Activestate_CSS");
//		type("StockGoldUnitWt_XPATH", data.get("UnitWt"));
//		Tab("StockGoldUnitWt_XPATH");
		
		if(i == rows) {
			
			System.out.println("Inside if condition");
			MywaitpresenceOfElementLocated("StockGoldCheckboxAll_XPATH");
			elementtobeclickable("StockGoldCheckboxAll_XPATH");
			//click("StockGoldCheckboxAll_XPATH");
			Thread.sleep(2000);
			System.out.println("Clicking continue button");
			click("StockGoldContinueBtn_XPATH");
			
		}
		
		
	}

}
