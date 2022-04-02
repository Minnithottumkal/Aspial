package com.simplogics.testcases;

import org.testng.annotations.Test;

import com.simplogics.base.Testbase;

public class StockMenuBulk extends Testbase{
	  @Test
	  public void stockMenuBulk() throws InterruptedException {
		  super.timedelay();
		  Thread.sleep(3000);
		  click("stockMenu_ID");
		  Thread.sleep(3000);
		  presenceOfElementLocated("bulklistSubmenu_ID");
		  Thread.sleep(3000);
		  
	  }
}
