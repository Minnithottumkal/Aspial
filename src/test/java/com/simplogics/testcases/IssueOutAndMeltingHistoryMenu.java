package com.simplogics.testcases;

import java.awt.AWTException;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class IssueOutAndMeltingHistoryMenu extends Testbase { 
	@Test()
	public void issueOutandMeltingHistoryMenu() throws InterruptedException, AWTException {

	if (!(TestUtil.isTestRunnable("IssueOutandMeltingHistoryMenu", excel))) {

		throw new SkipException(
				"Skipping the test " + "IssueOutandMeltingHistoryMenu".toUpperCase() + "as the Run mode is NO");
	}
	MywaitpresenceOfElementLocated("stockmenu_CSS");
	click("stockmenu_CSS");
	MywaitpresenceOfElementLocated("IssueOutMeltingHistory_XPATH");
	click("IssueOutMeltingHistory_XPATH");
	MywaitpresenceOfElementLocated("RecipientType_XPATH");
	// Thread.sleep(10000);
}
}

