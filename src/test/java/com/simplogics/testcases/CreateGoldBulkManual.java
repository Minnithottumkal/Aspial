package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.simplogics.base.Testbase;
import com.simplogics.utilities.ExtentManager;
import com.simplogics.utilities.TestUtil;

@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
public class CreateGoldBulkManual extends Testbase {

	public void createGoldBulkManual(Hashtable<String, String> data) throws InterruptedException, AWTException {

		if (!(TestUtil.isTestRunnable("createGoldBulkManual", excel))) {

			throw new SkipException(
					"Skipping the test " + "createGoldBulkManual".toUpperCase() + "as the Run mode is NO");
		}
		
		if (!data.get("runmode").equals("Y")) {
			ExtentManager.logger.log(Status.SKIP, "Skipped Billing Supplier is: " + data.get("BillingSupplier"));
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}

		MywaitvisibilityOfElementLocated("Newbulk_CSS");
		click("Newbulk_CSS");
		MywaitvisibilityOfElementLocated("Newbulk_CSS");
		click("goldbulk_XPATH");
		MywaitvisibilityOfElementLocated("billingSupCountrygoldbulk_XPATH");
		click("SourceType_CSS");
		select("SourceType_CSS", data.get("sourceType"));
		click("Purpose_CSS");
		select("Purpose_CSS", data.get("Purpose"));

		click("billingSupCountrygoldbulk_XPATH");
		select("billingSupCountrygoldbulk_XPATH", data.get("billingSupCountry"));
		select("primarySupCountrygoldbulk_CSS", data.get("primarySupCountry"));

		// Billing supplier path suggestion box starts here

		click("billingsuppliergoldbulk_XPATH");
		MywaitpresenceOfElementLocated("billingsupplierSearchboxgoldbulk_XPATH");
		type("billingsupplierSearchboxgoldbulk_XPATH", data.get("BillingSupplier"));
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='Dropdown_BillingSupplier']//div[@role='listbox']//child::div"));
		System.out.println("Auto Suggest List ::" + list.size());
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equals(data.get("BillingSupplier"))) {
				list.get(i).click();
				break;
			}

		}

		click("Primarysuppliergoldbulk_XPATH");
		MywaitpresenceOfElementLocated("PrimarysuppliergoldbulkSarchbox_XPATH");
		type("PrimarysuppliergoldbulkSarchbox_XPATH", data.get("PrimarySupplier"));
		List<WebElement> lst = driver.findElements(By.xpath("//div[@id='Dropdown_PrimarySupplier']//div[@role='listbox']//child::div"));
		System.out.println("Auto Suggest List ::" + lst.size());
		for (int i = 0; i < lst.size(); i++) {
			if (lst.get(i).getText().equals(data.get("PrimarySupplier"))) {
				lst.get(i).click();
				break;
			}

		}

		click("DocRefNo_CSS");
		type("DocRefNo_CSS", data.get("DocRefNo"));
		click("PONo_CSS");
		type("PONo_CSS", data.get("PONo"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		click("TotalQty_CSS");
		type("TotalQty_CSS", data.get("TotalQty"));
		click("TotalWeight_CSS");
		type("TotalWeight_CSS", data.get("TotalWeight"));
		js.executeScript("window.scrollBy(0,1000)");
		click("GoldCost_ID");
		type("GoldCost_ID", data.get("GoldCost"));
		click("WMCP_ID");
		type("WMCP_ID", data.get("WMCP"));
		click("GoldLoss_ID");
		type("GoldLoss_ID", data.get("GoldLoss"));

		click("SellbyDropdown_CSS");
		select("SellbyDropdown_CSS", data.get("Sellby"));
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.cssSelector(testfield.getProperty("ExchangeRate_CSS"))).clear();
		click("ExchangeRate_CSS");
		type("ExchangeRate_CSS", data.get("ExchangeRate"));
		js.executeScript("window.scrollBy(0,1000)");
		MywaitpresenceOfElementLocated("submit_XPATH");
		click("submit_XPATH");
		MywaitinvisibilityOfElementLocated("loader_CSS");
		MywaitinvisibilityOfElementLocated("3lineloader_CSS");
//		System.out.println("Page completely Loaded");

	}

}
