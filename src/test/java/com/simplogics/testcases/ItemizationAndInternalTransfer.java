package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class ItemizationAndInternalTransfer extends Testbase{
	
	@Test(dataProviderClass = TestUtil.class , dataProvider = "dp")
	public void itemizationAndInternalTransfer(Hashtable<String, String>data) throws InterruptedException, AWTException{
		
		if (!(TestUtil.isTestRunnable("itemizationAndInternalTransfer", excel))) {

			throw new SkipException(
					"Skipping the test " + "itemizationAndInternalTransfer".toUpperCase() + "as the Run mode is NO");
		}
		
		String title = driver.findElement(By.xpath("//*[@id=\"b2-Title\"]/span")).getText();
		System.out.println(title);
		System.out.println("Adding item number to array list");
		//Thread.sleep(3000);
		if(title.equals("Gold Bulk")) {
			String sheet="AddGoldbulkDetails";
			int rows = (excel.getRowCount(sheet))-1;
			MywaitpresenceOfElementLocated("3dotMenu_XPATH");
			presenceOfElementLocated("bulkRightArrow_CSS");
			MywaitpresenceOfElementLocated("Generateitemnobulkgold_XPATH");
			Thread.sleep(3000);
			for(int i=1; i<=rows; i++){
				String itemNumber = "";
				itemNumber = driver.findElement(By.xpath("//div[@wj-part='root']//div["+ (i+1) + "]//div[2]")).getText();
				itemNo.add(itemNumber);
				System.out.println(itemNumber);
			}
			
			MywaitpresenceOfElementLocated("CloseBulkPopup_XPATH");
			Thread.sleep(2000);
			click("CloseBulkPopup_XPATH");
			
		}
		else if(title.equals("Jewellery Bulk")) {
			String sheet="AddjewelleryBulkDetails";
			int rows = (excel.getRowCount(sheet))-1;
			MywaitpresenceOfElementLocated("3dotMenu_XPATH");
			presenceOfElementLocated("bulkRightArrow_CSS");
			MywaitpresenceOfElementLocated("Generateitemnobulkgold_XPATH");
			Thread.sleep(3000);
			for(int i=1; i<=rows; i++){
				String itemNumber = "";
				itemNumber = driver.findElement(By.xpath("//div[@wj-part='root']//div["+ (i+1) + "]//div[2]")).getText();
				itemNo.add(itemNumber);
				System.out.println(itemNumber);
			}
			
			MywaitpresenceOfElementLocated("CloseBulkPopup_XPATH");
			Thread.sleep(2000);
			click("CloseBulkPopup_XPATH");
			
		}
				
		System.out.println("*************************************************");
		for(String i: itemNo)
		{
			System.out.println(i);
		}
		
		System.out.println("Saved the Item number generated detail page and it completely loaded");
		
		
		MywaitpresenceOfElementLocated("transferMenu_CSS");
		click("transferMenu_CSS");
		timedelay();
		MywaitpresenceOfElementLocated("internalTransfer_ID");
		click("internalTransfer_ID");
		
		Thread.sleep(5000);
		MywaitpresenceOfElementLocated("addStockBtn_XPATH");
		
		for(String i: itemNo )
		{
			System.out.println("Inside loop");
			presenceOfElementLocated("internalTransferItemNoInput_ID");
			type("internalTransferItemNoInput_ID", i);
			System.out.println("Entered "  + i);
			click("addStockBtn_XPATH");
			MywaitinvisibilityOfElementLocated("loader_CSS");
			Thread.sleep(2000);
		}
		
		
		
		
		
		MywaitpresenceOfElementLocated("continueSubmitBtn_XPATH");
		click("continueSubmitBtn_XPATH");
		MywaitpresenceOfElementLocated("transferPIC_XPATH");
		select("transferPIC_XPATH", data.get("PIC"));
		MywaitpresenceOfElementLocated("remarksInput_XPATH");
		type("remarksInput_XPATH", data.get("remarks"));
		click("confirmTransferBtn_XPATH");
		
		MywaitpresenceOfElementLocated("printBtn_XPATH");
		MywaitpresenceOfElementLocated("TransferNumber_XPATH");
		String InternalTransferNo = driver.findElement(By.xpath(testfield.getProperty("TransferNumber_XPATH"))).getText();
		extent.setSystemInfo("Internal Transfer No", InternalTransferNo);
		// code to click print
//		click("printBtn_XPATH");
		
		//MywaitpresenceOfElementLocated("printCloseBtn_XPATH");
	}

}
