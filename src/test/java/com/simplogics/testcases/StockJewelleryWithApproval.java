package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class StockJewelleryWithApproval extends Testbase {

	private static int i = 0;
	int rows = (excel.getRowCount("stockJewelleryWithApproval") - 1);

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void stockJewelleryWithApproval(Hashtable<String, String> data) throws InterruptedException, AWTException {

		if (!(TestUtil.isTestRunnable("stockJewelleryWithApproval", excel))) {

			throw new SkipException(
					"Skipping the test " + "stockJewelleryWithApproval".toUpperCase() + "as the Run mode is NO");
		}

		i++;
		MywaitpresenceOfElementLocated("StockEditItemNoInput_XPATH");
		Thread.sleep(5000);
		click("StockEditItemNoInput_XPATH");
		type("StockEditItemNoInput_XPATH", data.get("ItemNumber"));
		elementtobeclickable("StockEditAddBtn_XPATH");

		System.out.println("Value of i == " + i);
		MywaitinvisibilityOfElementLocated("StockEditLoader_XPATH");
		MywaitinvisibilityOfElementLocated("StockEditToast_XPATH");
		MywaitpresenceOfElementLocated("StockJewelleryCheckbox1_XPATH");
		click("StockJewelleryItemNumberDiv_XPATH");

		Tab("Activestate_CSS");
		doubleclick("Activestate_CSS");
		//driver.findElement(By.xpath(testfield.getProperty("StockJewelleryModel_XPATH"))).clear();
		type("StockJewelleryModel_XPATH", data.get("Model"));

		Tab("StockJewelleryModel_XPATH");
		MywaitinvisibilityOfElementLocated("StockEditLoader_XPATH");
		doubleclick("StockJewelleryVersionDiv_XPATH");
		//driver.findElement(By.xpath(testfield.getProperty("StockJewelleryVersion_XPATH"))).clear();
		type("StockJewelleryVersion_XPATH", data.get("Version"));

		Tab("StockJewelleryVersion_XPATH");
		MywaitinvisibilityOfElementLocated("StockEditLoader_XPATH");
		doubleclick("StockJewelleryConfigDiv_XPATH");
		//driver.findElement(By.xpath(testfield.getProperty("StockJewelleryConfig_XPATH"))).clear();
		type("StockJewelleryConfig_XPATH", data.get("Config"));

		presstab();
		MywaitinvisibilityOfElementLocated("StockEditLoader_XPATH");

		doubleclick("StockJewelleryLengthDiv_XPATH");
		type("StockJewelleryLength_XPATH", data.get("Length/Size"));
		presstab();
		doubleclick("StockJewelleryUnitWtDiv_XPATH");
		type("StockJewelleryUnitWt_XPATH", data.get("UnitWt"));
		Tab("StockJewelleryUnitWt_XPATH");

		if (i == rows) {

			System.out.println("Inside if condition");
			MywaitpresenceOfElementLocated("StockJewelleryCheckboxAll_XPATH");
			elementtobeclickable("StockJewelleryCheckboxAll_XPATH");
			Thread.sleep(2000);
			System.out.println("Clicking continue button");
			click("StockJewelleryContinueBtn_XPATH");

		}

	}

}
