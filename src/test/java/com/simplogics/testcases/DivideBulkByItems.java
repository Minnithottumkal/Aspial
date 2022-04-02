package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class DivideBulkByItems extends Testbase {

	public static int i = 1;
	public static int count = 0;
	public static int rows = excel.getRowCount("divideBulkByItems") - 1;
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void divideBulkByItems(Hashtable<String, String> data) throws AWTException, InterruptedException {

		if (!(TestUtil.isTestRunnable("divideBulkByItems", excel))) {

			throw new SkipException("Skipping the test " + "divideBulkByItems".toUpperCase() + "as the Run mode is NO");
		}
		String s = "";
		count++;
		System.out.println("Value of count   = " + count );
		if(i==1)
		{
			i++;
			System.out.println("Value of i == " + i);
			MywaitpresenceOfElementLocated("Bulkinfomenuicon_XPATH");
			click("Bulkinfomenuicon_XPATH");
			timedelay();
			MywaitpresenceOfElementLocated("divideBulk_XPATH");
			click("divideBulk_XPATH");
		}
		
		Thread.sleep(5000);

		if(data.get("Checkbox").equalsIgnoreCase("ALL") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("divideBulkByItemCheckboxAll_XPATH");
			click("divideBulkByItemCheckboxAll_XPATH");
		}
		else if(data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("divideBulkByItemCheckboxAll_XPATH");
			s = data.get("Checkbox");
			int n = Integer.valueOf(s);
			MywaitpresenceOfElementLocated("divideBulkByItemPIC_XPATH");
			select("divideBulkByItemPIC_XPATH", data.get("BulkItemPIC"));
			driver.findElement(By.xpath("(//div[@wj-part='rhcells']//child::input)["+n+"]")).click();
			
		}
			
		if(count == rows)
		{
			MywaitpresenceOfElementLocated("divideBulkConfirm_XPATH");
			click("divideBulkConfirm_XPATH");
			MywaitinvisibilityOfElementLocated("loader_CSS");
			Thread.sleep(2000);
			MywaitpresenceOfElementLocated("divideToast_XPATH");
			String toast = driver.findElement(By.xpath("//div[@id='feedbackMessageContainer']/div/div")).getText();
			System.out.println(toast);
			newBulkNumber = toast.substring(45);
			extent.setSystemInfo("Divide Bulk No.", newBulkNumber);
			System.out.println(newBulkNumber);
			MywaitinvisibilityOfElementLocated("3lineloader_CSS");
		}


		

	}
	

}
