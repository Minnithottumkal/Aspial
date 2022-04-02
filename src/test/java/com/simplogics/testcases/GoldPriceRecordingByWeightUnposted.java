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

public class GoldPriceRecordingByWeightUnposted extends Testbase {
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void goldByWeightUnposted(Hashtable<String, String>data)throws InterruptedException, AWTException {
		
		if (!(TestUtil.isTestRunnable("goldByWeightUnposted", excel))) {

			throw new SkipException(
					"Skipping the test " + "goldByWeightUnposted".toUpperCase() + "as the Run mode is NO");
		}
		

		MywaitinvisibilityOfElementLocated("loding_CSS");
		MywaitpresenceOfElementLocated("ReferenceGoldWt_XPATH");
		click("ReferenceGoldWt_XPATH");
		type("ReferenceGoldWt_XPATH", data.get("ReferenceWt"));
		click("SupplierWMCPpc_XPATH");
		type("SupplierWMCPpc_XPATH", data.get("WMCP/pc"));
		click("GoldMarkup_XPATH");
		type("GoldMarkup_XPATH", data.get("MarkUp"));
		presstab();
		presstab();
		driver.findElement(By.xpath(testfield.getProperty("GoldWeightEffectiveDate_XPATH"))).clear();
		type("GoldWeightEffectiveDate_XPATH", data.get("Date"));
		presstab();
		
		click("PostOnlyBtn_XPATH");
		MywaitinvisibilityOfElementLocated("Feedback_CSS");
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath(testfield.getProperty("UnpostedTab_XPATH")));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		click("UnpostedTab_XPATH");
		Thread.sleep(2000);
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
