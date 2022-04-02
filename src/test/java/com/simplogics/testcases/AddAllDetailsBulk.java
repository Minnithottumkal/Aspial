package com.simplogics.testcases;



import java.awt.AWTException;

//import org.openqa.selenium.By;
//import org.testng.Assert;
//import org.openqa.selenium.By;
import org.testng.SkipException;
import com.simplogics.utilities.TestUtil;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;



public class AddAllDetailsBulk extends Testbase {
	@Test
	  public void addAllDetailsBulk() throws AWTException, InterruptedException {
		if (!(TestUtil.isTestRunnable("addAllDetailsBulk", excel))) {

			throw new SkipException("Skipping the test " + "addAllDetailsBulk".toUpperCase() + "as the Run mode is NO");
		}
		
		//Thread.sleep(6000);
		MywaitpresenceOfElementLocated("Addallbulkdetailcheckbox_XPATH");
		 // Thread.sleep(9000);
		 // if (isElementPresent(By.xpath("Addallbulkdetailcheckbox_XPATH")))
		 // {
			  click("Addallbulkdetailcheckbox_XPATH");
		 // }
		 // else {
			  //Thread.sleep(9000);
			//  click("Addallbulkdetailcheckbox_XPATH");
		//  }  
				  
		  Thread.sleep(2000);
		  click("Addbulkpopupconfirmbtn_XPATH");
		 // Thread.sleep(9000);
		 
		MywaitpresenceOfElementLocated("Feedback_CSS");
//		String actualmsg = driver.findElement(By.xpath(testfield.getProperty("Feedback_CSS"))).getText();
//		System.out.println(actualmsg);
//		String expectedmsg = "Bulk details successfully modified";
//		Assert.assertEquals(actualmsg, expectedmsg);
		MywaitinvisibilityOfElementLocated("Feedback_CSS");
	  }
	}
