package com.simplogics.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class WatchPriceRecording extends Testbase{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
public void watchPriceRecording(Hashtable<String, String>data) throws  InterruptedException, AWTException {
		

		if (!(TestUtil.isTestRunnable("WatchPriceRecording", excel))) {

			throw new SkipException("Skipping the test " + "WatchPriceRecording".toUpperCase() + "as the Run mode is NO");
		}
		
		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		
		MywaitpresenceOfElementLocated("WatchLinkRecording_XPATH");
		click("WatchLinkRecording_XPATH");
		
		
		if(!data.get("Subgroup1").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("WatchSubgroup1Recording_XPATH");
			click("WatchSubgroup1Recording_XPATH");
			MywaitpresenceOfElementLocated("WatchSubgroup1SearchRecording_XPATH");
			elementtobeclickable("WatchSubgroup1SearchRecording_XPATH");
			type("WatchSubgroup1SearchRecording_XPATH", data.get("Subgroup1"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(4000);
		}
		
		if(!data.get("Subgroup2").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("WatchSubgroup2Recording_XPATH");
			elementtobeclickable("WatchSubgroup2Recording_XPATH");
			MywaitpresenceOfElementLocated("WatchSubgroup2SearchRecording_XPATH");
			click("WatchSubgroup2SearchRecording_XPATH");
			type("WatchSubgroup2SearchRecording_XPATH", data.get("Subgroup2"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Subgroup3").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("WatchSubgroup3Recording_XPATH");
			elementtobeclickable("WatchSubgroup3Recording_XPATH");
			MywaitpresenceOfElementLocated("WatchSubgroup3SearchRecording_XPATH");
			click("WatchSubgroup3SearchRecording_XPATH");
			type("WatchSubgroup3SearchRecording_XPATH", data.get("Subgroup3"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Model").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchModelRecording_XPATH");
			click("WatchModelRecording_XPATH");
			type("WatchModelRecording_XPATH", data.get("Model"));
			presstab();
		}
		
		if(!data.get("Version").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchVersionRecording_XPATH");
			click("WatchVersionRecording_XPATH");
			type("WatchVersionRecording_XPATH", data.get("Version"));
			presstab();
		}
		
		if(!data.get("Config").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchConfigRecording_XPATH");
			click("WatchConfigRecording_XPATH");
			type("WatchConfigRecording_XPATH", data.get("Config"));
			presstab();
		}
		
		if(!data.get("Category").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("WatchCategoryRecording_XPATH");
			elementtobeclickable("WatchCategoryRecording_XPATH");
			MywaitpresenceOfElementLocated("WatchCategorySearchRecording_XPATH");
			click("WatchCategorySearchRecording_XPATH");
			type("WatchCategorySearchRecording_XPATH", data.get("Category"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Collection").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("WatchCollectionRecording_XPATH");
			elementtobeclickable("WatchCollectionRecording_XPATH");
			MywaitpresenceOfElementLocated("WatchCollectionSearchRecording_XPATH");
			click("WatchCollectionSearchRecording_XPATH");
			type("WatchCollectionSearchRecording_XPATH", data.get("Collection"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("ModelNo").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("WatchModelNoRecording_XPATH");
			click("WatchModelNoRecording_XPATH");
			type("WatchModelNoRecording_XPATH", data.get("ModelNo"));
			presstab();
		}
		
//		if(!data.get("ActiveStock").equals("") && data.get("runmode").equals("Y"))
//		{
//			MywaitpresenceOfElementLocated("BagActiveStockCheckboxRecording_XPATH");
//			click("BagActiveStockCheckboxRecording_XPATH");
//		}
//		
//		if(!data.get("PriceRecording").equals("") && data.get("runmode").equals("Y"))
//		{
//			MywaitpresenceOfElementLocated("BagPriceRecordingCheckbox_XPATH");
//			click("BagPriceRecordingCheckbox_XPATH");
//		}
		
		click("WatchRecordingSearchBtn_XPATH");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		MywaitinvisibilityOfElementLocated("3lineloader_CSS");
		MywaitpresenceOfElementLocated("TableRow1_XPATH");
		click("TableRow1_XPATH");
		
	}

}
