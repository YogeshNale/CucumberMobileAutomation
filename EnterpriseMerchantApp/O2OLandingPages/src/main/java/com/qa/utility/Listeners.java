package com.qa.utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.TestBase.TestBase;


public class Listeners extends TestBase implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		Logger log = Logger.getLogger("");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info( "Execution of Test Scenario "+result.getName()+" start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		log.info( " Test Scenario "+ result.getName()+" execute Successfully ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Logger log = Logger.getLogger("");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("This is Test Scenario :"+result.getName()+" get fail");
	//ScreenShots.takeScreenShotWhenFail();
	//	System.out.println("Screenshot taken Successfully"+result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Logger log = Logger.getLogger("");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("This is Test Scenario :"+result.getName()+" get Skip");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
			driver.quit();
	
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}


 

}
