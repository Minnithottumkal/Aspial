package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.simplogics.base.Testbase;
import com.simplogics.utilities.ExtentManager;
import com.simplogics.utilities.TestUtil;

public class ReloginEnitityPopup extends Testbase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void reloginEnitityPopup(Hashtable<String, String> data) throws InterruptedException, AWTException {

		if (!(TestUtil.isTestRunnable("reloginEnitityPopup", excel))) {

			throw new SkipException(
					"Skipping the test " + "reloginEnitityPopup".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {
			ExtentManager.logger.log(Status.SKIP, "Skipped Entity is: " + data.get("Entity"));
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		
		Thread.sleep(3000);
		
		if(data.get("runmode").equals("Y") && data.get("Entity")!="")
		{
			MywaitpresenceOfElementLocated("entity1_CSS");
			Thread.sleep(3000);
			entitySelection(data.get("Entity"));
		}
		
		
		Thread.sleep(1000);
		SubaccountSelection(data.get("Subaccount"));

	}

}
