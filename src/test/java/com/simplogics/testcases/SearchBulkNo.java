package com.simplogics.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;

public class SearchBulkNo extends Testbase{
	public static String parentWindow;
	public static String BulkNumberValue;
	
	  @Test
	  public void searchBulkNo() throws InterruptedException {
		  parentWindow = driver.getWindowHandle();
		  
			//	int nbr =  Integer.parseInt(testfield.getProperty("login_rowno"));
				String docref  = excel.getCellData("createGoldInvoice", "DocReftextfield", 2 ).toString();
				System.out.println("val " + docref);
				
				
		  
		  type("bulkSearchtxtfield_ID", docref);
		  
		  super.timedelay();
		  click("bulksearchbtn_XPATH");
		  Thread.sleep(3000);
		  WebElement bulkno = driver.findElement(By.xpath("//*[@id=\"b8-b2-Placeholder1\"]/div/table/tbody/tr[1]/td[1]/span"));
			 BulkNumberValue = bulkno.getText();
			 System.out.println("BulkNumberValue  " + BulkNumberValue);
		  
		
		  
		  click("Searchbulkdata_XPATH");
		  Thread.sleep(5000);
		//  if (isElementPresent(By.xpath("//*[@id=\"b8-$b1\"]/div/div[6]/button")))
		//		  {
		//	  click("Searchbulkdata_XPATH");
		//		  }
		//  else {
		//	  click("bulksearchbtn_XPATH");
		//	  Thread.sleep(9000);
		//	  click("Searchbulkdata_XPATH");
		//  }
		  
		  
		  
		  Thread.sleep(9000);
		  
		  
		  
		  
	  }
}
