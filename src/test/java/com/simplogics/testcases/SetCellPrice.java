package com.simplogics.testcases;

import java.awt.AWTException;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import com.simplogics.base.Testbase;

@Test
public class SetCellPrice extends Testbase {
	public void setCellPrice() throws AWTException, InterruptedException {
		isElementPresent(By.cssSelector("checkbox1_XPATH"));

		Thread.sleep(4000);
		for (int i = 2; i <= 11; i++) {
			driver.findElement(By.xpath(
					"//div[@id=\'l1-0-b4-b2-b1-datagrid_autogenerate\']/div[2]/div/div/div/div[2]/div[" + i + "]"))
					.click();
			// click("cellitem_XPATH");
		}
		click("Activestate_CSS");
		doubleclick("Activestate1_CSS");
		type("Activestate1_CSS", "100");
		/*rightclick("Activestate1_CSS");
		click("Copyrow_CSS");
		click("sellpricecheckbox_ID");
		click("Confirm_CSS");*/
		
		// click("checkbox1_XPATH");
		// click("Checkboxallgroup2_CSS");

	}
}