package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class DivideBulk extends Testbase{
	  @Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	  public void dividebulk(Hashtable<String, String> data) throws InterruptedException, AWTException {
		  
		  if (!(TestUtil.isTestRunnable("dividebulk", excel))) {

				throw new SkipException(
						"Skipping the test " + "dividebulk".toUpperCase() + "as the Run mode is NO");
			}
		  
		  MywaitpresenceOfElementLocated("Bulkinfomenuicon_XPATH");
		  click("Bulkinfomenuicon_XPATH");
		  timedelay();
		  MywaitpresenceOfElementLocated("divideBulk_XPATH");
		  click("divideBulk_XPATH");
		  MywaitpresenceOfElementLocated("Dividebytotalbulklink_XPATH");
		  
		  
		  click("Dividebytotalbulklink_XPATH");
		  doubleclick("NewBulkQty_XPATH");
		  type("NewBulkQty_XPATH", data.get("NewBulkQty"));
		  presstab();
		  type("NewBulkWt_XPATH", data.get("NewBulkWt"));
		  presstab();
		  type("NewBulkCost_XPATH", data.get("NewBulkCost"));
		  Thread.sleep(2000);
		  select("DividebulkPICdrpdown_XPATH", data.get("PICDropdown"));
		  MywaitpresenceOfElementLocated("DividebyTotalBulkConfirmBtn_XPATH");
		  click("DividebyTotalBulkConfirmBtn_XPATH");
		  MywaitpresenceOfElementLocated("divideToast_XPATH");
		  
		  String toast = driver.findElement(By.xpath("//div[@id='feedbackMessageContainer']/div/div")).getText();
		  System.out.println(toast);
		  newBulkNumber = toast.substring(46);
		  System.out.println(newBulkNumber);
		  extent.setSystemInfo("Divide Bulk No", newBulkNumber);
		  
		  MywaitinvisibilityOfElementLocated("divideToast_XPATH");
		  
		  
	  }
}
