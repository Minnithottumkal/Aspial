package com.simplogics.testcases;

import java.awt.AWTException;
//import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class SendForMelting extends Testbase{
	
	@Test
	public void sendForMelting() throws InterruptedException, AWTException {
		
		if (!(TestUtil.isTestRunnable("sendForMelting", excel))) {

			throw new SkipException("Skipping the test " + "sendForMelting".toUpperCase() + "as the Run mode is NO");
		}
		
//		if (!data.get("runmode").equals("Y")) {
//
//			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
//		}
//		
//		if(!data.get("Item No").equals(""))
//		{
//			MywaitpresenceOfElementLocated("ItemNumber_XPATH");
//			click("ItemNumber_XPATH");
//			type("ItemNumber_XPATH", data.get("Item No"));
//			MywaitpresenceOfElementLocated("AddBtn_XPATH");
//			click("AddBtn_XPATH");
//			MywaitinvisibilityOfElementLocated("loader_CSS");
//			MywaitinvisibilityOfElementLocated("Feedback_CSS");
//			
//		}
//		
//		if(!data.get("Bulk No").equals(""))
//		{
//			MywaitpresenceOfElementLocated("BulkNumber_XPATH");
//			click("BulkNumber_XPATH");
//			type("BulkNumber_XPATH", data.get("Bulk No"));
//			MywaitpresenceOfElementLocated("AddBtn_XPATH");
//			click("AddBtn_XPATH");
//			MywaitinvisibilityOfElementLocated("loader_CSS");
//			MywaitinvisibilityOfElementLocated("Feedback");
//			
//		}
		
		MywaitpresenceOfElementLocated("BulkNumber_XPATH");
		click("BulkNumber_XPATH");
		type("BulkNumber_XPATH", bulkNumber);
		MywaitpresenceOfElementLocated("AddBtn_XPATH");
		click("AddBtn_XPATH");
		MywaitinvisibilityOfElementLocated("loader_CSS");
		MywaitinvisibilityOfElementLocated("Feedback");
		
	}

}
