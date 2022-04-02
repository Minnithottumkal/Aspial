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
public class AddJewelleryBulkDetails  extends Testbase{
	public static int i=0;
	public void AddjewelleryBulkDetails(Hashtable<String, String> data) throws InterruptedException, AWTException {
		if (!(TestUtil.isTestRunnable("AddjewelleryBulkDetails", excel))) {

			throw new SkipException(
					"Skipping the test " + "AddjewelleryBulkDetails".toUpperCase() + "as the Run mode is NO");
		}
		
		if(i == 0) {
			MywaitpresenceOfElementLocated("editBulkHeaderBtn_XPATH");
			MywaitpresenceOfElementLocated("bulkLock_CSS");
			click("bulkLock_CSS");
			Thread.sleep(2000);
			Alert alertmsg = driver.switchTo().alert();
			alertmsg.accept();
			MywaitpresenceOfElementLocated("Feedback_CSS");
			MywaitinvisibilityOfElementLocated("Feedback_CSS");
			presenceOfElementLocated("bulkRightArrow_CSS");
		}
		
		MywaitpresenceOfElementLocated("Checkbox_2_CSS");
		i++;
		System.out.println("Value of i  === " + i);
		
		driver.findElement(
				By.cssSelector(".wj-row:nth-child(" + i + ") > .wj-header:nth-child(2)")).click();
		
		Thread.sleep(2000);
		
		Tab("Activestate_CSS");
		Tab("Activestate_CSS");
		click("Activestate_CSS");	
		doubleclick("Activestate_CSS");
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
		Tab("Activestate_CSS");
		Tab("Activestate_CSS");
		MywaitinvisibilityOfElementLocated("LoadingSpinner_CSS");
		click("Activestate_CSS");
		doubleclick("Editfield2_CSS");
		type("Editfield2_CSS", data.get("Sellprice"));
		Keysleft("Editfield2_CSS");
		Keysleft("Editfield2_CSS");
		driver.findElement(
				By.cssSelector(".wj-row:nth-child(" + i + ") > .wj-header:nth-child(2)")).click();
	}

}



