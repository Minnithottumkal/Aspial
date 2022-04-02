package com.simplogics.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.SkipException;
import com.simplogics.utilities.TestUtil;
import com.simplogics.base.Testbase;

public class BulkinPopup extends Testbase {
	@Test
	public void bulkinPopup() throws InterruptedException {
		if (!(TestUtil.isTestRunnable("bulkinPopup", excel))) {

			throw new SkipException("Skipping the test " + "bulkinPopup".toUpperCase() + "as the Run mode is NO");
		}

		MywaitpresenceOfElementLocated("Bulkbtn_XPATH");
		click("Bulkbtn_XPATH");
		MywaitinvisibilityOfElementLocated("loader_CSS");
		MywaitpresenceOfElementLocated("BulkNo_XPATH");
		String span = driver.findElement(By.xpath(testfield.getProperty("BulkNo_XPATH"))).getText();
		String bulkNo = span.substring(9);
		bulkNumber = bulkNo;
		System.out.println(bulkNo);
		extent.setSystemInfo("Bulk No", bulkNo);

	}

}
