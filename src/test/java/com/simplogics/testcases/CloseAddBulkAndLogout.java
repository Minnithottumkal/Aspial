package com.simplogics.testcases;

import org.testng.annotations.Test;

import com.simplogics.base.Testbase;

public class CloseAddBulkAndLogout extends Testbase {
	  @Test
	  public void closeAddBulkAndLogout() throws InterruptedException {
		  click("CloseAddBulkPP_XPATH");
		  super.timedelay();
		  click("logout_ID");
		  Thread.sleep(5000);
		  
	  }
}
