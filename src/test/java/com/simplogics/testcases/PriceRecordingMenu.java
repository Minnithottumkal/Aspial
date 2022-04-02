package com.simplogics.testcases;

import java.awt.AWTException;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class PriceRecordingMenu extends Testbase {
	
	@Test
	public void priceRecordingMenu()throws InterruptedException,AWTException {
		
		if (!(TestUtil.isTestRunnable("priceRecordingMenu", excel))) {

			throw new SkipException("Skipping the test " + "priceRecordingMenu".toUpperCase() + "as the Run mode is NO");
		}
		
		
		MywaitvisibilityOfElementLocated("PriceRecordingSubMenu_XPATH");
		click("PriceRecordingSubMenu_XPATH");
	}

}
