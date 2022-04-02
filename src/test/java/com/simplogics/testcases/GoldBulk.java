package com.simplogics.testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class GoldBulk extends Testbase{
	  @Test
	  public void goldBulk() throws InterruptedException {
		  if (!(TestUtil.isTestRunnable("goldBulk", excel))) {

				throw new SkipException("Skipping the test " + "goldBulk".toUpperCase() + "as the Run mode is NO");
			}
//		  super.timedelay();
		  
		 // Thread.sleep(7000);
		  MywaitpresenceOfElementLocated("Addbulkdetailsbtn_XPATH");
		  click("Addbulkdetailsbtn_XPATH");
	  }
}
