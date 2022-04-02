package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.simplogics.base.Testbase;
import com.simplogics.utilities.ExtentManager;
import com.simplogics.utilities.TestUtil;

public class JewelleryPriceRecordingHistory extends Testbase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void jewelleryPriceRecordingHistory(Hashtable<String, String> data)
			throws InterruptedException, AWTException {

		if (!(TestUtil.isTestRunnable("jewelleryPriceRecordingHistory", excel))) {
			ExtentManager.logger.log(Status.SKIP, "Skipped Type is: " + data.get("Type"));
			throw new SkipException(
					"Skipping the test " + "jewelleryPriceRecordingHistory".toUpperCase() + "as the Run mode is NO");
		}

		
		if(data.get("Type").equalsIgnoreCase("Current") && data.get("runmode").equals("Y"))
		{
			MywaitinvisibilityOfElementLocated("loding_CSS");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement Element = driver.findElement(By.xpath(testfield.getProperty("CurrentTab_XPATH")));
			js.executeScript("arguments[0].scrollIntoView();", Element);
			MywaitpresenceOfElementLocated("CurrentTab_XPATH");
			Thread.sleep(4000);
			click("CurrentTab_XPATH");
			Thread.sleep(1000);
			MywaitpresenceOfElementLocated("RecordingIDCurrent_XPATH");
			click("RecordingIDCurrent_XPATH");
			MywaitpresenceOfElementLocated("CurrentRow_XPATH");
			MywaitpresenceOfElementLocated("CurrentDelete_XPATH");
			click("CurrentDelete_XPATH");
			Thread.sleep(2000);
			Alert alertmsg = driver.switchTo().alert();
			alertmsg.accept();
			MywaitpresenceOfElementLocated("3lineloader_CSS");
			MywaitinvisibilityOfElementLocated("3lineloader_CSS");
			MywaitpresenceOfElementLocated("HistoryTab_XPATH");
			Thread.sleep(1000);
			click("HistoryTab_XPATH");
			Thread.sleep(2000);
			MywaitpresenceOfElementLocated("RecordingIDHistory_XPATH");
			click("RecordingIDHistory_XPATH");
			MywaitpresenceOfElementLocated("HistoryRow_XPATH");
			click("HistoryRow_XPATH");
			MywaitpresenceOfElementLocated("Feedback_CSS");
			String actual = driver.findElement(By.cssSelector(testfield.getProperty("Feedback_CSS"))).getText();
			String expected = "Price Recording Copied.";
			Assert.assertEquals(actual, expected);
		}
		else if(data.get("Type").equalsIgnoreCase("Unposted") && data.get("runmode").equals("Y"))
		{
			MywaitinvisibilityOfElementLocated("loader_CSS");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement Element = driver.findElement(By.xpath(testfield.getProperty("UnpostedTab_XPATH")));
			js.executeScript("arguments[0].scrollIntoView();", Element);
			MywaitpresenceOfElementLocated("UnpostedTab_XPATH");
			Thread.sleep(4000);
			click("UnpostedTab_XPATH");
			Thread.sleep(1000);
			MywaitpresenceOfElementLocated("RecordingIDUnposted_XPATH");
			click("RecordingIDUnposted_XPATH");
			MywaitpresenceOfElementLocated("UnpostedRow_XPATH");
			MywaitpresenceOfElementLocated("UnpostedDelete_XPATH");
			click("UnpostedDelete_XPATH");
			Thread.sleep(2000);
			Alert alertmsg = driver.switchTo().alert();
			alertmsg.accept();
			MywaitpresenceOfElementLocated("3lineloader_CSS");
			MywaitinvisibilityOfElementLocated("3lineloader_CSS");
			MywaitpresenceOfElementLocated("HistoryTab_XPATH");
//			Thread.sleep(1000);
//			click("HistoryTab_XPATH");
//			Thread.sleep(2000);
//			MywaitpresenceOfElementLocated("RecordingIDHistory_XPATH");
//			click("RecordingIDHistory_XPATH");
//			MywaitpresenceOfElementLocated("HistoryRow_XPATH");
//			click("HistoryRow_XPATH");
//			MywaitpresenceOfElementLocated("Feedback_CSS");
//			String actual = driver.findElement(By.cssSelector(testfield.getProperty("Feedback_CSS"))).getText();
//			String expected = "Price Recording Copied.";
//			Assert.assertEquals(actual, expected);
			
		}
		
	}

}
