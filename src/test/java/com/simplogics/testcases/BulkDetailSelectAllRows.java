package com.simplogics.testcases;
import java.awt.AWTException;
import org.testng.annotations.Test;
import com.simplogics.base.Testbase;
@Test
public class BulkDetailSelectAllRows extends Testbase {
public void bulkDetailSelectAllRows() throws AWTException, InterruptedException {
	super.timedelay();
	MywaitinvisibilityOfElementLocated("loding_CSS");
	Thread.sleep(2000);
	click("Checkboxallgroup2_CSS");
}
}