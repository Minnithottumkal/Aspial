package com.simplogics.testcases;

import org.testng.annotations.Test;

import com.simplogics.base.Testbase;

public class TransferStockBulkAcceptance extends Testbase{
	  @Test
	  public void transferStockBulkAcceptance() throws InterruptedException {
		  super.timedelay();
		  Thread.sleep(3000);
		  click("BulktransferAcceptbtn_ID");
		  
		  
	  }
  
}
