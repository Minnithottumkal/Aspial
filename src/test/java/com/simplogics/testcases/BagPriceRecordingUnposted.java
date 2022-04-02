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

public class BagPriceRecordingUnposted extends Testbase{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void bagPriceRecordingUnposted (Hashtable<String, String>data) throws InterruptedException,AWTException {
		
		if (!(TestUtil.isTestRunnable("BagPriceRecordingUnposted", excel))) {

			throw new SkipException("Skipping the test " + "BagPriceRecordingUnposted".toUpperCase() + "as the Run mode is NO");
		}
		
		MywaitinvisibilityOfElementLocated("loader_CSS");
		MywaitpresenceOfElementLocated("UnpostedTab_XPATH");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath(testfield.getProperty("UnpostedTab_XPATH")));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(2000);
		click("UnpostedTab_XPATH");
		
		MywaitpresenceOfElementLocated("BagSizeDropdownRecording_XPATH");
		click("BagSizeDropdownRecording_XPATH");
		MywaitpresenceOfElementLocated("BagSizeDropdownSearchRecording_XPATH");
		click("BagSizeDropdownSearchRecording_XPATH");
		type("BagSizeDropdownSearchRecording_XPATH", data.get("Size"));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		
		MywaitpresenceOfElementLocated("BagMaterialDropdownRecording_XPATH");
		click("BagMaterialDropdownRecording_XPATH");
		MywaitpresenceOfElementLocated("BagMaterialDropdownSearchRecording_XPATH");
		click("BagMaterialDropdownSearchRecording_XPATH");
		type("BagMaterialDropdownSearchRecording_XPATH", data.get("Material"));
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		
		MywaitpresenceOfElementLocated("BagSupplierCostRecording_XPATH");
		click("BagSupplierCostRecording_XPATH");
		type("BagSupplierCostRecording_XPATH", data.get("SupplierCost"));
		
		click("BagSellingPriceRecording_XPATH");
		type("BagSellingPriceRecording_XPATH", data.get("SellingPrice"));
		
		MywaitpresenceOfElementLocated("BagEffectiveDateRecording_XPATH");
		doubleclick("BagEffectiveDateRecording_XPATH");
		driver.findElement(By.xpath(testfield.getProperty("BagEffectiveDateRecording_XPATH"))).clear();
		type("BagEffectiveDateRecording_XPATH", data.get("Date"));
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
		Assert.assertEquals(actual, expected);
		
	}

}
