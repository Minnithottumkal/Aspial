package com.simplogics.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
public class InvoiceSearch extends Testbase {
	public void invoiceSearch(Hashtable<String, String> data) {
		if (!(TestUtil.isTestRunnable("invoiceSearch", excel))) {

			throw new SkipException(
					"Skipping the test " + "invoiceSearch".toUpperCase() + "as the Run mode is NO");
		}
		MywaitpresenceOfElementLocated("InvoicesearchTextSupplierDocNo_ID");
		click("InvoicesearchTextSupplierDocNo_ID");
		type("InvoicesearchTextSupplierDocNo_ID", data.get("DocRefNo"));
		MywaitvisibilityOfElementLocated("Invoiceseachcreateby_XPATH");
		click("Invoicesearchbtn_XPATH");
		System.out.println("Complted search");
		MywaitpresenceOfElementLocated("Invoiceopenbulk_XPATH");
		click("Invoiceopenbulk_XPATH");
		System.out.println("Click on the first invoice");
	}
	} 


