package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
public class AddGoldBulkDeatails extends Testbase {
	public static int i = 0;

	public void AddGoldbulkDetails(Hashtable<String, String> data) throws InterruptedException, AWTException {
		if (!(TestUtil.isTestRunnable("AddGoldbulkDetails", excel))) {

			throw new SkipException(
					"Skipping the test " + "AddGoldbulkDetails".toUpperCase() + "as the Run mode is NO");
		}
		
		if (i == 0) {
			MywaitpresenceOfElementLocated("editBulkHeaderBtn_XPATH");
			MywaitpresenceOfElementLocated("bulkLock_CSS");
			click("bulkLock_CSS");
			Thread.sleep(2000);
			Alert alertmsg = driver.switchTo().alert();
			alertmsg.accept();
			MywaitpresenceOfElementLocated("Feedback_CSS");
			MywaitinvisibilityOfElementLocated("Feedback_CSS");
			MywaitpresenceOfElementLocated("3dotMenu_XPATH");
			MywaitpresenceOfElementLocated("bulkRightArrow_CSS");
			click("bulkRightArrow_CSS");
		}
		MywaitpresenceOfElementLocated("Checkbox_2_CSS");
		i++;
		// Thread.sleep(2000);
		driver.findElement(By.cssSelector(".wj-row:nth-child(" + i + ") > .wj-header:nth-child(2)")).click();
		Tab("Activestate_CSS");
		Tab("Activestate_CSS");
		click("Activestate_CSS");
		doubleclick("Editfield_CSS");
		type("Editfield_CSS", data.get("Model"));
		Tab("Editfield_CSS");
		MywaitinvisibilityOfElementLocated("LoadingSpinner_CSS");
		click("Activestate_CSS");
		doubleclick("Editfield_CSS");
		type("Editfield_CSS", data.get("Version"));
		Tab("Editfield_CSS");
		MywaitinvisibilityOfElementLocated("LoadingSpinner_CSS");
		click("Activestate_CSS");
		doubleclick("Editfield_CSS");
		type("Editfield_CSS", data.get("Config"));
		Tab("Editfield_CSS");
		Tab("Activestate_CSS");
		Tab("Activestate_CSS");
		MywaitinvisibilityOfElementLocated("LoadingSpinner_CSS");
		click("Activestate_CSS");
		doubleclick("Editfield2_CSS");
		type("Editfield2_CSS", data.get("Unitprice"));
		Tab("Editfield2_CSS");
		Tab("Activestate_CSS");
		Tab("Activestate_CSS");
		click("Activestate_CSS");
		doubleclick("Editfield2_CSS");
		type("Editfield2_CSS", data.get("WMSP"));
		Keysleft("Editfield2_CSS");
		Keysleft("Editfield2_CSS");
		driver.findElement(By.cssSelector(".wj-row:nth-child(" + i + ") > .wj-header:nth-child(2)")).click();

	}

}
