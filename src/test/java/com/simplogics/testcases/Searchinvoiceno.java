package com.simplogics.testcases;

import org.testng.annotations.Test;

import com.simplogics.base.Testbase;

public class Searchinvoiceno extends Testbase {
	
	public static String parentWindow;
	
	
  @Test
  public void searchinvoiceno() throws InterruptedException {
	  
	  
	  
	 parentWindow = driver.getWindowHandle();
			  
		//	int nbr =  Integer.parseInt(testfield.getProperty("login_rowno"));
			String docref  = excel.getCellData("CreateBagInvoice", "DocReftextfield", 2 ).toString();
			System.out.println("val " + docref);
			
			
	  
	  type("Invoicesearchtxtfld_ID", docref);
	  
	  Thread.sleep(3000);
	  
	  click("Invoicesearchbtn_XPATH");
	  Thread.sleep(9000);
	 // if (isElementPresent(By.xpath("//*[@id=\"b3-Placeholder1\"]/div[1]/span/div/button")))
	//		  {
	//	  click("Searchinvoicedata_XPATH");
	//		  }
	//  else {
	//	  click("Invoicesearchbtn_XPATH");
	//	  Thread.sleep(9000);
	//	  click("Searchinvoicedata_XPATH");
	 // }
	  
	  
	  
	  Thread.sleep(9000);
	  
	  
	  

		
	//	testfield.getProperty("wait_timeinsec");
  }
}
