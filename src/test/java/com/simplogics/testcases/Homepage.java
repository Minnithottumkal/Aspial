package com.simplogics.testcases;

import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import org.testng.SkipException;
import com.simplogics.utilities.TestUtil;

public class Homepage extends Testbase {

	@Test
	public void homepage() throws InterruptedException {
		if (!(TestUtil.isTestRunnable("homepage", excel))) {

			throw new SkipException("Skipping the test " + "homepage".toUpperCase() + "as the Run mode is NO");
		}
		MywaitpresenceOfElementLocated("purchasebtn_CSS");
		click("purchasebtn_CSS");
		
		//Thread.sleep(5000);
		//String ActualpageURL = driver.getCurrentUrl().toString();
		//String ExpectedpageURL = "https://aspial-tst.outsystemsenterprise.com/PurchaseManagement/";
		//assertEquals(ActualpageURL, ExpectedpageURL);
		
	}
}
