package com.simplogics.testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class InternalTransferDetails extends Testbase {
	public static int i = 0;

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void internalTransfer(Hashtable<String, String> data) throws InterruptedException {
		if (!(TestUtil.isTestRunnable("internalTransfer", excel))) {

			throw new SkipException("Skipping the test " + "internalTransfer".toUpperCase() + "as the Run mode is NO");
		}


		if (!data.get("runmode").equals("Y")) {
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");

		}

		if (!data.get("ItemNo").equals("")) {

			presenceOfElementLocated("internalTransferItemNoInput_ID");

			click("internalTransferItemNoInput_ID");
			type("internalTransferItemNoInput_ID", data.get("ItemNo"));
		}

		if (!data.get("BulkNo").equals("")) {

			presenceOfElementLocated("internalTransferBulkNoInput_ID");

			click("internalTransferBulkNoInput_ID");
			type("internalTransferBulkNoInput_ID", data.get("BulkNo"));
		}

		timedelay();
		click("addStockBtn_XPATH");
		MywaitinvisibilityOfElementLocated("loader_CSS");

		MywaitpresenceOfElementLocated("continueSubmitBtn_XPATH");
		click("continueSubmitBtn_XPATH");

		MywaitpresenceOfElementLocated("transferPIC_XPATH");
		select("transferPIC_XPATH", data.get("PIC"));

		MywaitpresenceOfElementLocated("remarksInput_XPATH");
		type("remarksInput_XPATH", data.get("remarks"));
		click("confirmTransferBtn_XPATH");

		MywaitpresenceOfElementLocated("TransferNumber_XPATH");
		String InternalTransferNo = driver.findElement(By.xpath(testfield.getProperty("TransferNumber_XPATH"))).getText();
		extent.setSystemInfo("Internal Transfer No", InternalTransferNo);
		MywaitpresenceOfElementLocated("printBtn_XPATH");
		click("printBtn_XPATH");

		// MywaitpresenceOfElementLocated("printCloseBtn_XPATH");
		// code to close pop-up
		// Thread.sleep(3000);
		// click("printCloseBtn_XPATH");

	}

}
