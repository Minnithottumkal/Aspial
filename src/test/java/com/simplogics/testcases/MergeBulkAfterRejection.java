package com.simplogics.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class MergeBulkAfterRejection extends Testbase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void mergeBulkAfterRejection(Hashtable<String, String> data) throws InterruptedException, AWTException {

		if (!(TestUtil.isTestRunnable("mergeBulkAfterRejection", excel))) {

			throw new SkipException(
					"Skipping the test " + "mergeBulkAfterRejection".toUpperCase() + "as the Run mode is NO");
		}
		
		Thread.sleep(3000);
		System.out.println("Before aspial");
		driver.findElement(By.xpath("//img[@class=\"app-logo\"]")).click();

		MywaitpresenceOfElementLocated("Action_XPATH");
		Thread.sleep(1000);
		elementtobeclickable("Action_XPATH");
		
		MywaitinvisibilityOfElementLocated("3lineloader_CSS");
		MywaitpresenceOfElementLocated("RequestedByAcceptanceDiv_XPATH");
		click("RequestedByAcceptanceDiv_XPATH");
		MywaitpresenceOfElementLocated("RequestedBySearchAcceptance_XPATH");
		click("RequestedBySearchAcceptance_XPATH");
		type("RequestedBySearchAcceptance_XPATH", data.get("RequestedBy"));
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		click("StockSearchAcceptanceBtn_XPATH");
		Thread.sleep(3000);
		click("TableRow1Acceptance_XPATH");
		MywaitinvisibilityOfElementLocated("loding_CSS");
		Thread.sleep(3000);
		
		MywaitpresenceOfElementLocated("MergeApproveBtn_XPATH");
		click("MergeApproveBtn_XPATH");

		MywaitinvisibilityOfElementLocated("loader_CSS");
		MywaitpresenceOfElementLocated("Feedback_CSS");
		MywaitinvisibilityOfElementLocated("Feedback_CSS");
		MywaitpresenceOfElementLocated("stockmenu_CSS");
		click("stockmenu_CSS");
		MywaitvisibilityOfElementLocated("Bulklistingstockmenu_ID");
		click("Bulklistingstockmenu_ID");

		MywaitpresenceOfElementLocated("Searchbox_ID");
		type("Searchbox_ID", data.get("DocRefNo"));
		click("Searchbutton_XPATH");
		MywaitpresenceOfElementLocated("SearchItem_CSS");

		WebElement e = driver.findElement(By.xpath("//*[@id=\"b8-b2-Placeholder1\"]/div/table"));
		List<WebElement> list = e.findElements(By.tagName("tr"));
		int n = list.size() - 1;
		driver.findElement(By.cssSelector("#b8-b2-Placeholder1 > div > table > tbody > tr:nth-child(" + n + " )"))
				.click();

		MywaitinvisibilityOfElementLocated("3lineloader_CSS");
		MywaitinvisibilityOfElementLocated("loding_CSS");
		
		MywaitpresenceOfElementLocated("Bulkinfomenuicon_XPATH");
		Thread.sleep(2000);
		click("Bulkinfomenuicon_XPATH");
		timedelay();
		click("MergeBulk_XPATH");
		timedelay();
		
		MywaitinvisibilityOfElementLocated("3lineloader_CSS");
		timedelay();
		MywaitpresenceOfElementLocated("MergeBulkCheckbox1_XPATH");
		click("MergeBulkCheckbox1_XPATH");
		
		timedelay();
		click("MergeBulkConfirm_XPATH");
		
		//MywaitinvisibilityOfElementLocated("loading_CSS");
		MywaitinvisibilityOfElementLocated("3lineloader_CSS");
		MywaitpresenceOfElementLocated("Bulkinfomenuicon_XPATH");
	}

}
