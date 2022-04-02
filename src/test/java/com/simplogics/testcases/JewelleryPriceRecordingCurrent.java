package com.simplogics.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class JewelleryPriceRecordingCurrent extends Testbase{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void jewelleryPriceRecordingCurrent (Hashtable<String, String>data) throws InterruptedException,AWTException {
		
		if (!(TestUtil.isTestRunnable("jewelleryPriceRecordingCurrent", excel))) {

			throw new SkipException("Skipping the test " + "jewelleryPriceRecordingCurrent".toUpperCase() + "as the Run mode is NO");
		}
		
		MywaitinvisibilityOfElementLocated("loding_CSS");
		MywaitpresenceOfElementLocated("CurrentTab_XPATH");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath(testfield.getProperty("CurrentTab_XPATH")));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(2000);
		click("CurrentTab_XPATH");
		MywaitpresenceOfElementLocated("JewelleryEffectiveDate_XPATH");
//		doubleclick("JewelleryEffectiveDate_XPATH");
//		driver.findElement(By.xpath(testfield.getProperty("JewelleryEffectiveDate_XPATH"))).clear();
//		type("JewelleryEffectiveDate_XPATH", data.get("Date"));
		doubleclick("JewelleryRemarks_XPATH");
		Tab("JewelleryRemarks_XPATH");
		presstab();
		click("JewelleryLength_XPATH");
		MywaitpresenceOfElementLocated("LengthSearch_XPATH");
		type("LengthSearch_XPATH", data.get("Length"));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		presstab();
		doubleclick("JewellerySupplierCost_XPATH");
		driver.findElement(By.xpath(testfield.getProperty("JewellerySupplierCost_XPATH"))).clear();
		Thread.sleep(1000);
		type("JewellerySupplierCost_XPATH", data.get("SupplierCost"));
		presstab();
		type("JewellerySellingPrice_XPATH", data.get("SellingPrice"));
		
		click("PostOnlyBtn_XPATH");
		MywaitinvisibilityOfElementLocated("Feedback_CSS");
		
		Thread.sleep(2000);
		MywaitpresenceOfElementLocated("CurrentTab_XPATH");
		WebElement Element1 = driver.findElement(By.xpath(testfield.getProperty("CurrentTab_XPATH")));
		js.executeScript("arguments[0].scrollIntoView();", Element1);
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
