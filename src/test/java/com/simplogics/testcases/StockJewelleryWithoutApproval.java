package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class StockJewelleryWithoutApproval extends Testbase {
	
	public static int i = 0;
	int rows = (excel.getRowCount("stockJewelleryWithoutApproval")-1);
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void stockJewelleryWithoutApproval(Hashtable<String, String> data) throws AWTException, InterruptedException {
		
		if (!(TestUtil.isTestRunnable("stockJewelleryWithoutApproval", excel))) {

			throw new SkipException("Skipping the test " + "stockJewelleryWithoutApproval".toUpperCase() + "as the Run mode is NO");
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
		MywaitpresenceOfElementLocated("StockJewelleryCheckbox1_XPATH");
		
		doubleclick("StockJewelleryLengthDiv_XPATH");
		type("StockJewelleryLength_XPATH", data.get("Length/Size"));
		presstab();
//		doubleclick("StockJewelleryUnitWtDiv_XPATH");
//		type("StockJewelleryUnitWt_XPATH", data.get("UnitWt"));
//		Tab("StockJewelleryUnitWt_XPATH");
		
		if(i == rows) {
			
			System.out.println("Inside if condition");
			MywaitpresenceOfElementLocated("StockJewelleryCheckboxAll_XPATH");
			elementtobeclickable("StockJewelleryCheckboxAll_XPATH");
			//click("StockJewelleryCheckboxAll_XPATH");
			Thread.sleep(2000);
			System.out.println("Clicking continue button");
			click("StockJewelleryContinueBtn_XPATH");
			
		}
		
		
	}

}
