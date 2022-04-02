package com.simplogics.testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class InternalTransferMenuSelection extends Testbase{
	
@Test
public void internalTransferMenuSelection() throws InterruptedException {
	
	if (!(TestUtil.isTestRunnable("internalTransferMenuSelection", excel))) {

		throw new SkipException("Skipping the test " + "internalTransferMenuSelection".toUpperCase() + "as the Run mode is NO");
	}
	
	
	presenceOfElementLocated("internalTransfer_ID");
	//click("internalTransfer_ID");
}

}
