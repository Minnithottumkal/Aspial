package com.simplogics.testcases;

import java.awt.AWTException;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class ActionManagement extends Testbase{
	
	@Test
	public void actionManagement() throws InterruptedException,AWTException{
		if (!(TestUtil.isTestRunnable("actionManagement", excel))) {

			throw new SkipException("Skipping the test " + "actionManagement".toUpperCase() + "as the Run mode is NO");
		}
		
		MywaitpresenceOfElementLocated("Action_XPATH");
		Thread.sleep(1000);
		elementtobeclickable("Action_XPATH");
	}

}
