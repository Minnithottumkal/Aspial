package com.simplogics.utilities;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.simplogics.base.Testbase;

public class ExtentManager extends Testbase{
//	public static ExtentReports extent;
	public static ExtentHtmlReporter reporter;
	public static ExtentTest logger;
	static Date dat = new Date();
	static String extentfileName;
	
	    //public static ExtentReports createInstance(String fileName) {
	    	public static void setReport() {
        //ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
	    		
	    		extentfileName = "Extent_" + dat.toString().replace(":", "_").replace(" ", "_") + ".html";
       
        reporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\reports\\"+extentfileName);
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setDocumentTitle("Automation Report of Aspial");
        reporter.config().setEncoding("utf-8");
        reporter.config().setReportName("Automation Report of Aspial");
        
        extent = new ExtentReports();
        extent.attachReporter(reporter);
//        extent.setSystemInfo("Automation Tester", "Vishnu Kalesh");
//        extent.setSystemInfo("Organization", "Simplogics Pvt Ltd");
        
        
       // return extent;
    }
	    
	    public static void endReport() {
	    	extent.flush();
			
		}
	    
	    
	    
	    
}
