package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class StockEditBag extends Testbase {
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void stockEditBag(Hashtable<String, String>data) throws  InterruptedException, AWTException {
		
		if (!(TestUtil.isTestRunnable("StockEditBag", excel))) {

			throw new SkipException(
					"Skipping the test " + "StockEditBag".toUpperCase() + "as the Run mode is NO");
		}
		
		MywaitpresenceOfElementLocated("StockEditItemNoInput_XPATH");
		Thread.sleep(5000);
		click("StockEditItemNoInput_XPATH");
		type("StockEditItemNoInput_XPATH", data.get("ItemNumber"));
		elementtobeclickable("StockEditAddBtn_XPATH");
		
		MywaitinvisibilityOfElementLocated("loader_CSS");
		MywaitinvisibilityOfElementLocated("Feedback_CSS");
		MywaitpresenceOfElementLocated("StockBagItemNumberDiv_XPATH");
		click("StockBagItemNumberDiv_XPATH");
		
		Tab("Activestate_CSS");
		click("Activestate_CSS");
		doubleclick("Editfield_CSS");
		type("Editfield_CSS", data.get("Model"));
		Tab("Editfield_CSS");
		MywaitinvisibilityOfElementLocated("loader_CSS");
		driver.findElement(By.cssSelector(".wj-row:nth-child(2) > .wj-cell:nth-child(3)")).click();
		doubleclick("Activestate_CSS");
		type("Editfield_CSS", data.get("Version"));
		Tab("Editfield_CSS");
		MywaitinvisibilityOfElementLocated("loader_CSS");
		driver.findElement(By.cssSelector(".wj-row:nth-child(2) > .wj-cell:nth-child(4)")).click();
		doubleclick("Activestate_CSS");
		type("Editfield_CSS", data.get("Config"));
		Tab("Editfield_CSS");
		MywaitinvisibilityOfElementLocated("loader_CSS");
		driver.findElement(By.cssSelector(".wj-row:nth-child(2) > .wj-cell:nth-child(6)")).click();
		doubleclick("Activestate_CSS");
		type("Editfield2_CSS", data.get("UnitWt"));
		Tab("Editfield2_CSS");
		
		MywaitpresenceOfElementLocated("StockBagCheckboxAll_XPATH");
		elementtobeclickable("StockBagCheckboxAll_XPATH");
		Thread.sleep(2000);
		System.out.println("Clicking continue button");
		click("StockBagContinueBtn_XPATH");
	}

}
