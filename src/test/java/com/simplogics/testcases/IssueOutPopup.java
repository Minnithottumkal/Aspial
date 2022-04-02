package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class IssueOutPopup extends Testbase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void issueOutPopup(Hashtable<String, String> data) throws InterruptedException, AWTException {

		if (!(TestUtil.isTestRunnable("issueOutPopup", excel))) {

			throw new SkipException("Skipping the test " + "issueOutPopup".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}

		MywaitpresenceOfElementLocated("ContinueBtn_XPATH");
		click("ContinueBtn_XPATH");
		Thread.sleep(4000);
		MywaitpresenceOfElementLocated("RecipientType_XPATH");
		click("RecipientType_XPATH");
		select("RecipientType_XPATH", data.get("Recipient Type"));

		Thread.sleep(8000);
		MywaitpresenceOfElementLocated("Country_XPATH");
		elementtobeclickable("Country_XPATH");
		select("Country_XPATH", data.get("Country"));

		Thread.sleep(8000);
		MywaitpresenceOfElementLocated("Recipient_XPATH");
		elementtobeclickable("Recipient_XPATH");
		select("Recipient_XPATH", data.get("Recipient"));

		elementtobeclickable("Purpose_XPATH");
		select("Purpose_XPATH", data.get("Purpose"));

		presenceOfElementLocated("Remarks_XPATH");
		type("Remarks_XPATH", data.get("Remarks"));

		elementtobeclickable("Approver_XPATH");
		select("Approver_XPATH", data.get("Approver"));

		presenceOfElementLocated("ConfirmBtn_XPATH");

		MywaitpresenceOfElementLocated("PrintBtn_XPATH");
//		click("PrintBtn_XPATH");
		MywaitpresenceOfElementLocated("ApprovalID_XPATH");
		String ApprovalID = driver.findElement(By.xpath(testfield.getProperty("ApprovalID_XPATH"))).getText();
		extent.setSystemInfo("Issue Out Approval ID", ApprovalID);

		MywaitpresenceOfElementLocated("printCloseBtn_XPATH");
		click("printCloseBtn_XPATH");
		
		MywaitpresenceOfElementLocated("logout_XPATH");

	}

}
