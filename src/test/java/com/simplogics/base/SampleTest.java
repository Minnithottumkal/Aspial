package com.simplogics.base;

import org.testng.TestNG;

import com.beust.jcommander.internal.Lists;

public class SampleTest {
	private static final String XML_PATH = "\\testng.xml";
	public static void main(String args[]) {
		//SampleTest tla = new SampleTest();
		TestNG testng = new TestNG();
		java.util.List<String> suites = Lists.newArrayList();
	    suites.add(System.getProperty("user.dir") + XML_PATH);//path to xml..
//	    suites.add("c:/tests/testng2.xml");
	    testng.setTestSuites(suites);
//		testng.setTestClasses(new Class[] { SampleTest.class });
//		testng.addListener(tla);
		testng.run();
	}

}
