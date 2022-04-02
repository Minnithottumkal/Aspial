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
public class CreateJewelleryBulkManual extends Testbase {
	public void CreatejewelleryBulkManual(Hashtable<String, String> data) throws InterruptedException, AWTException {
		if (!(TestUtil.isTestRunnable("CreatejewelleryBulkManual", excel))) {

			throw new SkipException(
					"Skipping the test " + "CreatejewelleryBulkManual".toUpperCase() + "as the Run mode is NO");
		}
		
		if (!data.get("runmode").equals("Y")) {
			ExtentManager.logger.log(Status.SKIP, "Skipped Billing Supplier is: " + data.get("BillingSupplier"));
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		
		MywaitvisibilityOfElementLocated("Newbulk_CSS");
		click("Newbulk_CSS");
		MywaitvisibilityOfElementLocated("Newbulk_CSS");
		click("Jewellerybulk_CSS");
		MywaitvisibilityOfElementLocated("Dropdownbillingsuppliercountry_CSS");
		click("Dropdownbillingsuppliercountry_CSS");
		select("Dropdownbillingsuppliercountry_CSS", data.get("billingSupCountry"));
		click("Dropdownprimarysuppliercountry_CSS");
		select("Dropdownprimarysuppliercountry_CSS", data.get("primarySupCountry"));
		click("SourceType_CSS");
		select("SourceType_CSS", data.get("sourceType"));
		click("Purpose_CSS");
		select("Purpose_CSS", data.get("Purpose"));
		
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
		
		click("DocRefNojewellery_CSS");
		type("DocRefNojewellery_CSS",data.get("DocRefNo"));
		click("PONojewellery_CSS");
		type("PONojewellery_CSS", data.get("PONo"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		click("TotalQtyjewellery_CSS");
		type("TotalQtyjewellery_CSS", data.get("TotalQty"));
		click("TotalWeightjewellery_CSS");
		type("TotalWeightjewellery_CSS", data.get("TotalWeight"));	
		js.executeScript("window.scrollBy(0,1000)");
		click("BulkCostjewellery_CSS");
		type("BulkCostjewellery_CSS", data.get("BulkCost"));	
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.cssSelector(testfield.getProperty("ExchangeRate_CSS"))).clear();
		click("ExchangeRate_CSS");
		type("ExchangeRate_CSS", data.get("ExchangeRate"));
		js.executeScript("window.scrollBy(0,1000)");
		click("submit_XPATH");		
		MywaitinvisibilityOfElementLocated("LoadingSpinner_CSS");
		MywaitinvisibilityOfElementLocated("3lineloader_CSS");
		
	}
}
