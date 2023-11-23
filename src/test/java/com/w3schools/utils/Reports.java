package com.w3schools.utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/*
 * Classes in Extent reports library
 * 
 * ExtentSparkReporter --> This is used to generate the output html file
 * ExtentReports --> This is used to generate the tests in the html file
 * ExtentTest  --> This class is used to generate logs for the test cases
 */
public class Reports {
	public static ExtentSparkReporter sparkreports;
	public static ExtentReports extentreports;
	public static ExtentTest extenttest;

	@BeforeSuite(alwaysRun = true)
	public void startreport() {
		try {
			sparkreports=new ExtentSparkReporter(System.getProperty("user.dir")+"/webAutomationReport.html");
			sparkreports.config().setReportName("W3 schools webAutomation Report");
			sparkreports.config().setDocumentTitle("Web Automation");
			sparkreports.config().setTheme(Theme.DARK);

			extentreports  = new ExtentReports();
			extentreports.attachReporter(sparkreports);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	public void setTCDesc(String testcasename) {
		try {
			extenttest=extentreports.createTest(testcasename);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	public static void reportstep(String status,String desc) {
		if(status.toUpperCase().equals("PASS")) {
			extenttest.log(Status.PASS, desc);
		}
		else if (status.toUpperCase().equals("FAIL")) {
			extenttest.log(Status.FAIL, desc);
		}
		else if(status.toUpperCase().equals("INFO")) {
			extenttest.log(Status.INFO,desc);
		}
	}
	@AfterSuite(alwaysRun = true)
	public void endreport() {
		extentreports.flush();
	}
}
