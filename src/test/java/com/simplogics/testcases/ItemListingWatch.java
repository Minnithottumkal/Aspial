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

public class ItemListingWatch extends Testbase {
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void itemListingWatch(Hashtable<String, String>data)throws InterruptedException,AWTException{
		
		if (!(TestUtil.isTestRunnable("ItemListingWatch", excel))) {

			throw new SkipException("Skipping the test " + "ItemListingWatch".toUpperCase() + "as the Run mode is NO");
		}
		
		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		
		
		MywaitpresenceOfElementLocated("WatchItemListing_XPATH");
		click("WatchItemListing_XPATH");
		
		Thread.sleep(2000);
		MywaitpresenceOfElementLocated("WatchListingSubgroup1_XPATH");
		
		if(!data.get("Brand").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchListingBrand_XPATH");
			click("WatchListingBrand_XPATH");
			MywaitpresenceOfElementLocated("WatchSearchBrand_XPATH");
			type("WatchSearchBrand_XPATH", data.get("Brand"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(4000);
		}
		
		if(!data.get("Subgroup1").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchListingSubgroup1_XPATH");
			click("WatchListingSubgroup1_XPATH");
			MywaitpresenceOfElementLocated("WatchSearchSubgroup1_XPATH");
			elementtobeclickable("WatchSearchSubgroup1_XPATH");
			type("WatchSearchSubgroup1_XPATH", data.get("Subgroup1"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(4000);
		}
		
		if(!data.get("Subgroup2").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchListingSubgroup2_XPATH");
			elementtobeclickable("WatchListingSubgroup2_XPATH");
			MywaitpresenceOfElementLocated("WatchSearchSubgroup2_XPATH");
			click("WatchSearchSubgroup2_XPATH");
			type("WatchSearchSubgroup2_XPATH", data.get("Subgroup2"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Subgroup3").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchListingSubgroup3_XPATH");
			elementtobeclickable("WatchListingSubgroup3_XPATH");
			MywaitpresenceOfElementLocated("WatchSearchSubgroup3_XPATH");
			click("WatchSearchSubgroup3_XPATH");
			type("WatchSearchSubgroup3_XPATH", data.get("Subgroup3"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Collection").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchListingCollection_XPATH");
			elementtobeclickable("WatchListingCollection_XPATH");
			MywaitpresenceOfElementLocated("WatchSearchCollection_XPATH");
			click("WatchSearchCollection_XPATH");
			type("WatchSearchCollection_XPATH", data.get("Collection"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		
		if(!data.get("Model").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchListingModel_XPATH");
			click("WatchListingModel_XPATH");
			type("WatchListingModel_XPATH", data.get("Model"));
			presstab();
		}
		
		if(!data.get("Version").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchListingVersion_XPATH");
			click("WatchListingVersion_XPATH");
			type("WatchListingVersion_XPATH", data.get("Version"));
			presstab();
		}
		
		if(!data.get("Config").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchListingConfig_XPATH");
			click("WatchListingConfig_XPATH");
			type("WatchListingConfig_XPATH", data.get("Config"));
			presstab();
		}
		
		
		if(!data.get("GroupType").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchListingGroupType_XPATH");
			elementtobeclickable("WatchListingGroupType_XPATH");
			MywaitpresenceOfElementLocated("WatchSearchGroupType_XPATH");
			click("WatchSearchGroupType_XPATH");
			type("WatchSearchGroupType_XPATH", data.get("GroupType"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("ItemNo(From)").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchListingItemNoFrom_XPATH");
			click("WatchListingItemNoFrom_XPATH");
			type("WatchListingItemNoFrom_XPATH", data.get("ItemNo(From)"));
			presstab();
		}
		
		if(!data.get("ItemNo(To)").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchListingItemNoTo_XPATH");
			click("WatchListingItemNoTo_XPATH");
			type("WatchListingItemNoTo_XPATH", data.get("ItemNo(To)"));
			presstab();
		}
		
		if(!data.get("BulkNo").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchListingBulkNo_XPATH");
			click("WatchListingBulkNo_XPATH");
			type("WatchListingBulkNo_XPATH", data.get("BulkNo"));
			presstab();
		}
		
		if(!data.get("PrimarySupplier").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchListingPrimarySupplier_XPATH");
			elementtobeclickable("WatchListingPrimarySupplier_XPATH");
			MywaitpresenceOfElementLocated("WatchSearchPrimarySupplier_XPATH");
			click("WatchSearchPrimarySupplier_XPATH");
			type("WatchSearchPrimarySupplier_XPATH", data.get("PrimarySupplier"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Date(From)").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchSupplierDateFrom_XPATH");
			click("WatchSupplierDateFrom_XPATH");
			type("WatchSupplierDateFrom_XPATH", data.get("Date(From)"));
			presstab();
		}
		
		if(!data.get("Date(To)").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchSupplierDateTo_XPATH");
			click("WatchSupplierDateTo_XPATH");
			type("WatchSupplierDateTo_XPATH", data.get("Date(To)"));
			presstab();
		}
		
		
		if(!data.get("Creator").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchListingCreator_XPATH");
			click("WatchListingCreator_XPATH");
			MywaitpresenceOfElementLocated("WatchSearchCreator_XPATH");
			click("WatchSearchCreator_XPATH");
			type("WatchSearchCreator_XPATH", data.get("Creator"));
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
		
		if(!data.get("Status").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchListingStatus_XPATH");
			click("WatchListingStatus_XPATH");
			type("WatchListingStatus_XPATH", data.get("Status"));
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
		
		if(!data.get("Branch").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchListingBranch_XPATH");
			click("WatchListingBranch_XPATH");
			type("WatchListingBranch_XPATH", data.get("Branch"));
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
		

		MywaitpresenceOfElementLocated("WatchListingSearch_XPATH");
		click("WatchListingSearch_XPATH");
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
