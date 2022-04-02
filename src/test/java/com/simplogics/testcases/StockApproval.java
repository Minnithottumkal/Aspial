package com.simplogics.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class StockApproval extends Testbase {
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void stockApproval(Hashtable<String, String> data) throws InterruptedException, AWTException {
		

		if (!(TestUtil.isTestRunnable("stockApproval", excel))) {

			throw new SkipException(
					"Skipping the test " + "stockApproval".toUpperCase() + "as the Run mode is NO");
		}
		
		MywaitpresenceOfElementLocated("PendingApproval_XPATH");
		click("PendingApproval_XPATH");
		MywaitpresenceOfElementLocated("RequestedByDiv_XPATH");
		Thread.sleep(3000);
		click("RequestedByDiv_XPATH");
		MywaitpresenceOfElementLocated("RedquestedBySearch_XPATH");
		click("RequestedBySearch_XPATH");
		type("RequestedBySearch_XPATH", data.get("RequestedBy"));
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		click("StockSearchBtn_XPATH");
		Thread.sleep(3000);
		MywaitpresenceOfElementLocated("TableRow1_XPATH");
		click("TableRow1_XPATH");
		MywaitpresenceOfElementLocated("StockConfirmBtn_XPATH");
		Thread.sleep(5000);
		click("StockConfirmBtn_XPATH");
		
	}

}
