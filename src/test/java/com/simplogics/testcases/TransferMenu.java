package com.simplogics.testcases;



import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class TransferMenu extends Testbase {

@Test()
	public void transferMenu() throws InterruptedException {
		if (!(TestUtil.isTestRunnable("transferMenu", excel))) {

			throw new SkipException("Skipping the test " + "transferMenu".toUpperCase() + "as the Run mode is NO");
		}

		// System.out.println("BulkNumberValue in transfer menu " +
		// SearchBulkNo.BulkNumberValue);
		// super.timedelay();
		MywaitpresenceOfElementLocated("transferMenu_ID");
		click("transferMenu_ID");
		
		// MywaitpresenceOfElementLocated("Retailtransferitem_XPATH");
		// click("Retailtransferitem_XPATH");

	}
}
