package test;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.BaseClass;
import utility.UtilityClassStudy;

public class Listener extends BaseClass implements ITestListener
{
	
	
		public void onTestSuccess(ITestResult result)
		{
		String TCname = result.getName();
		Reporter.log("This "+TCname+" method completed successfully", true);
		}
		public void onTestFailure(ITestResult result)
		{
			try {
				UtilityClassStudy.captureScreenShot(driver, result.getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Reporter.log("This "+result.getName()+ " method is Failed, pl try again", true);
		}
		public void onTestStart(ITestResult result)
		{
		Reporter.log("Test "+result.getName()+" execution started..", true);
		}
		public void onTestSkipped(ITestResult result)
		{
		Reporter.log("This TC "+result.getName()+" is skipped..pl check dependent method",
		true);
}
}


