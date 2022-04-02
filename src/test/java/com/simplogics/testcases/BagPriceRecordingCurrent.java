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

public class BagPriceRecordingCurrent extends Testbase{
	
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void bagPriceRecordingCurrent (Hashtable<String, String>data) throws InterruptedException,AWTException {
		
		if (!(TestUtil.isTestRunnable("BagPriceRecordingCurrent", excel))) {

			throw new SkipException("Skipping the test " + "BagPriceRecordingCurrent".toUpperCase() + "as the Run mode is NO");
		}
		
		MywaitinvisibilityOfElementLocated("loader_CSS");
		MywaitpresenceOfElementLocated("CurrentTab_XPATH");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath(testfield.getProperty("CurrentTab_XPATH")));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(2000);
		click("CurrentTab_XPATH");
		
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
		
		MywaitpresenceOfElementLocated("RecordingPostOnlyBtn_XPATH");
		click("RecordingPostOnlyBtn_XPATH");
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
