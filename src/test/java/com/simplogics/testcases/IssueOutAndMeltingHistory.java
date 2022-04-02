package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.simplogics.base.Testbase;
import com.simplogics.utilities.ExtentManager;
import com.simplogics.utilities.TestUtil;

public class IssueOutAndMeltingHistory extends Testbase {
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void issueOutandMeltingHistory(Hashtable<String, String> data) throws InterruptedException, AWTException {

		if (!(TestUtil.isTestRunnable("IssueOutandMeltingHistory", excel))) {

			throw new SkipException(
					"Skipping the test " + "IssueOutandMeltingHistory".toUpperCase() + "as the Run mode is NO");
		}
		if (!data.get("runmode").equals("Y")) {
			ExtentManager.logger.log(Status.SKIP, "Skipping this Testdata as the Runmode set is NO ");
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");

		}
		
		if (!data.get("SearchID").equals("")) {

			MywaitpresenceOfElementLocated("SearchID_XPATH");
			click("SearchID_XPATH");
			type("SearchID_XPATH", data.get("SearchID"));

		}
		
		if (!data.get("Action").equals("")) {

			MywaitpresenceOfElementLocated("ActionClick_XPATH");
			click("ActionClick_XPATH");
			MywaitpresenceOfElementLocated("ActionSearch_XPATH");
			click("ActionSearch_XPATH");
			type("ActionSearch_XPATH", data.get("Action"));
			Enter("ActionSearch_XPATH");

		}

		if (!data.get("RecipientType").equals("")) {

			select("RecipientType_XPATH", data.get("RecipientType"));
			MywaitvisibilityOfElementLocated("Country_XPATH");

		}

		if (!data.get("Country").equals("")) {

			select("Country_XPATH", data.get("Country"));

		}
		if (!data.get("Purpose").equals("")) {
			MywaitvisibilityOfElementLocated("Purpose_XPATH");
			select("Purpose_XPATH", data.get("Purpose"));
		}
		if (!data.get("Approver").equals("")) {
			MywaitvisibilityOfElementLocated("Approver_XPATH");
			select("Approver_XPATH", data.get("Approver"));
		}

		if (!data.get("CreatedBy").equals("")) {
			click("CreatedByclick_XPATH");
			type("CreatedBysearchbox_XPATH", data.get("CreatedBy"));
			Enter("CreatedBysearchbox_XPATH");
		}

		if (!data.get("CreatedDate").equals("")) {
			type("CreatedDateselection_XPATH", data.get("CreatedDate"));
		}

		click("Searchissueoutandmelting_XPATH");
		StopWatch pageLoad = new StopWatch();
		pageLoad.start();
		MywaitinvisibilityOfElementLocated("Loaderissueoutandmelting_CSS");
		pageLoad.stop();
		long pageLoadTime_ms = pageLoad.getTime();
		long pageLoadTime_Seconds = (pageLoadTime_ms / 1000) - 10;
		System.out.println("Time taken in seconds: " + pageLoadTime_Seconds);
		extent.setSystemInfo("Time taken in seconds: ", Long.toString(pageLoadTime_Seconds));
		
		Boolean isElementDisplayed = isElementPresent(By.xpath("//span[5]"));
		if(isElementDisplayed == true) {
		String item = driver.findElement(By.xpath(testfield.getProperty("Items_XPATH"))).getText();
		System.out.println("Total no of items: " + item);
		extent.setSystemInfo("Total no of items: ", item);
		}
		else
		{
			extent.setSystemInfo("No of items: ", "No records found.");
		}
	}
}
