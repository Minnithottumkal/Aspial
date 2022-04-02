 package com.simplogics.testcases;

import java.awt.AWTException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

@Test()
public class GenerateItemNoBulkGold extends Testbase {
	public void GenerateitemNoBulk() throws InterruptedException, AWTException {
		if (!(TestUtil.isTestRunnable("GenerateitemNoBulk", excel))) {

			throw new SkipException(
					"Skipping the test " + "GenerateitemNoBulk".toUpperCase() + "as the Run mode is NO");
		}
		
		MywaitpresenceOfElementLocated("BulkSaveBtn_XPATH");
		click("BulkSaveBtn_XPATH");
		MywaitinvisibilityOfElementLocated("loader_CSS");
		Thread.sleep(2000);
		MywaitpresenceOfElementLocated("GenerateLock_XPATH");
		elementtobeclickable("GenerateLock_XPATH");
		Thread.sleep(2000);
		Alert alertmsg1 = driver.switchTo().alert();
		alertmsg1.accept();
		MywaitpresenceOfElementLocated("Feedback_CSS");
		MywaitinvisibilityOfElementLocated("Feedback_CSS");
		MywaitpresenceOfElementLocated("CloseBulkPopup_XPATH");
		click("CloseBulkPopup_XPATH");
		MywaitpresenceOfElementLocated("editBulkHeaderBtn_XPATH");	
		String title = driver.findElement(By.xpath("//span[@class='title color__primary highlight text-capitalize']")).getText();
		System.out.println(title);
		MywaitpresenceOfElementLocated("3dotMenu_XPATH");
		MywaitpresenceOfElementLocated("bulkRightArrow_CSS");
		click("bulkRightArrow_CSS");
		
		if(title.equals("Gold Bulk")) {
			String sheet="AddGoldbulkDetails";
			int rows = (excel.getRowCount(sheet))-1;
			for(int i=1; i<=rows; i++){
				driver.findElement(
						By.cssSelector(".wj-row:nth-child(" + i + ") > .wj-header:nth-child(2)")).click();
			}
		}
		else if(title.equals("Jewellery Bulk")) {
			String sheet="AddjewelleryBulkDetails";
			int rows = (excel.getRowCount(sheet))-1;
			for(int i=1; i<=rows; i++){
				driver.findElement(
						By.cssSelector(".wj-row:nth-child(" + i + ") > .wj-header:nth-child(2)")).click();
			}
		}
		else if(title.equals("Bag Bulk")) {
			String sheet="AddBagBulkDetails";
			int rows = (excel.getRowCount(sheet))-1;
			for(int i=1; i<=rows; i++){
				driver.findElement(
						By.cssSelector(".wj-row:nth-child(" + i + ") > .wj-header:nth-child(2)")).click();
			}
		}
		else if(title.equals("Watch Bulk")) {
			String sheet="AddWatchBulkDetails";
			int rows = (excel.getRowCount(sheet))-1;
			for(int i=1; i<=rows; i++){
				driver.findElement(
						By.cssSelector(".wj-row:nth-child(" + i + ") > .wj-header:nth-child(2)")).click();
			}
		}
		
		
		MywaitpresenceOfElementLocated("GenerateItemInvoiveBtn_XPATH");
		click("GenerateItemInvoiveBtn_XPATH");
		Thread.sleep(5000);
		Alert alertmsg2 = driver.switchTo().alert();
		alertmsg2.accept();
		MywaitinvisibilityOfElementLocated("loader_CSS");
		MywaitpresenceOfElementLocated("CloseBulkPopup_XPATH");
		Thread.sleep(2000);
		click("CloseBulkPopup_XPATH");
		
//		System.out.println("Adding Bulk Number");
//		String b = driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div/div/div/div[3]/div/div/div[2]/div/div[1]/div/div/div[1]/span")).getText();
//		System.out.println(b);
//		bulkNumber = b.substring(9);
//		System.out.println(bulkNumber);


	}
}
