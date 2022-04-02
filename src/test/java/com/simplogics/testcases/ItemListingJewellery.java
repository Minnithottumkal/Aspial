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

public class ItemListingJewellery extends Testbase{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void itemListingJewellery(Hashtable<String, String>data) throws InterruptedException, AWTException {
		
		if (!(TestUtil.isTestRunnable("itemListingJewellery", excel))) {

			throw new SkipException("Skipping the test " + "itemListingJewellery".toUpperCase() + "as the Run mode is NO");
		}
		
		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		
//		if(!data.get("Brand").equals("") && data.get("runmode").equals("Y"))
//		{
//			MywaitpresenceOfElementLocated("JewelleryListingBrand_XPATH");
//			click("JewelleryListingBrand_XPATH");
//			MywaitpresenceOfElementLocated("SearchBrand_XPATH");
//			click("SearchBrand_XPATH");
//			type("SearchBrand_XPATH", data.get("Brand"));
//			Robot robot = new Robot();
//			robot.keyPress(KeyEvent.VK_ENTER);
//			presstab();
//			Thread.sleep(4000);
//		}
		
		if(!data.get("Subgroup1").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("JewelleryListingSubgroup1_XPATH");
			click("JewelleryListingSubgroup1_XPATH");
			MywaitpresenceOfElementLocated("SearchSubgroup1_XPATH");
			click("SearchSubgroup1_XPATH");
			type("SearchSubgroup1_XPATH", data.get("Subgroup1"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(4000);
		}
		
		if(!data.get("Subgroup2").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("JewelleryListingSubgroup2_XPATH");
			elementtobeclickable("JewelleryListingSubgroup2_XPATH");
			MywaitpresenceOfElementLocated("SearchSubgroup2_XPATH");
			click("SearchSubgroup2_XPATH");
			type("SearchSubgroup2_XPATH", data.get("Subgroup2"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Collection").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("JewelleryListingCollection_XPATH");
			elementtobeclickable("JewelleryListingCollection_XPATH");
			MywaitpresenceOfElementLocated("SearchCollection_XPATH");
			click("SearchCollection_XPATH");
			type("SearchCollection_XPATH", data.get("Collection"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		
		if(!data.get("Model").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("JewelleryListingModel_XPATH");
			click("JewelleryListingModel_XPATH");
			type("JewelleryListingModel_XPATH", data.get("Model"));
			presstab();
		}
		
		if(!data.get("Version").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("JewelleryListingVersion_XPATH");
			click("JewelleryListingVersion_XPATH");
			type("JewelleryListingVersion_XPATH", data.get("Version"));
			presstab();
		}
		
		if(!data.get("Config").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("JewelleryListingConfig_XPATH");
			click("JewelleryListingConfig_XPATH");
			type("JewelleryListingConfig_XPATH", data.get("Config"));
			presstab();
		}
		
		if(!data.get("CertType").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("JewelleryListingCertType_XPATH");
			elementtobeclickable("JewelleryListingCertType_XPATH");
			MywaitpresenceOfElementLocated("SearchCertType_XPATH");
			click("SearchCertType_XPATH");
			type("SearchCertType_XPATH", data.get("CertType"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		
		if(!data.get("GroupType").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("JewelleryListingGroupType_XPATH");
			elementtobeclickable("JewelleryListingGroupType_XPATH");
			MywaitpresenceOfElementLocated("SearchGroupType_XPATH");
			click("SearchGroupType_XPATH");
			type("SearchGroupType_XPATH", data.get("GroupType"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("ItemNo(From)").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("JewelleryListingItemNoFrom_XPATH");
			click("JewelleryListingItemNoFrom_XPATH");
			type("JewelleryListingItemNoFrom_XPATH", data.get("ItemNo(From)"));
			presstab();
		}
		
		if(!data.get("ItemNo(To)").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("JewelleryListingItemNoTo_XPATH");
			click("JewelleryListingItemNoTo_XPATH");
			type("JewelleryListingItemNoTo_XPATH", data.get("ItemNo(To)"));
			presstab();
		}
		
		if(!data.get("BulkNo").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("JewelleryListingBulkNo_XPATH");
			click("JewelleryListingBulkNo_XPATH");
			type("JewelleryListingBulkNo_XPATH", data.get("BulkNo"));
			presstab();
		}
		
		if(!data.get("PrimarySupplier").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("JewelleryListingPrimarySupplier_XPATH");
			elementtobeclickable("JewelleryListingPrimarySupplier_XPATH");
			MywaitpresenceOfElementLocated("SearchPrimarySupplier_XPATH");
			click("SearchPrimarySupplier_XPATH");
			type("SearchPrimarySupplier_XPATH", data.get("PrimarySupplier"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Date(From)").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("JewellerySupplierDateFrom_XPATH");
			click("JewellerySupplierDateFrom_XPATH");
			type("JewellerySupplierDateFrom_XPATH", data.get("Date(From)"));
			presstab();
		}
		
		if(!data.get("Date(To)").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("JewellerySupplierDateTo_XPATH");
			click("JewellerySupplierDateTo_XPATH");
			type("JewellerySupplierDateTo_XPATH", data.get("Date(To)"));
			presstab();
		}
		
		
		if(!data.get("Creator").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("JewelleryListingCreator_XPATH");
			click("JewelleryListingCreator_XPATH");
			MywaitpresenceOfElementLocated("SearchCreator_XPATH");
			click("SearchCreator_XPATH");
			type("SearchCreator_XPATH", data.get("Creator"));
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
		
		if(!data.get("Status").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("JewelleryListingStatus_XPATH");
			click("JewelleryListingStatus_XPATH");
			type("JewelleryListingStatus_XPATH", data.get("Status"));
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
		
		if(!data.get("Branch").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("JewelleryListingBranch_XPATH");
			click("JewelleryListingBranch_XPATH");
			type("JewelleryListingBranch_XPATH", data.get("Branch"));
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
		
		MywaitpresenceOfElementLocated("JewelleryListingSearch_XPATH");
		click("JewelleryListingSearch_XPATH");
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
