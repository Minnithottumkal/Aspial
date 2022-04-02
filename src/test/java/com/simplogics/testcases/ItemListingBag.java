package com.simplogics.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class ItemListingBag extends Testbase{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void itemListingBag(Hashtable<String, String>data) throws InterruptedException,AWTException {
		
		if (!(TestUtil.isTestRunnable("ItemListingBag", excel))) {

			throw new SkipException("Skipping the test " + "ItemListingBag".toUpperCase() + "as the Run mode is NO");
		}
		
		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		
		
		MywaitpresenceOfElementLocated("BagItemListing_XPATH");
		click("BagItemListing_XPATH");
		
		Thread.sleep(2000);
		MywaitpresenceOfElementLocated("BagListingSubgroup1_XPATH");
		
		if(!data.get("Brand").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagListingBrand_XPATH");
			click("BagListingBrand_XPATH");
			MywaitpresenceOfElementLocated("BagSearchBrand_XPATH");
			type("BagSearchBrand_XPATH", data.get("Brand"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(4000);
		}
		
		if(!data.get("Subgroup1").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagListingSubgroup1_XPATH");
			click("BagListingSubgroup1_XPATH");
			MywaitpresenceOfElementLocated("BagSearchSubgroup1_XPATH");
			elementtobeclickable("BagSearchSubgroup1_XPATH");
			type("BagSearchSubgroup1_XPATH", data.get("Subgroup1"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(4000);
		}
		
		if(!data.get("Subgroup2").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagListingSubgroup2_XPATH");
			elementtobeclickable("BagListingSubgroup2_XPATH");
			MywaitpresenceOfElementLocated("BagSearchSubgroup2_XPATH");
			click("BagSearchSubgroup2_XPATH");
			type("BagSearchSubgroup2_XPATH", data.get("Subgroup2"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Subgroup3").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagListingSubgroup3_XPATH");
			elementtobeclickable("BagListingSubgroup3_XPATH");
			MywaitpresenceOfElementLocated("BagSearchSubgroup3_XPATH");
			click("BagSearchSubgroup3_XPATH");
			type("BagSearchSubgroup3_XPATH", data.get("Subgroup3"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Collection").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagListingCollection_XPATH");
			elementtobeclickable("BagListingCollection_XPATH");
			MywaitpresenceOfElementLocated("BagSearchCollection_XPATH");
			click("BagSearchCollection_XPATH");
			type("BagSearchCollection_XPATH", data.get("Collection"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		
		if(!data.get("Model").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagListingModel_XPATH");
			click("BagListingModel_XPATH");
			type("BagListingModel_XPATH", data.get("Model"));
			presstab();
		}
		
		if(!data.get("Version").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagListingVersion_XPATH");
			click("BagListingVersion_XPATH");
			type("BagListingVersion_XPATH", data.get("Version"));
			presstab();
		}
		
		if(!data.get("Config").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagListingConfig_XPATH");
			click("BagListingConfig_XPATH");
			type("BagListingConfig_XPATH", data.get("Config"));
			presstab();
		}
		
		
		if(!data.get("GroupType").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagListingGroupType_XPATH");
			elementtobeclickable("BagListingGroupType_XPATH");
			MywaitpresenceOfElementLocated("BagSearchGroupType_XPATH");
			click("BagSearchGroupType_XPATH");
			type("BagSearchGroupType_XPATH", data.get("GroupType"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("ItemNo(From)").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagListingItemNoFrom_XPATH");
			click("BagListingItemNoFrom_XPATH");
			type("BagListingItemNoFrom_XPATH", data.get("ItemNo(From)"));
			presstab();
		}
		
		if(!data.get("ItemNo(To)").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagListingItemNoTo_XPATH");
			click("BagListingItemNoTo_XPATH");
			type("BagListingItemNoTo_XPATH", data.get("ItemNo(To)"));
			presstab();
		}
		
		if(!data.get("BulkNo").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagListingBulkNo_XPATH");
			click("BagListingBulkNo_XPATH");
			type("BagListingBulkNo_XPATH", data.get("BulkNo"));
			presstab();
		}
		
		if(!data.get("PrimarySupplier").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagListingPrimarySupplier_XPATH");
			elementtobeclickable("BagListingPrimarySupplier_XPATH");
			MywaitpresenceOfElementLocated("BagSearchPrimarySupplier_XPATH");
			click("BagSearchPrimarySupplier_XPATH");
			type("BagSearchPrimarySupplier_XPATH", data.get("PrimarySupplier"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Date(From)").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagSupplierDateFrom_XPATH");
			click("BagSupplierDateFrom_XPATH");
			type("BagSupplierDateFrom_XPATH", data.get("Date(From)"));
			presstab();
		}
		
		if(!data.get("Date(To)").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagSupplierDateTo_XPATH");
			click("BagSupplierDateTo_XPATH");
			type("BagSupplierDateTo_XPATH", data.get("Date(To)"));
			presstab();
		}
		
		
		if(!data.get("Creator").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagListingCreator_XPATH");
			click("BagListingCreator_XPATH");
			MywaitpresenceOfElementLocated("BagSearchCreator_XPATH");
			click("BagSearchCreator_XPATH");
			type("BagSearchCreator_XPATH", data.get("Creator"));
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
		
		if(!data.get("Status").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagListingStatus_XPATH");
			click("BagListingStatus_XPATH");
			type("BagListingStatus_XPATH", data.get("Status"));
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
		
		if(!data.get("Branch").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagListingBranch_XPATH");
			click("BagListingBranch_XPATH");
			type("BagListingBranch_XPATH", data.get("Branch"));
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
		
		MywaitpresenceOfElementLocated("BagListingSearch_XPATH");
		click("BagListingSearch_XPATH");
		MywaitpresenceOfElementLocated("3lineloader_CSS");
		long start = System.currentTimeMillis();
		System.out.println(start);
		MywaitinvisibilityOfElementLocated("3lineloader_CSS");
		long end = System.currentTimeMillis();
		System.out.println(end);
		System.out.println("Total time = " + (end - start));
		double Timetaken = ((end-start)/1000) - 10;
		extent.setSystemInfo("Time Taken in seconds: ", Double.toString(Timetaken));
		Thread.sleep(2000);
		Boolean isElementDisplayed = isElementPresent(By.xpath("//*[contains(@id,\"Content\")]/span"));
		if(isElementDisplayed == true)
		{
			WebElement e = driver.findElement(By.xpath("//*[contains(@id,\"Content\")]/span"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView()", e);
			extent.setSystemInfo("No of items: ", "No records found.");
		}
		else
		{
			WebElement e1 = driver.findElement(By.xpath(testfield.getProperty("NoOfItems_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView()", e1);
			String items = driver.findElement(By.xpath(testfield.getProperty("NoOfItems_XPATH"))).getText();
			extent.setSystemInfo("No of items: ", items);
		}
		
	}

}
