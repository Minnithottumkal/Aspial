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

public class GoldPriceRecordingByPieceUnposted extends Testbase{

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void goldByPieceUnposted(Hashtable<String, String>data)throws InterruptedException,AWTException{
		
		if (!(TestUtil.isTestRunnable("goldByPieceUnposted", excel))) {

			throw new SkipException(
					"Skipping the test " + "goldByPieceUnposted".toUpperCase() + "as the Run mode is NO");
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
		driver.findElement(By.xpath(testfield.getProperty("GoldPriceEffectiveDate_XPATH"))).clear();
		type("GoldPriceEffectiveDate_XPATH", data.get("Date"));
		presstab();
		
		click("PostOnlyBtn_XPATH");
		MywaitinvisibilityOfElementLocated("Feedback_CSS");
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath(testfield.getProperty("UnpostedTab_XPATH")));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		click("UnpostedTab_XPATH");
		MywaitpresenceOfElementLocated("RecordingIDUnposted_XPATH");
		click("RecordingIDUnposted_XPATH");
		click("UnpostedTab_XPATH");
		Thread.sleep(2000);
		MywaitpresenceOfElementLocated("UnpostedRow_XPATH");
		click("UnpostedRow_XPATH");
		MywaitpresenceOfElementLocated("Feedback_CSS");
		String actual = driver.findElement(By.cssSelector(testfield.getProperty("Feedback_CSS"))).getText();
		String expected = "Price Recording Copied.";
		Assert.assertEquals(actual, expected);
		
	}
}
