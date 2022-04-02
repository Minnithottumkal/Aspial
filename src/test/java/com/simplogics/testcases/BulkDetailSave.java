package com.simplogics.testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
@Test
public class BulkDetailSave extends Testbase {
public void bulkDetailSave() throws AWTException, InterruptedException {
	Thread.sleep(3000);
	click("Bulkdetailsavebtn_XPATH");
	MywaitinvisibilityOfElementLocated("loader_CSS");
}
}