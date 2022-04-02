package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class CreateBagInvoice extends Testbase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void createbaginvoice(Hashtable<String, String> data) throws InterruptedException, AWTException {

		
		if (!(TestUtil.isTestRunnable("createbaginvoice", excel))) {

			throw new SkipException(
					"Skipping the test " + "createbaginvoice".toUpperCase() + "as the Run mode is NO");
		}
		
		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}

		MywaitpresenceOfElementLocated("invoicebtn__XPATH");
		elementtobeclickable("invoicebtn__XPATH");

		MywaitpresenceOfElementLocated("bagbtn__XPATH");
		click("bagbtn__XPATH");


		MywaitpresenceOfElementLocated("billingSupCountry_XPATH");
		select("billingSupCountry_XPATH", data.get("billingSupCountry"));

		MywaitpresenceOfElementLocated("primarySupCountry");
		select("primarySupCountry_XPATH", data.get("primarySupCountry"));

		click("billingsupplier_XPATH");
		type("billingsupplierSarchbox_XPATH", data.get("billingsupplierSarchbox"));

		List<WebElement> list = driver.findElements(By.xpath("// *[@id=\"$b6\"]/div/div[2]/div[2]"));
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
		
		click("DocReftextfield_ID");
		type("DocReftextfield_ID", data.get("DocReftextfield"));
		click("TotalQtytextfield_XPATH");
		type("TotalQtytextfield_XPATH", data.get("TotalQtytextfield"));
		presstab();
		type("TotalWttextfield_ID", data.get("TotalWttextfield"));
		presstab();
		presstab();
		presstab();
		presstab();
		type("InvoiceCurrencytextfield_ID", data.get("InvoiceCurrencytextfield"));
		click("CreateInvoiceSavebtn_XPATH");
		
		MywaitinvisibilityOfElementLocated("loader_CSS");
	}

}
