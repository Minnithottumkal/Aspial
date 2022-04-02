package com.simplogics.testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class ItemListingMenu extends Testbase {
	
	@Test
	public void itemListingMenu() throws InterruptedException {
		
		if (!(TestUtil.isTestRunnable("itemListingMenu", excel))) {

			throw new SkipException("Skipping the test " + "itemListingMenu".toUpperCase() + "as the Run mode is NO");
		}
		
		MywaitpresenceOfElementLocated("stockmenu_CSS");
		click("stockmenu_CSS");
		MywaitpresenceOfElementLocated("ItemListingSubMenu_XPATH");
		click("ItemListingSubMenu_XPATH");
	}

}
