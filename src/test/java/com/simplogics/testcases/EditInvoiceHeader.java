package com.simplogics.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;

public class EditInvoiceHeader extends Testbase{
  @Test
  public void editInvoiceHeader() throws InterruptedException {
	  
	  //super.timedelay();
	  try {
		  
		  
		 // JavascriptExecutor js = (JavascriptExecutor) driver;
		  WebElement editicon = driver.findElement(By.xpath(" //div[@id='b3-HeaderActions']/div/a[2]/i"));
		//  js.executeScript("arguments[0].scrollIntoView();", editicon);
		  Actions actions = new Actions(driver);

		  actions.moveToElement(editicon).click().perform();
	  System.out.println("editicon");
	 // click("editinvoiceheaderbtn_CSS");
	  super.timedelay();
	  type("Remarkstextarea_XPATH", "Lorem ipsum");
	  type("exchangerate_ID", "2");
	  click("CreateInvoiceSavebtn_XPATH");
	  Thread.sleep(7000);
	  
	 // click("editinvoiceheaderbtn_XPATH");
	  } catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
}
