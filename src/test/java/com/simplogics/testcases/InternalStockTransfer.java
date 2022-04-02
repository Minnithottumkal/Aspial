package com.simplogics.testcases;

import org.testng.annotations.Test;

import com.simplogics.base.Testbase;

public class InternalStockTransfer extends Testbase{
	  @Test
	  public void internalStockTransfer() throws InterruptedException {
		  
		  super.timedelay();
		  click("internalstockContinueBtn_XPATH");
		  Thread.sleep(9000);
		  
		  
	  }
}
