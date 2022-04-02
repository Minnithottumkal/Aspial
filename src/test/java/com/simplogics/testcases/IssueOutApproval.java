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

public class IssueOutApproval extends Testbase {
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void issueOutApproval(Hashtable<String, String>data) throws InterruptedException,AWTException, IOException {
		
		if (!(TestUtil.isTestRunnable("issueOutApproval", excel))) {

			throw new SkipException(
					"Skipping the test " + "issueOutApproval".toUpperCase() + "as the Run mode is NO");
		}
		
		MywaitpresenceOfElementLocated("PendingApproval_XPATH");
		click("PendingApproval_XPATH");
		Thread.sleep(3000);
		MywaitpresenceOfElementLocated("RequestedByDiv_XPATH");
	    elementtobeclickable("RequestedByDiv_XPATH");
		MywaitpresenceOfElementLocated("RequestedBySearch_XPATH");
		click("RequestedBySearch_XPATH");
		type("RequestedBySearch_XPATH", data.get("RequestedBy"));
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		MywaitpresenceOfElementLocated("StockSearchBtn_XPATH");
		click("StockSearchBtn_XPATH");
		Thread.sleep(3000);
		MywaitpresenceOfElementLocated("ApprovalTableRow1_XPATH");
		click("ApprovalTableRow1_XPATH");
		
		MywaitpresenceOfElementLocated("ApproveBtn_XPATH");
		click("ApproveBtn_XPATH");
		System.out.println("Clicking Approve Button");
		
		MywaitpresenceOfElementLocated("Feedback_CSS");
		String msg = driver.findElement(By.cssSelector(testfield.getProperty("Feedback_CSS"))).getText();
		AssertEquals("Issue out approved.", msg);
	}

}
