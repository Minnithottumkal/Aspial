package com.simplogics.utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.annotations.DataProvider;

import com.simplogics.base.Testbase;

public class TestUtil extends Testbase {
	
	public static String screenshotPath;
	public static String screenshotName;

	//public static void captureScreenshot() throws IOException {

	//	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

//		Date d = new Date();
//		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpeg";
//
//		FileUtils.copyFile(scrFile,
//				new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));

//	}
	
	
	public static String getbase64() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

	}
	
	
	/*@DataProvider(name="dp1",parallel=true)
	public Object[][] getDatas() {
		Object[][] data1=new Object[2][1];
		data1[0][0]="chrome";
		data1[0][1]="firefox";
		return data1;	
			}*/

	
	
	
	
	
	

	@DataProvider(name="dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		System.out.println("rows = " + rows + "and cols = " + cols);
		System.out.println("sheetname = " + sheetName);
				
		Object[][] data = new Object[rows - 1][1];
		
		Hashtable<String,String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String,String>();
			
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
				System.out.println("rowNum = "+ rowNum);
			}

		}

		return data;

	}
	
	/*@DataProvider(name = "dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}

		return data;
	}	*/
	public static boolean isTestRunnable(String testName, excelreader excel){
		
		String sheetName="test_suite";
		int rows = excel.getRowCount(sheetName);
		
		
		for(int rNum=2; rNum<=rows; rNum++){
			
			String testCase = excel.getCellData(sheetName, "TCID", rNum);
			
			if(testCase.equalsIgnoreCase(testName)){
				
				String runmode = excel.getCellData(sheetName, "runmode", rNum);
				
				if(runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}
			
			
		}
		return false;
	}
	
}
