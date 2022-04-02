package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class AddInvoiceWatchDetails extends Testbase {
	
	public int i = 1;
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void addInvoiceWatchDetails(Hashtable<String, String>data) throws InterruptedException, AWTException {
		
		if (!(TestUtil.isTestRunnable("AddInvoiceWatchDetails", excel))) {

			throw new SkipException(
					"Skipping the test " + "AddInvoiceWatchDetails".toUpperCase() + "as the Run mode is NO");
		}
		
		if(i==1)
		{
			Model = data.get("Model");
			Version = data.get("Version");
			Config = data.get("Config");
			i=2;
		}
		
		MywaitpresenceOfElementLocated("CreatebagAddrowbtn_XPATH");
		click("CreatebagAddrowbtn_XPATH");
		Thread.sleep(5000);
		//dynamic column 1 selection
		driver.findElement(By.xpath("//div[@role='grid']//div["+ i + "]//div[1]")).click();
		doubleclick("Activestate_CSS");
		doubleclick("Editfield_CSS");
		type("Editfield_CSS", data.get("SupplierPatternCode"));
		Tab("Editfield_CSS");
		click("Activestate_CSS");
		type("Editfield_CSS", data.get("Model"));
		Tab("Editfield_CSS");
		click("Activestate_CSS");
		type("Editfield_CSS", data.get("Version"));
		Tab("Editfield_CSS");
		click("Activestate_CSS");
		type("Editfield_CSS", data.get("Config"));
		Tab("Editfield_CSS");
		MywaitinvisibilityOfElementLocated("loader_CSS");
		click("Activestate_CSS");
		Tab("Activestate_CSS");
		click("Activestate_CSS");
		type("Editfield2_CSS", data.get("Quantity"));
		Tab("Editfield2_CSS");
		click("Activestate_CSS");
		type("Editfield2_CSS", data.get("InvoiceWeight"));
		Tab("Editfield2_CSS");
		click("Activestate_CSS");
		click("Editfield_CSS");
		type("Editfield_CSS", data.get("PurchasedBy"));
		Tab("Editfield_CSS");
		MywaitinvisibilityOfElementLocated("loader_CSS");
		click("Activestate_CSS");
		type("Editfield2_CSS", data.get("InvoiceCost"));
		Tab("Editfield2_CSS");
		Tab("Activestate_CSS");
		Tab("Activestate_CSS");
		Tab("Activestate_CSS");
		Tab("Activestate_CSS");	
		click("Activestate_CSS");
		type("Editfield2_CSS", data.get("SellingPriceMarkup"));
		i++;
		
	}

}
