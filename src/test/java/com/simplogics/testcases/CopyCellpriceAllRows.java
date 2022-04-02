package com.simplogics.testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
@Test
public class CopyCellpriceAllRows extends Testbase  {
	public void copyCellpriceAllRows() throws AWTException, InterruptedException {
	Thread.sleep(3000);
	rightclick("Activestate1_CSS");
	click("Copyrow_CSS");
	click("sellpricecheckbox_ID");
	click("Confirm_CSS");
	
}
}