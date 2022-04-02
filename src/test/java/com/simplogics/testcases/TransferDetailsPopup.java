package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class TransferDetailsPopup extends Testbase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void RetailtransferDetailsPopup(Hashtable<String, String> data) throws InterruptedException, AWTException {
		// super.timedelay();
		if (!(TestUtil.isTestRunnable("RetailtransferDetailsPopup", excel))) {

			throw new SkipException(
					"Skipping the test " + "RetailtransferDetailsPopup".toUpperCase() + "as the Run mode is NO");
		}
		
		if (!data.get("runmode").equals("Y")) {
			 throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		
		MywaitpresenceOfElementLocated("Retailtransfersubmenu_ID");
		click("Retailtransfersubmenu_ID");
		MywaitpresenceOfElementLocated("itemnotxtfield_XPATH");
		click("itemnotxtfield_XPATH");
		// type("bulknotxtfield_ID",SearchBulkNo.BulkNumberValue);
		type("itemnotxtfield_XPATH", data.get("Itemno"));
		//*[@id="b3-Input_ItemNo"]
		Thread.sleep(3000);
		presenceOfElementLocated("BulkAddbtn_XPATH");
		MywaitinvisibilityOfElementLocated("loader_CSS");
		MywaitpresenceOfElementLocated("RetailtransferContinueBtn_XPATH");
		click("RetailtransferContinueBtn_XPATH");
		MywaitvisibilityOfElementLocated("TransfertoPICdrpdwn_CSS");
		select("TransfertoPICdrpdwn_CSS", data.get("PIC"));
		select("transferoutlet_CSS", data.get("Outlet"));
		click("TfrDlsRemarkstxtfld_ID");
		type("TfrDlsRemarkstxtfld_ID", data.get("Remarks"));
		click("TfrDlsConfirmbtn_CSS");

//		click("TfrDlsClosebtn_XPATH");
		MywaitpresenceOfElementLocated("TransferNumber_XPATH");
		String RetailTransferNo = driver.findElement(By.xpath(testfield.getProperty("TransferNumber_XPATH"))).getText();
		extent.setSystemInfo("Retail Transfer No", RetailTransferNo);
		MywaitpresenceOfElementLocated("printBtn_XPATH");
//		click("printBtn_XPATH");
	}

}
