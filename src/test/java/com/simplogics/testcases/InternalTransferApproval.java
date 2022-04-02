package com.simplogics.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class InternalTransferApproval extends Testbase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void internalTransferApproval(Hashtable<String, String> data) throws InterruptedException, AWTException, IOException {

		if (!(TestUtil.isTestRunnable("InternalTransferApproval", excel))) {

			throw new SkipException(
					"Skipping the test " + "InternalTransferApproval".toUpperCase() + "as the Run mode is NO");
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
		MywaitpresenceOfElementLocated("StockAcceptBtnAcceptance_XPATH");
		click("StockAcceptBtnAcceptance_XPATH");
		click("ConfirmButton_XPATH");
		MywaitinvisibilityOfElementLocated("loader_CSS");
		MywaitpresenceOfElementLocated("Feedback_CSS");
		String msg = driver.findElement(By.cssSelector(testfield.getProperty("Feedback_CSS"))).getText();
		System.out.println(msg);
		AssertEquals("Transfer accepted successfully.", msg);
	}

}
