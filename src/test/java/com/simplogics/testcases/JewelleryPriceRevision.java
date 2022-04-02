package com.simplogics.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class JewelleryPriceRevision extends Testbase{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void jewelleryPriceRevision(Hashtable<String, String>data)throws InterruptedException,AWTException{
		
		if (!(TestUtil.isTestRunnable("jewelleryPriceRevision", excel))) {

			throw new SkipException("Skipping the test " + "jewelleryPriceRevision".toUpperCase() + "as the Run mode is NO");
		}
		
		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
				
		if(!data.get("Subgroup1").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("JewellerySubgroup1Revision_XPATH");
			click("JewellerySubgroup1Revision_XPATH");
			MywaitpresenceOfElementLocated("JewellerySearchSG1Revision_XPATH");
			elementtobeclickable("JewellerySearchSG1Revision_XPATH");
			type("JewellerySearchSG1Revision_XPATH", data.get("Subgroup1"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(4000);
		}
		
		if(!data.get("Subgroup2").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("JewellerySubgroup2Revision_XPATH");
			elementtobeclickable("JewellerySubgroup2Revision_XPATH");
			MywaitpresenceOfElementLocated("JewellerySearchSG2Revision_XPATH");
			click("JewellerySearchSG2Revision_XPATH");
			type("JewellerySearchSG2Revision_XPATH", data.get("Subgroup2"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Collection").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("JewelleryCollectionRevision_XPATH");
			elementtobeclickable("JewelleryCollectionRevision_XPATH");
			MywaitpresenceOfElementLocated("JewelleryCollectionSearchRevision_XPATH");
			click("JewelleryCollectionSearchRevision_XPATH");
			type("JewelleryCollectionSearchRevision_XPATH", data.get("Collection"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Model").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("PriceModel_XPATH");
			click("PriceModel_XPATH");
			type("PriceModel_XPATH", data.get("Model"));
			presstab();
		}
		
		if(!data.get("Version").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("PriceVersion_XPATH");
			click("PriceVersion_XPATH");
			type("PriceVersion_XPATH", data.get("Version"));
			presstab();
		}
		
		if(!data.get("Config").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("PriceConfig_XPATH");
			click("PriceConfig_XPATH");
			type("PriceConfig_XPATH", data.get("Config"));
			presstab();
		}
		
		if(!data.get("Category").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("JewelleryCategoriesRevision_XPATH");
			elementtobeclickable("JewelleryCategoriesRevision_XPATH");
			MywaitpresenceOfElementLocated("JewelleryCategoriesSearchRevision_XPATH");
			click("JewelleryCategoriesSearchRevision_XPATH");
			type("JewelleryCategoriesSearchRevision_XPATH", data.get("Category"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("CertType").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("JewelleryCertTypeRevision_XPATH");
			elementtobeclickable("JewelleryCertTypeRevision_XPATH");
			MywaitpresenceOfElementLocated("JewelleryCertTypeSearchRevision_XPATH");
			click("JewelleryCertTypeSearchRevision_XPATH");
			type("JewelleryCertTypeSearchRevision_XPATH", data.get("CertType"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}

		
		if(!data.get("ItemNo").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("JewelleryItemNoRevision_XPATH");
			click("JewelleryItemNoRevision_XPATH");
			type("JewelleryItemNoRevision_XPATH", data.get("ItemNo"));
			presstab();
		}
		
		if(!data.get("RecordingID").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("JewelleryRecordingIDRevision_XPATH");
			click("JewelleryRecordingIDRevision_XPATH");
			type("JewelleryRecordingIDRevision_XPATH", data.get("RecordingID"));
			presstab();
		}
		
		MywaitpresenceOfElementLocated("JewelleryListingSearch_XPATH");
		click("JewelleryListingSearch_XPATH");
		
		MywaitinvisibilityOfElementLocated("3lineloader_CSS");
		MywaitpresenceOfElementLocated("RevisionTableRow1_XPATH");
		click("RevisionTableRow1_XPATH");
		Thread.sleep(1000);
		click("RevisePriceBtn_XPATH");
		
	}

}
