package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class GoldPriceRecording extends Testbase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void goldPriceRecording(Hashtable<String, String> data) throws InterruptedException, AWTException {

		if (!(TestUtil.isTestRunnable("goldPriceRecording", excel))) {

			throw new SkipException(
					"Skipping the test " + "goldPriceRecording".toUpperCase() + "as the Run mode is NO");
		}

		MywaitpresenceOfElementLocated("GoldLinkRecording_XPATH");
		click("GoldLinkRecording_XPATH");
		Thread.sleep(2000);
		MywaitpresenceOfElementLocated("PriceModel_XPATH");
		click("PriceModel_XPATH");
		driver.findElement(By.xpath(testfield.getProperty("PriceModel_XPATH"))).clear();
		type("PriceModel_XPATH", data.get("Model"));
		presstab();
		driver.findElement(By.xpath(testfield.getProperty("PriceVersion_XPATH"))).clear();
		type("PriceVersion_XPATH", data.get("Version"));
		presstab();
		driver.findElement(By.xpath(testfield.getProperty("PriceConfig_XPATH"))).clear();
		type("PriceConfig_XPATH", data.get("Config"));
		presenceOfElementLocated("PriceSearchBtn_XPATH");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		MywaitinvisibilityOfElementLocated("3lineloader_CSS");
		MywaitpresenceOfElementLocated("TableRow1_XPATH");
		click("TableRow1_XPATH");
	}

}
