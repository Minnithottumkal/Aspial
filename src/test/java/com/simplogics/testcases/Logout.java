package com.simplogics.testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class Logout extends Testbase {
  @Test
  public void logout() throws InterruptedException {
	  
	  if (!(TestUtil.isTestRunnable("logout", excel))) {

			throw new SkipException("Skipping the test " + "logout".toUpperCase() + "as the Run mode is NO");
		}
	  
	  MywaitpresenceOfElementLocated("logout_XPATH");
	  click("logout_XPATH");
	  Thread.sleep(5000);
	  
  }
  
}
