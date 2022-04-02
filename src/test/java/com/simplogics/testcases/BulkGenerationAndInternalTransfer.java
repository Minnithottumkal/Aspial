package com.simplogics.testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class BulkGenerationAndInternalTransfer extends Testbase{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void bulkAndInternalTransfer(Hashtable<String, String> data) throws InterruptedException {
		
		if (!(TestUtil.isTestRunnable("bulkAndInternalTransfer", excel))) {

			throw new SkipException(
					"Skipping the test " + "bulkAndInternalTransfer".toUpperCase() + "as the Run mode is NO");
		}
		
		MywaitpresenceOfElementLocated("AddDetailsBulkBtn_XPATH");
		
		
		click("transferMenu_CSS");
		timedelay();
		MywaitpresenceOfElementLocated("internalTransfer_ID");
		click("internalTransfer_ID");
		
		MywaitpresenceOfElementLocated("addStockBtn_XPATH");
		
		presenceOfElementLocated("internalTransferBulkNoInput_ID");
		Thread.sleep(4000);
		click("internalTransferBulkNoInput_ID");
		type("internalTransferBulkNoInput_ID", bulkNumber);
		
		click("addStockBtn_XPATH");
		MywaitinvisibilityOfElementLocated("loader_CSS");
		
		MywaitpresenceOfElementLocated("continueSubmitBtn_XPATH");
		click("continueSubmitBtn_XPATH");
		
		MywaitpresenceOfElementLocated("transferPIC_XPATH");
		select("transferPIC_XPATH", data.get("PIC"));
		
		MywaitpresenceOfElementLocated("remarksInput_XPATH");
		type("remarksInput_XPATH", data.get("Remarks"));
		click("confirmTransferBtn_XPATH");
		
		//MywaitpresenceOfElementLocated("printCloseBtn_XPATH");
		MywaitpresenceOfElementLocated("printBtn_XPATH");
		
		/*Code for getting Transfer Number*/
		
		MywaitpresenceOfElementLocated("TransferNumber_XPATH");
		String InternalTransferNo = driver.findElement(By.xpath(testfield.getProperty("TransferNumber_XPATH"))).getText();
		extent.setSystemInfo("Internal Transfer No", InternalTransferNo);
		
		//code to close pop-up
		//Thread.sleep(3000);
		//click("printCloseBtn_XPATH");
		
		//code to click print
//		click("printBtn_XPATH");
		
		
		
	}

}
