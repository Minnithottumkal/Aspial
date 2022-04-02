package com.simplogics.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class StockApprovalOrRejection extends Testbase{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void stockApprovalOrRejection(Hashtable<String, String> data) throws InterruptedException, AWTException {
		
		if (!(TestUtil.isTestRunnable("stockApprovalOrRejection", excel))) {

			throw new SkipException(
					"Skipping the test " + "stockApprovalOrRejection".toUpperCase() + "as the Run mode is NO");
		}
		
		MywaitpresenceOfElementLocated("PendingApproval_XPATH");
		click("PendingApproval_XPATH");
		MywaitpresenceOfElementLocated("RequestedByDiv_XPATH");
		Thread.sleep(3000);
		click("RequestedByDiv_XPATH");
		MywaitpresenceOfElementLocated("RedquestedBySearch_XPATH");
		click("RedquestedBySearch_XPATH");
		type("RedquestedBySearch_XPATH", data.get("RequestedBy"));
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		click("StockSearchBtn_XPATH");
		Thread.sleep(3000);
		MywaitpresenceOfElementLocated("TableRow1_XPATH");
		click("TableRow1_XPATH");
		MywaitpresenceOfElementLocated("StockApproveConfirmBtn_XPATH");
		Thread.sleep(5000);
		
		if(data.get("Status").equalsIgnoreCase("Accept"))
		{
			MywaitpresenceOfElementLocated("StockAcceptBtn_XPATH");
			click("StockAcceptBtn_XPATH");
		}
		
		if(data.get("Status").equalsIgnoreCase("Reject"))
		{
			MywaitpresenceOfElementLocated("StockRejectBtn_XPATH");
			click("StockRejectBtn_XPATH");
		}
		
		
		
		//click("StockApproveConfirmBtn_XPATH");
		


	}

}
