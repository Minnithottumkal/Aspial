package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.testng.SkipException;

import com.simplogics.utilities.ExtentManager;
import com.simplogics.utilities.TestUtil;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.simplogics.base.Testbase;

public class uploadinAddRow extends Testbase {
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void uploadbtnAddRow(Hashtable<String, String> data) throws InterruptedException, AWTException {
		if (!(TestUtil.isTestRunnable("uploadbtnAddRow", excel))) {

			throw new SkipException("Skipping the test " + "uploadbtnAddRow".toUpperCase() + "as the Run mode is NO");
		}
		if (!data.get("runmode").equals("Y")) {
			ExtentManager.logger.log(Status.SKIP, "Skipped Excel file is: " + data.get("EXCELNAME"));
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		MywaitinvisibilityOfElementLocated("3lineloader_CSS");

		MywaitpresenceOfElementLocated("uploadicon_CSS");

		// click("uploadarrowinBaginvoice_XPATH");
		Thread.sleep(2000);
		click("uploadicon_CSS");
		//Thread.sleep(2000);
		// super.timedelay();
		MywaitpresenceOfElementLocated("Excelinput_XPATH");
		//driver.findElement(By.xpath("//*[@id=\"b42-ExcelDetailUpload\"]/input"))
				//.sendKeys(System.getProperty("user.dir") + EXCEL_UPLOAD);
		driver.findElement(By.xpath("//*[contains(@id,\"ExcelDetailUpload\")]/input"))
		.sendKeys(System.getProperty("user.dir") + EXCEL_UPLOAD + data.get("EXCELNAME"));
		Thread.sleep(1000);
		// driver.getWindowHandle();
		// type("uploadselectfile_ID", System.getProperty("user.dir") +
		// "\\src\\test\\resources\\excel\\Invoice_Detail_Template.xlsx");
		Thread.sleep(1000);
		MywaitpresenceOfElementLocated("uploadexcelbtn_XPATH");
		click("uploadexcelbtn_XPATH");
		MywaitinvisibilityOfElementLocated("loader_CSS");
		

	}
}
