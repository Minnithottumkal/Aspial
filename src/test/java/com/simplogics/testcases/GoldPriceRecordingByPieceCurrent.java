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

public class GoldPriceRecordingByPieceCurrent extends Testbase{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void goldByPieceCurrent(Hashtable<String, String>data) throws InterruptedException, AWTException{
		
		if (!(TestUtil.isTestRunnable("goldByPieceCurrent", excel))) {

			throw new SkipException(
					"Skipping the test " + "goldByPieceCurrent".toUpperCase() + "as the Run mode is NO");
		}
		
		MywaitinvisibilityOfElementLocated("loding_CSS");
		MywaitpresenceOfElementLocated("SellByPiece_XPATH");
		Thread.sleep(2000);
		click("SellByPiece_XPATH");
		Thread.sleep(4000);
		MywaitpresenceOfElementLocated("GoldPriceWeight_XPATH");
		click("GoldPriceWeight_XPATH");
		type("GoldPriceWeight_XPATH", data.get("GoldWeight"));
		presstab();
		type("GoldSupplierCost_XPATH", data.get("SupplierCost"));
		presstab();
		type("GoldSellingPrice_XPATH", data.get("SellingPrice"));
		presstab();
		
		click("PostOnlyBtn_XPATH");
		MywaitinvisibilityOfElementLocated("Feedback_CSS");
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath(testfield.getProperty("CurrentTab_XPATH")));
		js.executeScript("arguments[0].scrollIntoView();", Element);
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
