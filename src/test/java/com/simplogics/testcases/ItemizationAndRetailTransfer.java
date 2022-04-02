package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class ItemizationAndRetailTransfer extends Testbase{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void itemizationAndRetailTransfer(Hashtable<String, String>data) throws InterruptedException, AWTException {
		
		if (!(TestUtil.isTestRunnable("itemizationAndRetailTransfer", excel))) {

			throw new SkipException(
					"Skipping the test " + "itemizationAndRetailTransfer".toUpperCase() + "as the Run mode is NO");
		}
		
		String title = driver.findElement(By.xpath("//*[@id=\"b2-Title\"]/span")).getText();
		System.out.println("Adding item number to array list");
		//Thread.sleep(3000);
		if(title.equals("Gold Bulk")) {
			String sheet="AddGoldbulkDetails";
			int rows = (excel.getRowCount(sheet))-1;
			presenceOfElementLocated("bulkRightArrow_CSS");
			MywaitpresenceOfElementLocated("Generateitemnobulkgold_XPATH");
			Thread.sleep(3000);
			for(int i=1; i<=rows; i++){
				String itemNumber = "";
				itemNumber = driver.findElement(By.xpath("//div[@id='l1_0-0-b5-b1-b1-datagrid_autogenerate']/div[2]/div/div/div/div[" +(i+1) +"]/div[2]")).getText();
				itemNo.add(itemNumber);
				System.out.println(itemNumber);
			}
			
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div[1]/div[1]/div/a/i")).click();
			
		}
		else if(title.equals("Jewellery Bulk")) {
			String sheet="AddjewelleryBulkDetails";
			int rows = (excel.getRowCount(sheet))-1;
			presenceOfElementLocated("bulkRightArrow_CSS");
			MywaitpresenceOfElementLocated("Generateitemnobulkgold_XPATH");
			Thread.sleep(3000);
			for(int i=1; i<=rows; i++){
				String itemNumber = "";
				itemNumber = driver.findElement(By.xpath("//div[@id='l1_0-0-b5-b1-b1-datagrid_autogenerate']/div[2]/div/div/div/div[" +(i+1) +"]/div[2]")).getText();
				itemNo.add(itemNumber);
				System.out.println(itemNumber);
			}
			
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div[1]/div[1]/div/a/i")).click();
			
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
		MywaitpresenceOfElementLocated("Retailtransfersubmenu_ID");
		click("Retailtransfersubmenu_ID");
		
		MywaitpresenceOfElementLocated("BulkAddbtn_XPATH");
		for(String i: itemNo )
		{
			System.out.println("Inside loop");
			presenceOfElementLocated("itemnotxtfield_XPATH");
			type("itemnotxtfield_XPATH", i);
			System.out.println("Entered "  + i);
			click("BulkAddbtn_XPATH");
			MywaitinvisibilityOfElementLocated("loader_CSS");
			Thread.sleep(2000);
		}
		
		MywaitpresenceOfElementLocated("RetailtransferContinueBtn_XPATH");
		click("RetailtransferContinueBtn_XPATH");
		MywaitvisibilityOfElementLocated("TransfertoPICdrpdwn_CSS");
		select("TransfertoPICdrpdwn_CSS", data.get("PIC"));
		select("transferoutlet_CSS", data.get("Outlet"));
		click("TfrDlsRemarkstxtfld_ID");
		type("TfrDlsRemarkstxtfld_ID", "Transfering to GH");
		click("TfrDlsConfirmbtn_CSS");
		
	}

}
