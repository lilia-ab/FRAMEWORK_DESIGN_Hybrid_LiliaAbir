package com.MyListeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Utilities.ExtentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

public class Listeners implements ITestListener{
	public ExtentReports extentReport;
	public ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {
		try {
			extentReport = ExtentReport.generateExtentReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		System.out.println(testName + "----> Project Execution Started");
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName + "--> started executing");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getTestName();
		extentTest.log(Status.PASS, testName + "--> started executing");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getTestName();
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\test-output\\ScreenShots\\" + testName + ".png";
		
		try {
			FileHandler.copy(source, new File(destinationFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		extentTest.addScreenCaptureFromPath(destinationFile);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName +  "got failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getTestName();
		extentTest.log(Status.SKIP, testName + "--> started executing");
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReporter\\extentreporter.html";
		File extentReport = new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
