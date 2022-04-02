package com.simplogics.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class MergeBulkApprovalOrRejection extends Testbase {
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void mergeBulkApprovalOrRejection(Hashtable<String, String>data) throws InterruptedException, AWTException {
		
		if (!(TestUtil.isTestRunnable("mergeBulkApprovalOrRejection", excel))) {

			throw new SkipException("Skipping the test " + "mergeBulkApprovalOrRejection".toUpperCase() + "as the Run mode is NO");
		}
		
		if (!data.get("runmode").equals("Y")) {

			 throw new SkipException("Skipping the test case as the Run mode for data set is NO");
			 }
		
		MywaitpresenceOfElementLocated("RequestedByAcceptanceDiv_XPATH");
		Thread.sleep(4000);
		click("RequestedByAcceptanceDiv_XPATH");
		MywaitpresenceOfElementLocated("RequestedBySearchAcceptance_XPATH");
		click("RequestedBySearchAcceptance_XPATH");
		type("RequestedBySearchAcceptance_XPATH", data.get("RequestedBy"));
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		click("StockSearchAcceptanceBtn_XPATH");
		MywaitpresenceOfElementLocated("TableRow1Acceptance_XPATH");
		click("TableRow1Acceptance_XPATH");
		Thread.sleep(3000);
		
		if(data.get("Status").equalsIgnoreCase("Accept"))
		{
			MywaitpresenceOfElementLocated("StockAcceptBtnAcceptance_XPATH");
			click("StockAcceptBtnAcceptance_XPATH");
			click("ConfirmButton_XPATH");
			MywaitinvisibilityOfElementLocated("loader_CSS");
		}
		
		if(data.get("Status").equalsIgnoreCase("Reject"))
		{
			MywaitpresenceOfElementLocated("StockRejectBtnAcceptance_XPATH");
			click("StockRejectBtnAcceptance_XPATH");
			Thread.sleep(1000);
			MywaitpresenceOfElementLocated("StockConfirmBtnAcceptance_XPATH");
			click("StockConfirmBtnAcceptance_XPATH");
			MywaitpresenceOfElementLocated("StockRejectionRemarksAcceptance_XPATH");
			type("StockRejectionRemarksAcceptance_XPATH", data.get("Remarks"));
			presenceOfElementLocated("RejectionYesBtn_XPATH");
			MywaitinvisibilityOfElementLocated("loader_CSS");
		}
		
		
	}

}
