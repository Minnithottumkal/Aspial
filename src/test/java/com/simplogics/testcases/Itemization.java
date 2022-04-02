package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;
import java.util.List;

import org.testng.SkipException;
import com.simplogics.utilities.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;

@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
public class Itemization extends Testbase {

	public int row_count = 0;
	List<WebElement> tb;
	List<WebElement> count;
	float qty;
	float wt;
	float cost;
	float wmcp;
    float unit_wt;
    float sp_cost;
    float wmcp_input;
    float wt_variance;
    float wmcp_variance;
    float cost_variance;
	String quantity;
	String weight;
	String Cost;
	String WMCP;
	String UnitWt;
	String SupplierCost;
	String Wt_Variance;
	String WMCP_Variance;
	String Cost_Variance;
	char c;

	public void ItemizationGoldInvoice(Hashtable<String, String> data) throws InterruptedException, AWTException {

		if (!(TestUtil.isTestRunnable("ItemizationGoldInvoice", excel))) {

			throw new SkipException(
					"Skipping the test " + "ItemizationGoldInvoice".toUpperCase() + "as the Run mode is NO");
		}
		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		if (row_count == 0) {
			MywaitpresenceOfElementLocated("GenerateItemNoHome_XPATH");
			tb = driver.findElements(By.xpath("//tbody//child::tr"));
			System.out.println("SIZE OF TABLE: " + tb.size());
			row_count++;
			System.out.println("ROW COUNT: " + row_count);
		}
		
		for (row_count = 1; row_count <= tb.size(); row_count++) {
			Thread.sleep(5000);
			
//			driver.findElement(By.xpath("(//i[contains(@class,\"fa-unlock\")])[" + row_count + "]")).click();
//			Thread.sleep(2000);
//			Alert alertmsg = driver.switchTo().alert();
//			alertmsg.accept();
//			MywaitpresenceOfElementLocated("Feedback_CSS");
//			MywaitinvisibilityOfElementLocated("Feedback_CSS");
			
			MywaitpresenceOfElementLocated("3dotMenu_XPATH");
			Thread.sleep(2000);
			driver.findElement(
					By.xpath("(//form[@id=\"Form1\"]//child::i[contains(@class,'fa-angle-right')])[" + row_count + "]"))
					.click();
			MywaitinvisibilityOfElementLocated("loader_CSS");
			MywaitpresenceOfElementLocated("BulkCheckBoxAll_XPATH");
			count = null;
			count = driver.findElements(By.xpath("//div[normalize-space()=\"Item\"]"));
			qty=0;
			wt=0;
			cost = 0;
			wmcp = 0;
			wmcp_input=0;
			quantity="";
			weight="";
			Cost="";
			WMCP="";
			
			quantity = driver.findElement(By.xpath(testfield.getProperty("ItemizationQty_XPATH"))).getText();
				qty = Float.parseFloat(quantity.replaceAll(",", ""));
				System.out.println(qty);

			
			weight = driver.findElement(By.xpath(testfield.getProperty("ItemizationWt_XPATH"))).getText();
				wt = Float.parseFloat(weight.replaceAll(",", ""));
				System.out.println(wt);
			
			Cost = driver.findElement(By.xpath(testfield.getProperty("ItemizationCost_XPATH"))).getText();
				cost = Float.parseFloat(Cost.replaceAll(",", ""));
				System.out.println(cost);
				
			WMCP = 	driver.findElement(By.xpath(testfield.getProperty("ItemizationWMCP_XPATH"))).getText();
				wmcp = Float.parseFloat(WMCP.replaceAll(",", ""));
				System.out.println(wmcp);

			Thread.sleep(3000);
			
			unit_wt = wt/qty;
			sp_cost = cost/qty;
			wmcp_input = wmcp/qty;
			
			for (int i = 1; i <= 7; i++)
				Tab("Activestate_CSS");
			click("Activestate_CSS");
			click("Activestate1_CSS");
			doubleclick("Activestate1_CSS");
			type("Activestate1_CSS", String.valueOf(unit_wt));
			Tab("Activestate1_CSS");
			Tab("Activestate_CSS");
			Tab("Activestate_CSS");
			click("Activestate_CSS");
			click("Activestate1_CSS");
			doubleclick("Activestate1_CSS");
			type("Activestate1_CSS", data.get("Sellprice"));
			Tab("Activestate1_CSS");
			Thread.sleep(2000);
			
			if(count.size() != 1)
			{
				rightclick("Activestate_CSS");
				click("Copyrow_CSS");
				click("UnitWtCheckbox_XPATH");
				click("SellPriceCheckbox_XPATH");
				click("Confirm_XPATH");
				MywaitpresenceOfElementLocated("Feedback_CSS");
				MywaitinvisibilityOfElementLocated("Feedback_CSS");
			}
			
			MywaitpresenceOfElementLocated("BulkSaveBtn_XPATH");
			click("BulkSaveBtn_XPATH");
			MywaitinvisibilityOfElementLocated("loader_CSS");
			Wt_Variance = driver.findElement(By.xpath(testfield.getProperty("WeightVariance_XPATH"))).getText();
			wt_variance = Float.parseFloat(Wt_Variance.replaceAll(",", ""));
			if(wt_variance != 0.00)
			{
				MywaitpresenceOfElementLocated("BalanceButton_XPATH");
				click("BalanceButton_XPATH");
				Thread.sleep(5000);
				MywaitpresenceOfElementLocated("DistributeWeight_XPATH");
				click("DistributeWeight_XPATH");
				MywaitpresenceOfElementLocated("DistributeWMCP_XPATH");
				click("DistributeWMCP_XPATH");
				MywaitpresenceOfElementLocated("DistributeWeight_XPATH");
				click("DistributeWeight_XPATH");
				MywaitpresenceOfElementLocated("DistributeSelectedRows_XPATH");
				click("DistributeSelectedRows_XPATH");
				MywaitpresenceOfElementLocated("RowFrom_XPATH");
				click("RowFrom_XPATH");
				type("RowFrom_XPATH", "1");
				MywaitpresenceOfElementLocated("RowTo_XPATH");
				click("RowTo_XPATH");
				type("RowTo_XPATH", "1");
				MywaitpresenceOfElementLocated("DistributeConfirm_XPATH");
				click("DistributeConfirm_XPATH");
				MywaitpresenceOfElementLocated("Feedback_CSS");
				MywaitinvisibilityOfElementLocated("Feedback_CSS");
			}
			
			MywaitpresenceOfElementLocated("BulkSaveBtn_XPATH");
			WMCP_Variance = driver.findElement(By.xpath(testfield.getProperty("WMCPVariance_XPATH"))).getText();
			wmcp_variance = Float.parseFloat(WMCP_Variance.replaceAll(",", ""));
			if(wmcp_variance != 0.00)
			{
				MywaitpresenceOfElementLocated("BalanceButton_XPATH");
				click("BalanceButton_XPATH");
				Thread.sleep(5000);
				MywaitpresenceOfElementLocated("DistributeWMCP_XPATH");
				click("DistributeWMCP_XPATH");
				MywaitpresenceOfElementLocated("DistributeWeight_XPATH");
				click("DistributeWeight_XPATH");
				MywaitpresenceOfElementLocated("DistributeWMCP_XPATH");
				click("DistributeWMCP_XPATH");
				MywaitpresenceOfElementLocated("DistributeSelectedRows_XPATH");
				click("DistributeSelectedRows_XPATH");
				MywaitpresenceOfElementLocated("RowFrom_XPATH");
				click("RowFrom_XPATH");
				type("RowFrom_XPATH", "1");
				MywaitpresenceOfElementLocated("RowTo_XPATH");
				click("RowTo_XPATH");
				type("RowTo_XPATH", "1");
				MywaitpresenceOfElementLocated("DistributeConfirm_XPATH");
				click("DistributeConfirm_XPATH");
				MywaitpresenceOfElementLocated("Feedback_CSS");
				MywaitinvisibilityOfElementLocated("Feedback_CSS");
			}
			
			MywaitpresenceOfElementLocated("BulkSaveBtn_XPATH");
			Cost_Variance = driver.findElement(By.xpath(testfield.getProperty("CostVariance_XPATH"))).getText();
			cost_variance = Float.parseFloat(Cost_Variance.replaceAll(",", ""));
			if(cost_variance != 0.00)
			{
				MywaitpresenceOfElementLocated("BalanceButton_XPATH");
				click("BalanceButton_XPATH");
				Thread.sleep(5000);
				MywaitpresenceOfElementLocated("DistributeCost_XPATH");
				click("DistributeCost_XPATH");
				MywaitpresenceOfElementLocated("DistributeWMCP_XPATH");
				click("DistributeWMCP_XPATH");
				MywaitpresenceOfElementLocated("DistributeCost_XPATH");
				click("DistributeCost_XPATH");
				MywaitpresenceOfElementLocated("DistributeSelectedRows_XPATH");
				click("DistributeSelectedRows_XPATH");
				MywaitpresenceOfElementLocated("RowFrom_XPATH");
				click("RowFrom_XPATH");
				type("RowFrom_XPATH", "1");
				MywaitpresenceOfElementLocated("RowTo_XPATH");
				click("RowTo_XPATH");
				type("RowTo_XPATH", "1");
				MywaitpresenceOfElementLocated("DistributeConfirm_XPATH");
				click("DistributeConfirm_XPATH");
				MywaitpresenceOfElementLocated("Feedback_CSS");
				MywaitinvisibilityOfElementLocated("Feedback_CSS");
			}
			
			MywaitpresenceOfElementLocated("BulkSaveBtn_XPATH");
			click("BulkSaveBtn_XPATH");
			MywaitinvisibilityOfElementLocated("loader_CSS");
//			MywaitpresenceOfElementLocated("GenerateLock_XPATH");
//			elementtobeclickable("GenerateLock_XPATH");
//			Thread.sleep(2000);
//			Alert alertmsg1 = driver.switchTo().alert();
//			alertmsg1.accept();
//			MywaitpresenceOfElementLocated("Feedback_CSS");
//			MywaitinvisibilityOfElementLocated("Feedback_CSS");
			MywaitpresenceOfElementLocated("BulkCheckBoxAll_XPATH");
			Thread.sleep(5000);
			click("BulkCheckBoxAll_XPATH");
			MywaitpresenceOfElementLocated("GenerateItemInvoiveBtn_XPATH");
			click("GenerateItemInvoiveBtn_XPATH");
			Thread.sleep(5000);
			Alert alertmsg2 = driver.switchTo().alert();
			alertmsg2.accept();
			MywaitinvisibilityOfElementLocated("loader_CSS");
			Thread.sleep(3000);
			MywaitpresenceOfElementLocated("CloseBulkPopup_XPATH");
			Thread.sleep(2000);
			click("CloseBulkPopup_XPATH");
			MywaitpresenceOfElementLocated("AddDetailsBulkBtn_XPATH");
		}

	}

}
