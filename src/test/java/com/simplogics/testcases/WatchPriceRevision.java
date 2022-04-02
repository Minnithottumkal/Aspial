package com.simplogics.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class WatchPriceRevision extends Testbase{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void watchPriceRevision(Hashtable<String, String>data)throws InterruptedException, AWTException {
		
		if (!(TestUtil.isTestRunnable("WatchPriceRevision", excel))) {

			throw new SkipException("Skipping the test " + "WatchPriceRevision".toUpperCase() + "as the Run mode is NO");
		}
		
		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		
		MywaitpresenceOfElementLocated("PriceRevisionWatchLink_XPATH");
		click("PriceRevisionWatchLink_XPATH");
		
		
		if(!data.get("Subgroup1").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("WatchSubgroup1Revision_XPATH");
			click("WatchSubgroup1Revision_XPATH");
			MywaitpresenceOfElementLocated("WatchSearchSG1Revision_XPATH");
			elementtobeclickable("WatchSearchSG1Revision_XPATH");
			type("WatchSearchSG1Revision_XPATH", data.get("Subgroup1"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(4000);
		}
		
		if(!data.get("Subgroup2").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("WatchSubgroup2Revision_XPATH");
			elementtobeclickable("WatchSubgroup2Revision_XPATH");
			MywaitpresenceOfElementLocated("WatchSearchSG2Revision_XPATH");
			click("WatchSearchSG2Revision_XPATH");
			type("WatchSearchSG2Revision_XPATH", data.get("Subgroup2"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Subgroup3").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("WatchSubgroup3Revision_XPATH");
			elementtobeclickable("WatchSubgroup3Revision_XPATH");
			MywaitpresenceOfElementLocated("WatchSearchSG3Revision_XPATH");
			click("WatchSearchSG3Revision_XPATH");
			type("WatchSearchSG3Revision_XPATH", data.get("Subgroup3"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Model").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("PriceModelWatch_XPATH");
			click("PriceModelWatch_XPATH");
			type("PriceModelWatch_XPATH", data.get("Model"));
			presstab();
		}
		
		if(!data.get("Version").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("PriceVersionWatch_XPATH");
			click("PriceVersionWatch_XPATH");
			type("PriceVersionWatch_XPATH", data.get("Version"));
			presstab();
		}
		
		if(!data.get("Config").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("PriceConfigWatch_XPATH");
			click("PriceConfigWatch_XPATH");
			type("PriceConfigWatch_XPATH", data.get("Config"));
			presstab();
		}
		
		if(!data.get("Category").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("WatchCategoriesRevision_XPATH");
			elementtobeclickable("WatchCategoriesRevision_XPATH");
			MywaitpresenceOfElementLocated("WatchCategoriesSearchRevision_XPATH");
			click("WatchCategoriesSearchRevision_XPATH");
			type("WatchCategoriesSearchRevision_XPATH", data.get("Category"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Collection").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("WatchCollectionRevision_XPATH");
			elementtobeclickable("WatchCollectionRevision_XPATH");
			MywaitpresenceOfElementLocated("WatchCollectionSearchRevision_XPATH");
			click("WatchCollectionSearchRevision_XPATH");
			type("WatchCollectionSearchRevision_XPATH", data.get("Collection"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("ModelNo").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchModelNoRevision_XPATH");
			click("WatchModelNoRevision_XPATH");
			type("WatchModelNoRevision_XPATH", data.get("ModelNo"));
			presstab();
		}
		
		if(!data.get("ItemNo").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchItemNoRevision_XPATH");
			click("WatchItemNoRevision_XPATH");
			type("WatchItemNoRevision_XPATH", data.get("ItemNo"));
			presstab();
		}
		
		if(!data.get("RecordingID").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchRecordingIDRevision_XPATH");
			click("WatchRecordingIDRevision_XPATH");
			type("WatchRecordingIDRevision_XPATH", data.get("RecordingID"));
			presstab();
		}
		
		MywaitpresenceOfElementLocated("WatchListingSearch_XPATH");
		click("WatchListingSearch_XPATH");
		
		MywaitinvisibilityOfElementLocated("3lineloader_CSS");
		MywaitpresenceOfElementLocated("RevisionTableRow1_XPATH");
		click("RevisionTableRow1_XPATH");
		Thread.sleep(1000);
		click("RevisePriceBtn_XPATH");
	}

}
