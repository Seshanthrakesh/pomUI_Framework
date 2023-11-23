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
	public static ExtentSparkReporter sparkReports;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;

	@BeforeSuite(alwaysRun = true)
	public void startreport() {
		try {
			sparkReports=new ExtentSparkReporter(System.getProperty("user.dir")+"/webAutomationReport.html");
			sparkReports.config().setReportName("W3 schools webAutomation Report");
			sparkReports.config().setDocumentTitle("Web Automation");
			sparkReports.config().setTheme(Theme.DARK);

			extentReports  = new ExtentReports();
			extentReports.attachReporter(sparkReports);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	public void setTCDesc(String testcasename) {
		try {
			extentTest=extentReports.createTest(testcasename);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	public static void reportstep(String status,String desc) {
		if(status.toUpperCase().equals("PASS")) {
			extentTest.log(Status.PASS, desc);
		}
		else if (status.toUpperCase().equals("FAIL")) {
			extentTest.log(Status.FAIL, desc);
		}
		else if(status.toUpperCase().equals("INFO")) {
			extentTest.log(Status.INFO,desc);
		}
	}
	@AfterSuite(alwaysRun = true)
	public void endreport() {
		extentReports.flush();
	}
}
