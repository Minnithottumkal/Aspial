package com.simplogics.testcases;

import java.awt.AWTException;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;
@Test()
public class SaveInvoiceDetails extends Testbase {
	public void SaveinvoiceDetails() throws InterruptedException, AWTException {
		if (!(TestUtil.isTestRunnable("SaveinvoiceDetails", excel))) {

			throw new SkipException(
					"Skipping the test " + "SaveinvoiceDetails".toUpperCase() + "as the Run mode is NO");
		}
		//Thread.sleep(2000);
		click("invoicedetailsavebtn_XPATH");
		
}
}
