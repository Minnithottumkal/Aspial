package com.simplogics.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class GoldPriceRevision extends Testbase{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void goldPriceRevision(Hashtable<String, String>data)throws InterruptedException,AWTException{
		
		if (!(TestUtil.isTestRunnable("goldPriceRevision", excel))) {

			throw new SkipException("Skipping the test " + "goldPriceRevision".toUpperCase() + "as the Run mode is NO");
		}
		
		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
				
		MywaitpresenceOfElementLocated("PriceRevisionGoldLink_XPATH");
		click("PriceRevisionGoldLink_XPATH");
		
		
		if(!data.get("Subgroup1").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("GoldSubgroup1Revision_XPATH");
			click("GoldSubgroup1Revision_XPATH");
			MywaitpresenceOfElementLocated("GoldSearchSG1Revision_XPATH");
			elementtobeclickable("GoldSearchSG1Revision_XPATH");
			type("GoldSearchSG1Revision_XPATH", data.get("Subgroup1"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(4000);
		}
		
		if(!data.get("Subgroup2").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("GoldSubgroup2Revision_XPATH");
			elementtobeclickable("GoldSubgroup2Revision_XPATH");
			MywaitpresenceOfElementLocated("GoldSearchSG2Revision_XPATH");
			click("GoldSearchSG2Revision_XPATH");
			type("GoldSearchSG2Revision_XPATH", data.get("Subgroup2"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Collection").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("GoldCollectionRevision_XPATH");
			elementtobeclickable("GoldCollectionRevision_XPATH");
			MywaitpresenceOfElementLocated("GoldCollectionSearchRevision_XPATH");
			click("GoldCollectionSearchRevision_XPATH");
			type("GoldCollectionSearchRevision_XPATH", data.get("Collection"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Model").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("PriceModelGold_XPATH");
			click("PriceModelGold_XPATH");
			type("PriceModelGold_XPATH", data.get("Model"));
			presstab();
		}
		
		if(!data.get("Version").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("PriceVersionGold_XPATH");
			click("PriceVersionGold_XPATH");
			type("PriceVersionGold_XPATH", data.get("Version"));
			presstab();
		}
		
		if(!data.get("Config").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("PriceConfigGold_XPATH");
			click("PriceConfigGold_XPATH");
			type("PriceConfigGold_XPATH", data.get("Config"));
			presstab();
		}
		
		if(!data.get("Category").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("GoldCategoriesRevision_XPATH");
			elementtobeclickable("GoldCategoriesRevision_XPATH");
			MywaitpresenceOfElementLocated("JewelleryCategoriesSearchRevision_XPATH");
			click("GoldCategoriesSearchRevision_XPATH");
			type("GoldCategoriesSearchRevision_XPATH", data.get("Category"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("SellingMethod").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("GoldSellMethodRevision_XPATH");
			elementtobeclickable("GoldSellMethodRevision_XPATH");
			MywaitpresenceOfElementLocated("GoldSellMethodSearchRevision_XPATH");
			click("GoldSellMethodSearchRevision_XPATH");
			type("GoldSellMethodSearchRevision_XPATH", data.get("CertType"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}

		
		if(!data.get("ItemNo").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("GoldItemNoRevision_XPATH");
			click("GoldItemNoRevision_XPATH");
			type("GoldItemNoRevision_XPATH", data.get("ItemNo"));
			presstab();
		}
		
		if(!data.get("RecordingID").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("GoldRecordingIDRevision_XPATH");
			click("GoldRecordingIDRevision_XPATH");
			type("GoldRecordingIDRevision_XPATH", data.get("RecordingID"));
			presstab();
		}
		
		MywaitpresenceOfElementLocated("GoldListingSearch_XPATH");
		click("GoldListingSearch_XPATH");
		
		MywaitinvisibilityOfElementLocated("3lineloader_CSS");
		MywaitpresenceOfElementLocated("RevisionTableRow1_XPATH");
		click("RevisionTableRow1_XPATH");
		Thread.sleep(1000);
		click("RevisePriceBtn_XPATH");
	}

}
