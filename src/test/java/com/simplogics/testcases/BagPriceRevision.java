package com.simplogics.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class BagPriceRevision extends Testbase{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void bagPriceRevision(Hashtable<String, String>data) throws  InterruptedException, AWTException {
		

		if (!(TestUtil.isTestRunnable("BagPriceRevision", excel))) {

			throw new SkipException("Skipping the test " + "BagPriceRevision".toUpperCase() + "as the Run mode is NO");
		}
		
		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		
		MywaitpresenceOfElementLocated("PriceRevisionBagLink_XPATH");
		click("PriceRevisionBagLink_XPATH");
		
		
		if(!data.get("Subgroup1").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("BagSubgroup1Revision_XPATH");
			click("BagSubgroup1Revision_XPATH");
			MywaitpresenceOfElementLocated("BagSearchSG1Revision_XPATH");
			elementtobeclickable("BagSearchSG1Revision_XPATH");
			type("BagSearchSG1Revision_XPATH", data.get("Subgroup1"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(4000);
		}
		
		if(!data.get("Subgroup2").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("BagSubgroup2Revision_XPATH");
			elementtobeclickable("BagSubgroup2Revision_XPATH");
			MywaitpresenceOfElementLocated("BagSearchSG2Revision_XPATH");
			click("BagSearchSG2Revision_XPATH");
			type("BagSearchSG2Revision_XPATH", data.get("Subgroup2"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Subgroup3").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("BagSubgroup3Revision_XPATH");
			elementtobeclickable("BagSubgroup3Revision_XPATH");
			MywaitpresenceOfElementLocated("BagSearchSG3Revision_XPATH");
			click("BagSearchSG3Revision_XPATH");
			type("BagSearchSG3Revision_XPATH", data.get("Subgroup3"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Model").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("PriceModelBag_XPATH");
			click("PriceModelBag_XPATH");
			type("PriceModelBag_XPATH", data.get("Model"));
			presstab();
		}
		
		if(!data.get("Version").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("PriceVersionBag_XPATH");
			click("PriceVersionBag_XPATH");
			type("PriceVersionBag_XPATH", data.get("Version"));
			presstab();
		}
		
		if(!data.get("Config").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("PriceConfigBag_XPATH");
			click("PriceConfigBag_XPATH");
			type("PriceConfigBag_XPATH", data.get("Config"));
			presstab();
		}
		
		if(!data.get("Category").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("BagCategoriesRevision_XPATH");
			elementtobeclickable("BagCategoriesRevision_XPATH");
			MywaitpresenceOfElementLocated("BagCategoriesSearchRevision_XPATH");
			click("BagCategoriesSearchRevision_XPATH");
			type("BagCategoriesSearchRevision_XPATH", data.get("Category"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Collection").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("BagCollectionRevision_XPATH");
			elementtobeclickable("BagCollectionRevision_XPATH");
			MywaitpresenceOfElementLocated("BagCollectionSearchRevision_XPATH");
			click("BagCollectionSearchRevision_XPATH");
			type("BagCollectionSearchRevision_XPATH", data.get("Collection"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Size").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagSizeRevision_XPATH");
			elementtobeclickable("BagSizeRevision_XPATH");
			MywaitpresenceOfElementLocated("BagSizeSearchRevision_XPATH");
			click("BagSizeSearchRevision_XPATH");
			type("BagSizeSearchRevision_XPATH", data.get("Size"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Material").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagMaterialRevision_XPATH");
			elementtobeclickable("BagMaterialRevision_XPATH");
			MywaitpresenceOfElementLocated("BagMaterialSearchRevision_XPATH");
			click("BagMaterialSearchRevision_XPATH");
			type("BagMaterialSearchRevision_XPATH", data.get("Material"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("ModelNo").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagModelNoRevision_XPATH");
			click("BagModelNoRevision_XPATH");
			type("BagModelNoRevision_XPATH", data.get("ModelNo"));
			presstab();
		}
		
		if(!data.get("ItemNo").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagItemNoRevision_XPATH");
			click("BagItemNoRevision_XPATH");
			type("BagItemNoRevision_XPATH", data.get("ItemNo"));
			presstab();
		}
		
		if(!data.get("RecordingID").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagRecordingIDRevision_XPATH");
			click("BagRecordingIDRevision_XPATH");
			type("BagRecordingIDRevision_XPATH", data.get("RecordingID"));
			presstab();
		}
		
		MywaitpresenceOfElementLocated("BagListingSearch_XPATH");
		click("BagListingSearch_XPATH");
		
		MywaitinvisibilityOfElementLocated("3lineloader_CSS");
		MywaitpresenceOfElementLocated("RevisionTableRow1_XPATH");
		click("RevisionTableRow1_XPATH");
		Thread.sleep(1000);
		click("RevisePriceBtn_XPATH");
		
	}

}
