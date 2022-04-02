package com.simplogics.testcases;

import java.awt.AWTException;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class PriceBookManagement extends Testbase{

	@Test
	public void priceBookManagement()throws InterruptedException,AWTException {
		
		if (!(TestUtil.isTestRunnable("priceBookManagement", excel))) {

			throw new SkipException("Skipping the test " + "priceBookManagement".toUpperCase() + "as the Run mode is NO");
		}
		MywaitpresenceOfElementLocated("PriceBookMenu_CSS");
		click("PriceBookMenu_CSS");
	}
}
