package com.simplogics.testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class StockEditTransferMenu extends Testbase{
	
	@Test
	public void stockEditTransferMenu() {
		
		if (!(TestUtil.isTestRunnable("stockEditTransferMenu", excel))) {

			throw new SkipException("Skipping the test " + "stockEditTransferMenu".toUpperCase() + "as the Run mode is NO");
		}
		
		MywaitinvisibilityOfElementLocated("3lineloader_CSS");
		MywaitinvisibilityOfElementLocated("loding_CSS");
		MywaitpresenceOfElementLocated("stockmenu_CSS");
		click("stockmenu_CSS");
		MywaitvisibilityOfElementLocated("StockEdit_ID");
		click("StockEdit_ID");
		
	}

}
