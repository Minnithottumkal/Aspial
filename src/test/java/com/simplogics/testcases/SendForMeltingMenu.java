package com.simplogics.testcases;

import java.awt.AWTException;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class SendForMeltingMenu extends Testbase{
	
	@Test
	public void sendForMeltingMenu()throws InterruptedException,AWTException {
		
		if (!(TestUtil.isTestRunnable("sendForMeltingMenu", excel))) {

			throw new SkipException("Skipping the test " + "sendForMeltingMenu".toUpperCase() + "as the Run mode is NO");
		}
		MywaitpresenceOfElementLocated("stockmenu_CSS");
		click("stockmenu_CSS");
		
		MywaitpresenceOfElementLocated("SendForMeltingSubMenu_XPATH");
		click("SendForMeltingSubMenu_XPATH");
	}

}
