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

public class ItemListingGold extends Testbase{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void itemListingGold(Hashtable<String, String> data)throws InterruptedException, AWTException {
		
		if (!(TestUtil.isTestRunnable("itemListingGold", excel))) {

			throw new SkipException("Skipping the test " + "itemListingGold".toUpperCase() + "as the Run mode is NO");
		}
		
		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		
		
		MywaitpresenceOfElementLocated("GoldItemListing_XPATH");
		click("GoldItemListing_XPATH");
		
		Thread.sleep(2000);
		MywaitpresenceOfElementLocated("GoldListingSubgroup1_XPATH");
		
		if(!data.get("Brand").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("GoldListingBrand_XPATH");
			click("GoldListingBrand_XPATH");
			MywaitpresenceOfElementLocated("GoldSearchBrand_XPATH");
			type("GoldSearchBrand_XPATH", data.get("Brand"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(4000);
		}
		
		if(!data.get("Subgroup1").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("GoldListingSubgroup1_XPATH");
			click("GoldListingSubgroup1_XPATH");
			MywaitpresenceOfElementLocated("GoldSearchSubgroup1_XPATH");
			elementtobeclickable("GoldSearchSubgroup1_XPATH");
			type("GoldSearchSubgroup1_XPATH", data.get("Subgroup1"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(4000);
		}
		
		if(!data.get("Subgroup2").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("GoldListingSubgroup2_XPATH");
			elementtobeclickable("GoldListingSubgroup2_XPATH");
			MywaitpresenceOfElementLocated("GoldSearchSubgroup2_XPATH");
			click("GoldSearchSubgroup2_XPATH");
			type("GoldSearchSubgroup2_XPATH", data.get("Subgroup2"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Collection").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("GoldListingCollection_XPATH");
			elementtobeclickable("GoldListingCollection_XPATH");
			MywaitpresenceOfElementLocated("GoldSearchCollection_XPATH");
			click("GoldSearchCollection_XPATH");
			type("GoldSearchCollection_XPATH", data.get("Collection"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		
		if(!data.get("Model").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("GoldListingModel_XPATH");
			click("GoldListingModel_XPATH");
			type("GoldListingModel_XPATH", data.get("Model"));
			presstab();
		}
		
		if(!data.get("Version").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("GoldListingVersion_XPATH");
			click("GoldListingVersion_XPATH");
			type("GoldListingVersion_XPATH", data.get("Version"));
			presstab();
		}
		
		if(!data.get("Config").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("GoldListingConfig_XPATH");
			click("GoldListingConfig_XPATH");
			type("GoldListingConfig_XPATH", data.get("Config"));
			presstab();
		}
		
		
		if(!data.get("GroupType").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("GoldListingGroupType_XPATH");
			elementtobeclickable("GoldListingGroupType_XPATH");
			MywaitpresenceOfElementLocated("GoldSearchGroupType_XPATH");
			click("GoldSearchGroupType_XPATH");
			type("GoldSearchGroupType_XPATH", data.get("GroupType"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("ItemNo(From)").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("GoldListingItemNoFrom_XPATH");
			click("GoldListingItemNoFrom_XPATH");
			type("GoldListingItemNoFrom_XPATH", data.get("ItemNo(From)"));
			presstab();
		}
		
		if(!data.get("ItemNo(To)").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("GoldListingItemNoTo_XPATH");
			click("GoldListingItemNoTo_XPATH");
			type("GoldListingItemNoTo_XPATH", data.get("ItemNo(To)"));
			presstab();
		}
		
		if(!data.get("BulkNo").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("GoldListingBulkNo_XPATH");
			click("GoldListingBulkNo_XPATH");
			type("GoldListingBulkNo_XPATH", data.get("BulkNo"));
			presstab();
		}
		
		if(!data.get("PrimarySupplier").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("GoldListingPrimarySupplier_XPATH");
			elementtobeclickable("GoldListingPrimarySupplier_XPATH");
			MywaitpresenceOfElementLocated("GoldSearchPrimarySupplier_XPATH");
			click("GoldSearchPrimarySupplier_XPATH");
			type("GoldSearchPrimarySupplier_XPATH", data.get("PrimarySupplier"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Date(From)").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("GoldSupplierDateFrom_XPATH");
			click("GoldSupplierDateFrom_XPATH");
			type("GoldSupplierDateFrom_XPATH", data.get("Date(From)"));
			presstab();
		}
		
		if(!data.get("Date(To)").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("GoldSupplierDateTo_XPATH");
			click("GoldSupplierDateTo_XPATH");
			type("GoldSupplierDateTo_XPATH", data.get("Date(To)"));
			presstab();
		}
		
		
		if(!data.get("Creator").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("GoldListingCreator_XPATH");
			click("GoldListingCreator_XPATH");
			MywaitpresenceOfElementLocated("GoldSearchCreator_XPATH");
			click("GoldSearchCreator_XPATH");
			type("GoldSearchCreator_XPATH", data.get("Creator"));
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
		
		if(!data.get("Status").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("GoldListingStatus_XPATH");
			click("GoldListingStatus_XPATH");
			type("GoldListingStatus_XPATH", data.get("Status"));
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
		
		if(!data.get("Branch").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("GoldListingBranch_XPATH");
			click("GoldListingBranch_XPATH");
			type("GoldListingBranch_XPATH", data.get("Branch"));
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
		
		if(!data.get("IPM").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("GoldListingIPM_XPATH");
			select("GoldListingIPM_XPATH", data.get("IPM"));
		}
		
		MywaitpresenceOfElementLocated("GoldListingSearch_XPATH");
		click("GoldListingSearch_XPATH");
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
