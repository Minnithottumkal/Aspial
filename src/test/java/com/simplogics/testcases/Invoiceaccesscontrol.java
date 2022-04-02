package com.simplogics.testcases;

import org.testng.annotations.Test;

import com.simplogics.base.Testbase;

public class Invoiceaccesscontrol extends Testbase{
	  @Test
	  public void invoiceaccesscontrol() throws InterruptedException {
		  super.timedelay();
		  click("invoiceaccessctrl_XPATH");
		  Thread.sleep(9000);
		  click("Adduserbtn_XPATH");
		  Thread.sleep(5000);
		  select("userdrpdwn_XPATH", "CITSUPPORT1");
		  super.timedelay();
		  click("adduserbtninpopup_XPATH");
		  Thread.sleep(5000);
		  
		  
	  }
	  
	  
	 
}
