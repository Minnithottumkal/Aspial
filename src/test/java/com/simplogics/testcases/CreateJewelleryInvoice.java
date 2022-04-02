package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.simplogics.base.Testbase;
import com.simplogics.utilities.ExtentManager;
import com.simplogics.utilities.TestUtil;

public class CreateJewelleryInvoice extends Testbase {
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void CreatejewelleryInvoice(Hashtable<String, String> data) throws InterruptedException, AWTException {
		if (!(TestUtil.isTestRunnable("CreatejewelleryInvoice", excel))) {

			throw new SkipException(
					"Skipping the test " + "CreatejewelleryInvoice".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {
			ExtentManager.logger.log(Status.SKIP, "Skipped Billing Supplier is: " + data.get("billingsupplierSarchbox"));
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}

		MywaitpresenceOfElementLocated("invoicebtn__XPATH");
		// elementtobeclickable("invoicebtn__XPATH");
		click("invoicebtn__XPATH");
		Thread.sleep(500);
		click("Invoicejewellery_XPATH");

		MywaitpresenceOfElementLocated("billingSupCountry_XPATH");
		select("billingSupCountry_XPATH", data.get("billingSupCountry"));
		select("primarySupCountry_XPATH", data.get("primarySupCountry"));

		click("billingsupplier_XPATH");
		// type("", "4'C DIAMONDS PTE LTD");
		type("billingsupplierSarchbox_XPATH", data.get("billingsupplierSarchbox"));

		List<WebElement> list = driver.findElements(By.xpath("// *[@id=\"$b6\"]/div/div[2]/div[2]"));

		// *[@id=\"$b6\"]/div/div[2]/div[2]

		System.out.println("Auto Suggest List ::" + list.size());

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());

			if (list.get(i).getText().equals(data.get("billingsupplierSarchbox"))) {
				list.get(i).click();
				break;
			}

		}

		// Primary supplier path suggestion box starts here

		click("Primarysupplier_XPATH");

		type("PrimarysupplierSarchbox_XPATH", data.get("PrimarysupplierSarchbox"));

		List<WebElement> lst = driver.findElements(By.xpath("//*[@id=\"$b7\"]/div/div[2]/div[2]"));
		// *[@id=\"choices--b7-DropdownSelect-item-choice-1\"]

		System.out.println("Auto Suggest List ::" + lst.size());
		for (int i = 0; i < lst.size(); i++) {
			System.out.println(list.get(i).getText());

			if (lst.get(i).getText().equals(data.get("PrimarysupplierSarchbox"))) {
				lst.get(i).click();
				break;
			}

		}

		type("DocReftextfield_ID", data.get("DocReftextfield"));
		extent.setSystemInfo("DocRef No", data.get("DocReftextfield"));
		click("TotalQtytextfield_XPATH");
		type("TotalQtytextfield_XPATH", data.get("TotalQtytextfield"));
		presstab();
		type("TotalWttextfield_ID", data.get("TotalWttextfield"));

//			presstab();
//			presstab();
//			presstab();
//			presstab();

		Tab("TotalWttextfield_ID");
		doubleclick("wmcpjewellery_ID");
		type("wmcpjewellery_ID", data.get("WMCP"));
		// Thread.sleep(6000);
		click("invoicecreatetotalgold_ID");
		type("invoicecreatetotalgold_ID", data.get("totalgold"));
		// MywaitpresenceOfElementLocated("ExchangeRatejewellery_CSS");
		// click("ExchangeRatejewellery_CSS");

		// driver.findElement(By.cssSelector(testfield.getProperty("ExchangeRatejewellery_CSS"))).clear();
		// type("ExchangeRatejewellery_CSS", data.get("ExchangeRate"));
		Thread.sleep(1000);
		click("CreateInvoiceSavebtn_XPATH");
		MywaitinvisibilityOfElementLocated("loding_CSS");
		MywaitinvisibilityOfElementLocated("Feedback_CSS");
		MywaitpresenceOfElementLocated("InvoiceNumber_XPATH");
		String InvoiceNo = driver.findElement(By.xpath(testfield.getProperty("InvoiceNumber_XPATH"))).getText();
		extent.setSystemInfo("Invoice No:", InvoiceNo);

	}
}