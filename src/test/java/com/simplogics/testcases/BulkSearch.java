package com.simplogics.testcases;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;
@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
public class BulkSearch  extends Testbase {
	public void Bulksearch(Hashtable<String, String> data) {
	if (!(TestUtil.isTestRunnable("Bulksearch", excel))) {

		throw new SkipException(
				"Skipping the test " + "Bulksearch".toUpperCase() + "as the Run mode is NO");
	}
	MywaitpresenceOfElementLocated("stockmenu_CSS");
	click("stockmenu_CSS");
	MywaitvisibilityOfElementLocated("Bulklistingstockmenu_ID");
	click("Bulklistingstockmenu_ID");
	MywaitpresenceOfElementLocated("Searchbox_ID");
	type("Searchbox_ID", data.get("DocRefNo"));
	click("Searchbutton_XPATH");
	MywaitpresenceOfElementLocated("SearchItem_CSS");
//	click("SearchItem_CSS");
	
	WebElement e = driver.findElement(By.xpath("//*[@id=\"b8-b2-Placeholder1\"]/div/table"));
	List<WebElement> list = e.findElements(By.tagName("tr"));
	int n = list.size() - 1;
	driver.findElement(By.cssSelector("#b8-b2-Placeholder1 > div > table > tbody > tr:nth-child(" + n + " )")).click();
	
//	MywaitinvisibilityOfElementLocated("3lineloader_CSS");
	MywaitinvisibilityOfElementLocated("loding_CSS");
	System.out.println("Detail Page completely Loaded");
	

}
}