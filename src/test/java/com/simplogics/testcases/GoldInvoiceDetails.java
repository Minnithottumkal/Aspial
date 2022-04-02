package com.simplogics.testcases;

import java.awt.AWTException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.simplogics.base.Testbase;
import com.simplogics.utilities.TestUtil;

public class GoldInvoiceDetails extends Testbase {
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")

	public void goldInvoiceDetails(Hashtable<String, String> data) throws InterruptedException, AWTException {

		System.out.println("excel path" + excel.path.toString());

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");

		}

		System.out.println("run mode of bag invoice details  " + data.get("runmode").toString());
		super.timedelay();
		elementtobeclickable("CreatebagAddrowbtn_XPATH");
		super.timedelay();
		Thread.sleep(5000);
		// elementtobeclickable("CreatebagAddrowftcol_XPATH");
		// click("CreatebagAddrowfirstcol_XPATH");
		// System.out.println("clicked first column");
		type("CreatebagAddrowftcol_XPATH", data.get("SupplierPatternCode"));

		// WebElement
		// currentcolumn=driver.findElement(By.xpath("//*[@id=\"b10-datagrid_autogenerate\"]/div[3]/div/div[1]/div[1]/div[2]/div[1]"));
		// currentcolumn.sendKeys(Keys.TAB);
		presstab();
		type("CreatebagAddrowsecondcol_XPATH", data.get("Model"));
		// WebElement
		// currentcol=driver.findElement(By.xpath("//*[@id=\"b10-datagrid_autogenerate\"]/div[3]/div/div[1]/div[1]/div[2]/div[2]"));
		// currentcol.sendKeys(Keys.TAB);
		presstab();
		type("createbagaddrowthirdcol_XPATH", data.get("Version"));
		// WebElement
		// currentcol3=driver.findElement(By.xpath("//*[@id=\"b10-datagrid_autogenerate\"]/div[3]/div/div[1]/div[1]/div[2]/div[3]"));
		// currentcol3.sendKeys(Keys.TAB);
		presstab();
		type("createbagaddrowfourthcol_XPATH", data.get("Config"));
		// WebElement
		// currentcol4=driver.findElement(By.xpath("//*[@id=\"b10-datagrid_autogenerate\"]/div[3]/div/div[1]/div[1]/div[2]/div[4]"));
		// currentcol4.sendKeys(Keys.TAB);
		presstab();
		super.timedelay();
		// WebElement
		// currentcol5=driver.findElement(By.xpath("//*[@id=\"b10-datagrid_autogenerate\"]/div[3]/div/div[1]/div[1]/div[2]/div[5]"));
		// currentcol5.sendKeys(Keys.TAB);
		presstab();
		type("createbagaddrowsixcol_XPATH", data.get("Qty"));
		WebElement currentcol6 = driver
				.findElement(By.xpath("//*[@id=\"b10-datagrid_autogenerate\"]/div[2]/div/div[1]/div[1]/div[2]/div[6]"));
		currentcol6.sendKeys(Keys.TAB);
		// presstab();
		super.timedelay();
		type("createbagaddrowsevencol_XPATH", data.get("InvoiceWt"));
		WebElement currentcol7 = driver
				.findElement(By.xpath("//*[@id=\"b10-datagrid_autogenerate\"]/div[2]/div/div[1]/div[1]/div[2]/div[7]"));
		currentcol7.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		presstab();
		presstab();
		// presstab();
		// type("createbagaddroweightcol_XPATH", data.get("Purchasedby"));
		// WebElement
		// currentcol8=driver.findElement(By.xpath("//*[@id=\"b10-datagrid_autogenerate\"]/div[2]/div/div[1]/div[1]/div[2]/div[8]"));
		// currentcol8.sendKeys(Keys.TAB);
		// WebElement
		// currentcol9=driver.findElement(By.xpath("//*[@id=\"b10-datagrid_autogenerate\"]/div[2]/div/div[1]/div[1]/div[2]/div[8]"));
		// currentcol9.sendKeys(Keys.TAB);
		// presstab();
		// WebElement
		// currentcol10=driver.findElement(By.xpath("//*[@id=\"b10-datagrid_autogenerate\"]/div[2]/div/div[1]/div[1]/div[2]/div[8]"));
		// currentcol10.sendKeys(Keys.TAB);
		type("purchasedby_XPATH", data.get("Purchasedby"));
		super.timedelay();
		presstab();
		presstab();
		presstab();
		presstab();
		presstab();
		type("invoiceCost_XPATH", data.get("InvoiceCost"));
		// WebElement
		// currentcol9=driver.findElement(By.xpath("//*[@id=\"b10-datagrid_autogenerate\"]/div[2]/div/div[1]/div[1]/div[2]/div[9]"));
		// currentcol9.sendKeys(Keys.TAB);

		super.timedelay();
		Thread.sleep(9000);

	}
}
