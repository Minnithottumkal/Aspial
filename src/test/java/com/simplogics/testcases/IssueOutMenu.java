package com.simplogics.testcases;

import java.awt.AWTException;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class IssueOutMenu extends Testbase{
	
	@Test
	public void issueOutMenu()throws InterruptedException, AWTException {
		
		if (!(TestUtil.isTestRunnable("issueOutMenu", excel))) {

			throw new SkipException("Skipping the test " + "issueOutMenu".toUpperCase() + "as the Run mode is NO");
		}
		
		MywaitpresenceOfElementLocated("stockmenu_CSS");
		click("stockmenu_CSS");
		
		MywaitpresenceOfElementLocated("IssueOutSubMenu_XPATH");
		click("IssueOutSubMenu_XPATH");
	}

}
