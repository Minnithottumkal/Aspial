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

public class WatchPriceRecordingUnposted extends Testbase{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void watchPriceRecordingUnposted (Hashtable<String, String>data) throws InterruptedException,AWTException {
		
		if (!(TestUtil.isTestRunnable("WatchPriceRecordingUnposted", excel))) {

			throw new SkipException("Skipping the test " + "WatchPriceRecordingUnposted".toUpperCase() + "as the Run mode is NO");
		}
		
		MywaitinvisibilityOfElementLocated("loader_CSS");
		MywaitpresenceOfElementLocated("UnpostedTab_XPATH");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath(testfield.getProperty("UnpostedTab_XPATH")));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(2000);
		click("UnpostedTab_XPATH");
		
		MywaitpresenceOfElementLocated("WatchSupplierCostRecording_XPATH");
		click("WatchSupplierCostRecording_XPATH");
		type("WatchSupplierCostRecording_XPATH", data.get("SupplierCost"));
		
		click("WatchSellingPriceRecording_XPATH");
		type("WatchSellingPriceRecording_XPATH", data.get("SellingPrice"));
		
		MywaitpresenceOfElementLocated("WatchEffectiveDateRecording_XPATH");
		doubleclick("WatchEffectiveDateRecording_XPATH");
		driver.findElement(By.xpath(testfield.getProperty("WatchEffectiveDateRecording_XPATH"))).clear();
		type("WatchEffectiveDateRecording_XPATH", data.get("Date"));
		presstab();
		
		MywaitpresenceOfElementLocated("RecordingPostOnlyBtn_XPATH");
		click("RecordingPostOnlyBtn_XPATH");
		MywaitinvisibilityOfElementLocated("Feedback_CSS");
		
		Thread.sleep(2000);
		MywaitpresenceOfElementLocated("UnpostedTab_XPATH");
		WebElement Element1 = driver.findElement(By.xpath(testfield.getProperty("UnpostedTab_XPATH")));
		js.executeScript("arguments[0].scrollIntoView();", Element1);
		click("UnpostedTab_XPATH");
		MywaitpresenceOfElementLocated("RecordingIDUnposted_XPATH");
		click("RecordingIDUnposted_XPATH");
		MywaitpresenceOfElementLocated("UnpostedRow_XPATH");
		click("UnpostedRow_XPATH");
		MywaitpresenceOfElementLocated("Feedback_CSS");
		String actual = driver.findElement(By.cssSelector(testfield.getProperty("Feedback_CSS"))).getText();
		String expected = "Price Recording Copied.";
		System.out.println("Actual msg = " + actual);
		Assert.assertEquals(actual, expected);
	}

}
