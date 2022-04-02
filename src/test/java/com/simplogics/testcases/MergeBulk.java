package com.simplogics.testcases;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class MergeBulk extends Testbase{
	
	@Test
	public void mergeBulk() throws AWTException, InterruptedException {
		
		if (!(TestUtil.isTestRunnable("mergeBulk", excel))) {

			throw new SkipException("Skipping the test " + "mergeBulk".toUpperCase() + "as the Run mode is NO");
		}

		MywaitpresenceOfElementLocated("Bulkinfomenuicon_XPATH");
		Thread.sleep(8000);
		click("Bulkinfomenuicon_XPATH");
		timedelay();
		click("MergeBulk_XPATH");
		timedelay();
		
		MywaitinvisibilityOfElementLocated("3lineloader_CSS");
		timedelay();
		MywaitpresenceOfElementLocated("MergeBulkCheckbox1_XPATH");
		click("MergeBulkCheckbox1_XPATH");
		
		timedelay();
		click("MergeBulkConfirm_XPATH");
		
//		MywaitinvisibilityOfElementLocated("loader_CSS");
		MywaitpresenceOfElementLocated("3lineloader_CSS");
		MywaitinvisibilityOfElementLocated("3lineloader_CSS");
		Thread.sleep(4000);
		MywaitpresenceOfElementLocated("Bulkinfomenuicon_XPATH");
		MywaitpresenceOfElementLocated("BulkNo_XPATH");
		String span = driver.findElement(By.xpath(testfield.getProperty("BulkNo_XPATH"))).getText();
		String mergeNo = span.substring(9);
		System.out.println(mergeNo);
		extent.setSystemInfo("MergeBulk No", mergeNo);
		
	}

}
