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

public class BagPriceRecording  extends Testbase{

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
public void bagPriceRecording(Hashtable<String, String>data) throws  InterruptedException, AWTException {
		

		if (!(TestUtil.isTestRunnable("BagPriceRecording", excel))) {

			throw new SkipException("Skipping the test " + "BagPriceRecording".toUpperCase() + "as the Run mode is NO");
		}
		
		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		
		MywaitpresenceOfElementLocated("BagLinkRecording_XPATH");
		click("BagLinkRecording_XPATH");
		
		
		if(!data.get("Subgroup1").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("BagSubgroup1Recording_XPATH");
			click("BagSubgroup1Recording_XPATH");
			MywaitpresenceOfElementLocated("BagSubgroup1SearchRecording_XPATH");
			elementtobeclickable("BagSubgroup1SearchRecording_XPATH");
			type("BagSubgroup1SearchRecording_XPATH", data.get("Subgroup1"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(4000);
		}
		
		if(!data.get("Subgroup2").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("BagSubgroup2Recording_XPATH");
			elementtobeclickable("BagSubgroup2Recording_XPATH");
			MywaitpresenceOfElementLocated("BagSubgroup2SearchRecording_XPATH");
			click("BagSubgroup2SearchRecording_XPATH");
			type("BagSubgroup2SearchRecording_XPATH", data.get("Subgroup2"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Subgroup3").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("BagSubgroup3Recording_XPATH");
			elementtobeclickable("BagSubgroup3Recording_XPATH");
			MywaitpresenceOfElementLocated("BagSubgroup3SearchRecording_XPATH");
			click("BagSubgroup3SearchRecording_XPATH");
			type("BagSubgroup3SearchRecording_XPATH", data.get("Subgroup3"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Model").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagModelRecording_XPATH");
			click("BagModelRecording_XPATH");
			type("BagModelRecording_XPATH", data.get("Model"));
			presstab();
		}
		
		if(!data.get("Version").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagVersionRecording_XPATH");
			click("BagVersionRecording_XPATH");
			type("BagVersionRecording_XPATH", data.get("Version"));
			presstab();
		}
		
		if(!data.get("Config").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagConfigRecording_XPATH");
			click("BagConfigRecording_XPATH");
			type("BagConfigRecording_XPATH", data.get("Config"));
			presstab();
		}
		
		if(!data.get("Category").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("BagCategoryRecording_XPATH");
			elementtobeclickable("BagCategoryRecording_XPATH");
			MywaitpresenceOfElementLocated("BagCategorySearchRecording_XPATH");
			click("BagCategorySearchRecording_XPATH");
			type("BagCategorySearchRecording_XPATH", data.get("Category"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Collection").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitvisibilityOfElementLocated("BagCollectionRecording_XPATH");
			elementtobeclickable("BagCollectionRecording_XPATH");
			MywaitpresenceOfElementLocated("BagCollectionSearchRecording_XPATH");
			click("BagCollectionSearchRecording_XPATH");
			type("BagCollectionSearchRecording_XPATH", data.get("Collection"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Size").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagSizeRecording_XPATH");
			elementtobeclickable("BagSizeRecording_XPATH");
			MywaitpresenceOfElementLocated("BagSizeSearchRecording_XPATH");
			click("BagSizeSearchRecording_XPATH");
			type("BagSizeSearchRecording_XPATH", data.get("Size"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("Material").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagMaterialRecording_XPATH");
			elementtobeclickable("BagMaterialRecording_XPATH");
			MywaitpresenceOfElementLocated("BagMaterialSearchRecording_XPATH");
			click("BagMaterialSearchRecording_XPATH");
			type("BagMaterialSearchRecording_XPATH", data.get("Material"));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			presstab();
			Thread.sleep(2000);
		}
		
		if(!data.get("ModelNo").equals("") && data.get("runmode").equals("Y"))
		{
			MywaitpresenceOfElementLocated("BagModelNoRecording_XPATH");
			click("BagModelNoRecording_XPATH");
			type("BagModelNoRecording_XPATH", data.get("ModelNo"));
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
		
		presenceOfElementLocated("PriceSearchBtn_XPATH");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		MywaitinvisibilityOfElementLocated("3lineloader_CSS");
		MywaitpresenceOfElementLocated("TableRow1_XPATH");
		click("TableRow1_XPATH");
		
	}

}
