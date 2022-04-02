package com.simplogics.testcases;

import java.awt.AWTException;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class PriceRevisionMenu extends Testbase{
	
	@Test
	public void priceRevisionMenu()throws InterruptedException,AWTException {
		
		if (!(TestUtil.isTestRunnable("priceRevisionMenu", excel))) {

			throw new SkipException("Skipping the test " + "priceRevisionMenu".toUpperCase() + "as the Run mode is NO");
		}
		
		
		MywaitvisibilityOfElementLocated("PriceRevisionSubMenu_XPATH");
		click("PriceRevisionSubMenu_XPATH");
	}

}
