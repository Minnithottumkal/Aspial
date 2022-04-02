package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.simplogics.base.Testbase;
import com.simplogics.utilities.ExtentManager;
import com.simplogics.utilities.TestUtil;

public class PriceRevisionExcelUpload extends Testbase{

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void priceRevisionExcelUpload(Hashtable<String, String>data)throws InterruptedException,AWTException{
		
		if (!(TestUtil.isTestRunnable("priceRevisionExcelUpload", excel))) {

			throw new SkipException("Skipping the test " + "priceRevisionExcelUpload".toUpperCase() + "as the Run mode is NO");
		}
		
		if (!data.get("runmode").equals("Y")) {
			ExtentManager.logger.log(Status.SKIP, "Skipped Excel file is: " + data.get("EXCELNAME"));
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		
		MywaitpresenceOfElementLocated("PriceModel_XPATH");
		MywaitpresenceOfElementLocated("ReviseUploadExcel_XPATH");
		click("ReviseUploadExcel_XPATH");
		Thread.sleep(2000);
		driver.findElement(By.xpath(testfield.getProperty("SelectExcelFile_XPATH"))).sendKeys(
				System.getProperty("user.dir") + EXCEL_UPLOAD + data.get("EXCELNAME"));
		MywaitpresenceOfElementLocated("UploadExcelFileBtn_XPATH");
		click("UploadExcelFileBtn_XPATH");
		
		MywaitpresenceOfElementLocated("ReviseEffectiveDate_XPATH");
		click("ReviseEffectiveDate_XPATH");
		type("ReviseEffectiveDate_XPATH", data.get("Effective Date"));
		MywaitpresenceOfElementLocated("RevisePriceConfirm_XPATH");
		click("RevisePriceConfirm_XPATH");
	}
}
