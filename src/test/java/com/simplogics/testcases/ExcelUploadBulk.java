package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.simplogics.base.Testbase;
import com.simplogics.utilities.ExtentManager;
import com.simplogics.utilities.TestUtil;

@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
public class ExcelUploadBulk extends Testbase {
	public void ExceluploadBulkAndItemization(Hashtable<String, String> data) throws InterruptedException, AWTException {
		if (!(TestUtil.isTestRunnable("ExceluploadBulkAndItemization", excel))) {

			throw new SkipException("Skipping the test " + "ExceluploadBulkAndItemization".toUpperCase() + "as the Run mode is NO");
		}
		if (!data.get("runmode").equals("Y")) {
			ExtentManager.logger.log(Status.SKIP, "Skipped Excel file is: " + data.get("EXCELNAME"));
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		MywaitinvisibilityOfElementLocated("loding_CSS");
		
		MywaitpresenceOfElementLocated("editBulkHeaderBtn_XPATH");
		String title = driver.findElement(By.xpath("//span[@class='title color__primary highlight text-capitalize']")).getText();
//		MywaitpresenceOfElementLocated("bulkLock_CSS");
//		click("bulkLock_CSS");
//		Thread.sleep(2000);
//		Alert alertmsg = driver.switchTo().alert();
//		alertmsg.accept();
//		MywaitpresenceOfElementLocated("Feedback_CSS");
//		MywaitinvisibilityOfElementLocated("Feedback_CSS");
		MywaitpresenceOfElementLocated("3dotMenu_XPATH");
		MywaitpresenceOfElementLocated("bulkRightArrow_CSS");
		click("bulkRightArrow_CSS");
		MywaitpresenceOfElementLocated("Checkbox_2_CSS");
		
		driver.findElement(By.cssSelector(".wj-row:nth-child(1) > .wj-header:nth-child(2)")).click();
		Tab("Activestate_CSS");
		Tab("Activestate_CSS");
		click("Activestate_CSS");
		doubleclick("Editfield_CSS");
		type("Editfield_CSS", data.get("Model"));
		Tab("Editfield_CSS");
		MywaitinvisibilityOfElementLocated("LoadingSpinner_CSS");
		click("Activestate_CSS");
		doubleclick("Editfield_CSS");
		type("Editfield_CSS", data.get("Version"));
		Tab("Editfield_CSS");
		MywaitinvisibilityOfElementLocated("LoadingSpinner_CSS");
		click("Activestate_CSS");
		doubleclick("Editfield_CSS");
		type("Editfield_CSS", data.get("Config"));
		Tab("Editfield_CSS");
		MywaitinvisibilityOfElementLocated("LoadingSpinner_CSS");
		Tab("Activestate_CSS");
//		if(title.equals("Bag Bulk") || title.equals("Watch Bulk")) {
//			Tab("Activestate_CSS");
//			Tab("Activestate_CSS");
//			Tab("Activestate_CSS");
//			click("Activestate_CSS");
//			doubleclick("Editfield2_CSS");
//			type("Editfield2_CSS", "80");
//			Tab("Editfield2_CSS");
//		}
		
		rightclick("Activestate_CSS");
		click("Copyrow_CSS");
		Thread.sleep(1000);
		//MywaitinvisibilityOfElementLocated("loader_CSS");
		MywaitpresenceOfElementLocated("MVC_XPATH");
		click("MVC_XPATH");
//		if(title.equals("Bag Bulk") || title.equals("Watch Bulk")) {
//			MywaitpresenceOfElementLocated("SellPriceCheckbox_XPATH");
//			click("SellPriceCheckbox_XPATH");
//		}
		click("Confirm_XPATH");
		MywaitpresenceOfElementLocated("Feedback_CSS");
		MywaitinvisibilityOfElementLocated("Feedback_CSS");
		MywaitpresenceOfElementLocated("BulkSaveBtn_XPATH");
		click("BulkSaveBtn_XPATH");
		MywaitinvisibilityOfElementLocated("loader_CSS");
//		MywaitpresenceOfElementLocated("GenerateLock_XPATH");
//		elementtobeclickable("GenerateLock_XPATH");
//		Thread.sleep(2000);
//		Alert alertmsg1 = driver.switchTo().alert();
//		alertmsg1.accept();
//		MywaitpresenceOfElementLocated("Feedback_CSS");
//		MywaitinvisibilityOfElementLocated("Feedback_CSS");
		MywaitpresenceOfElementLocated("CloseBulkPopup_XPATH");
		Thread.sleep(2000);
		click("CloseBulkPopup_XPATH");
		MywaitpresenceOfElementLocated("GenerateItemNoHome_XPATH");
		
		MywaitpresenceOfElementLocated("uploadicon_CSS");
		Thread.sleep(500);
		click("uploadicon_CSS");
		driver.findElement(By.xpath("//label[contains(@id,'ExcelDetailUpload')]//child::input"))
			.sendKeys(System.getProperty("user.dir") + EXCEL_UPLOAD + data.get("EXCELNAME"));
		if(title.equals("Gold Bulk")) {
			MywaitpresenceOfElementLocated("RecalculateFields_XPATH");
			click("RecalculateFields_XPATH");
		}
		
		Thread.sleep(1000);
		MywaitpresenceOfElementLocated("Uploadexcelbulkgold_XPATH");
		click("Uploadexcelbulkgold_XPATH");
		Thread.sleep(2000);
		Alert alertmsg2 = driver.switchTo().alert();
		alertmsg2.accept();
		MywaitinvisibilityOfElementLocated("loader_CSS");
		Thread.sleep(1000);
		
		MywaitpresenceOfElementLocated("GenerateItemNoHome_XPATH");
		presenceOfElementLocated("bulkRightArrow_CSS");
		MywaitinvisibilityOfElementLocated("loader_CSS");
		MywaitpresenceOfElementLocated("BulkCheckBoxAll_XPATH");
		Thread.sleep(5000);
		click("BulkCheckBoxAll_XPATH");
		MywaitpresenceOfElementLocated("GenerateItemInvoiveBtn_XPATH");
		click("GenerateItemInvoiveBtn_XPATH");
		Thread.sleep(5000);
		Alert alertmsg3 = driver.switchTo().alert();
		alertmsg3.accept();
		if(title.equals("Jewellery Bulk")) {
			Thread.sleep(5000);
			Alert alertmsg4 = driver.switchTo().alert();
			alertmsg4.accept();
		}
		MywaitinvisibilityOfElementLocated("loader_CSS");
		Thread.sleep(3000);
	}
}
