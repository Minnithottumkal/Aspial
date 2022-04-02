package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class WatchPriceRecordingCurrent extends Testbase{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void watchPriceRecordingCurrent (Hashtable<String, String>data) throws InterruptedException,AWTException {
		
		if (!(TestUtil.isTestRunnable("WatchPriceRecordingCurrent", excel))) {

			throw new SkipException("Skipping the test " + "WatchPriceRecordingCurrent".toUpperCase() + "as the Run mode is NO");
		}
		
		MywaitinvisibilityOfElementLocated("loader_CSS");
		MywaitpresenceOfElementLocated("CurrentTab_XPATH");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath(testfield.getProperty("CurrentTab_XPATH")));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(2000);
		click("CurrentTab_XPATH");
		
		MywaitpresenceOfElementLocated("WatchSupplierCostRecording_XPATH");
		click("WatchSupplierCostRecording_XPATH");
		type("WatchSupplierCostRecording_XPATH", data.get("SupplierCost"));
		
		click("WatchSellingPriceRecording_XPATH");
		type("WatchSellingPriceRecording_XPATH", data.get("SellingPrice"));
		
		MywaitpresenceOfElementLocated("RecordingPostOnlyBtn_XPATH");
		click("RecordingPostOnlyBtn_XPATH");
		MywaitinvisibilityOfElementLocated("Feedback_CSS");
		
		Thread.sleep(2000);
		MywaitpresenceOfElementLocated("CurrentTab_XPATH");
		WebElement Element1 = driver.findElement(By.xpath(testfield.getProperty("CurrentTab_XPATH")));
		js.executeScript("arguments[0].scrollIntoView();", Element1);
		click("CurrentTab_XPATH");
		MywaitpresenceOfElementLocated("RecordingIDCurrent_XPATH");
		click("RecordingIDCurrent_XPATH");
		MywaitpresenceOfElementLocated("CurrentRow_XPATH");
		click("CurrentRow_XPATH");
		MywaitpresenceOfElementLocated("Feedback_CSS");
		String actual = driver.findElement(By.cssSelector(testfield.getProperty("Feedback_CSS"))).getText();
		String expected = "Price Recording Copied.";
		Assert.assertEquals(actual, expected);
		
	}


}
