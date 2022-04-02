package com.simplogics.testcases;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;

public class AddBulkDetailsNew extends Testbase{
	  @Test
	  public void addBulkDetailsPopup() throws AWTException, InterruptedException {
		  
		  //First store parent window to switch back
		 // String parentWindow = driver.getWindowHandle();

		  //Perform the click operation that opens new window
		 // driver.findElement(By.id("FieldView_ctl17_MultiSelect1_InputText")).click();

		  //Switch to new window opened
		  
		  Thread.sleep(9000);
		   
		//  for(String winHandle : driver.getWindowHandles()){
		//      if(!winHandle.equals(Searchinvoiceno.parentWindow)) {
		//          driver.switchTo().window(winHandle);
		 //     }
		//  }

		  //Now find checkbox and click 
		  //driver.findElements(By.id("checkbox0")).click();
		  click("Addbulkpopupcheckbox1_XPATH");
		  super.timedelay();
		  
		  
		  click("Addbulkpopupconfirmbtn_XPATH");
		  Thread.sleep(9000);
		  
		  
		  click("Addbulkdetailsbtn_XPATH");
		  Thread.sleep(7000);
		  
		  click("Addbulkpopupcheckbox2_XPATH");
		  super.timedelay();
		  click("AddbulkRow2_XPATH");
		  presstab();
		  presstab();
		  presstab();
		  presstab();
		  presstab();
		  presstab();
		  presstab();
		  presstab();
		  type("AddbulkpopupNewBulkQty_XPATH", "50");
		//  presstab();
		 // type("AddbulkpopupNewBulkwt_XPATH", "10");
		//  presstab();
		 // type("AddbulkpopupNewBulkcost_XPATH", "100");
		  
		  super.timedelay();
		  click("Addbulkpopupconfirmbtn_XPATH");
		//  Thread.sleep(9000);
		  
		  Thread.sleep(9000);
		  
		//  if (isElementPresent(By.xpath("//*[@id=\"b6-b18-Button\"]/button")))
		//  {
		//	  click("Addbulkpopupconfirmbtn_XPATH");
		//  }
		//  else {
		//	  Thread.sleep(9000);
		//	  click("Addbulkpopupconfirmbtn_XPATH");
		//  }
		  
		String actualmsg = driver.findElement(By.xpath("//*[@id=\"feedbackMessageContainer\"]/div")).getText();
		  System.out.println("errormsg  :  " + actualmsg);
		  String expectedmsg = "Bulk details successfully modified";
		 // Assert.assertTrue(isElementPresent(By.xpath("//*[@id=\"feedbackMessageContainer\"]/div")),"Bulk details successfully modified");
		  assertEquals(actualmsg, expectedmsg);
			//log.debug("Login successfully executed");
		  

		  //Now close opened popup window 
		 // driver.close();

		  //Switch back to parent window 
		 // driver.switchTo().window(Searchinvoiceno.parentWindow);

		  //Continue with parent window 
		 // Thread.sleep(9000);
	  }
}
