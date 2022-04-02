package com.simplogics.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class StockRejection extends Testbase{

@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
public void stockRejection(Hashtable<String, String> data) throws InterruptedException, AWTException {
		
		if (!(TestUtil.isTestRunnable("stockRejection", excel))) {

			throw new SkipException(
					"Skipping the test " + "stockRejection".toUpperCase() + "as the Run mode is NO");
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
		MywaitpresenceOfElementLocated("TableRow1_XPATH");
		click("TableRow1_XPATH");
		MywaitpresenceOfElementLocated("StockRejectBtn_XPATH");
		Thread.sleep(2000);
		MywaitpresenceOfElementLocated("StockRejectBtn_XPATH");
		click("StockRejectBtn_XPATH");
		Thread.sleep(2000);
		click("StockConfirmBtn_XPATH");
		MywaitpresenceOfElementLocated("StockRejectionRemarks_XPATH");
		type("StockRejectionRemarks_XPATH", data.get("Remarks"));
		driver.findElement(By.xpath("//*[@id=\"b7-Form1\"]/div[2]/div/button[2]")).click();
}

}
