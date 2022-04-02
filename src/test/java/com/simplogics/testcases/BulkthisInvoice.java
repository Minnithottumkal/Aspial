package com.simplogics.testcases;

import org.testng.annotations.Test;
import org.testng.SkipException;
import com.simplogics.utilities.TestUtil;
import com.simplogics.base.Testbase;

public class BulkthisInvoice extends Testbase{
  @Test
  public void bulkthisInvoice() throws InterruptedException {
	  //super.timedelay();
	  if (!(TestUtil.isTestRunnable("bulkthisInvoice", excel))) {

			throw new SkipException("Skipping the test " + "bulkthisInvoice".toUpperCase() + "as the Run mode is NO");
		}
	  MywaitinvisibilityOfElementLocated("loding_CSS");
	  Thread.sleep(5000);
	  MywaitpresenceOfElementLocated("bulkthisinvoiceicon_XPATH");
	  click("bulkthisinvoiceicon_XPATH");
	  System.out.println("clicked view bulk icon");
	 // click("editinvoiceheaderbtn_CSS");
	 // super.timedelay();
	  //Thread.sleep(9000);
	  
  }
}
