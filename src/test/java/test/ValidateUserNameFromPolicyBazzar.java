package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pom.LoginPage;
import pom.MyAccountPage;
import utility.UtilityClassStudy;

//@Listeners(testPolicyBazzar.Listener.class)
public class ValidateUserNameFromPolicyBazzar extends BaseClass
{   
  LoginPage login;
  MyAccountPage myacc;
    

	@BeforeClass
	public void lunchPolicyBazzar()
	{
	openbrowseStudy();
	login=new LoginPage(driver);
	  myacc=new MyAccountPage(driver);
	}
	@BeforeMethod
	
	public void logintoPolicybazzar() throws EncryptedDocumentException, IOException
	{
		UtilityClassStudy.implicitWait(driver,1000);
		login.ClickOnHomesignInButton();
		UtilityClassStudy.implicitWait(driver,1000);
		Reporter.log("Click on Home page  sign in button2", true);

		login.ClickOnMobileNumber(UtilityClassStudy.readDataFromExcel(0,1));
		UtilityClassStudy.implicitWait(driver,1000);
		Reporter.log("Enter the MobileNumber", true);

		login.ClickonSingInWithPassword();
		UtilityClassStudy.implicitWait(driver,1000);
		Reporter.log("Click on SingInWithPassword button", true);


		login.enterPassword(UtilityClassStudy.readDataFromExcel(0,2));
		UtilityClassStudy.implicitWait(driver,1000);
		Reporter.log("Enter the password", true);

		
		login.ClickonPasswordsingInbutton2();
		UtilityClassStudy.implicitWait(driver,1000);
		Reporter.log("Click on pawword  sign in button2", true);


		login.ClickOnmyAccountButton();
		UtilityClassStudy.implicitWait(driver,1000);
		Reporter.log("Click on my account button", true);


		login.ClickOnmyProfileButton();
		Reporter.log("Click on my profile button", true);

		Set<String> allwindowId = driver.getWindowHandles();
		List<String> l=new  ArrayList<>(allwindowId);
		//String mainpageId = l.get(0);
		String childpageid = l.get(1);
	    
	  driver.switchTo().window(childpageid);
		UtilityClassStudy.implicitWait(driver,1000);

			
	}
	
  @Test
  public void validateUserName() throws EncryptedDocumentException, IOException 
  {
	  String ExpectedUn =UtilityClassStudy.readDataFromExcel(0,0 );
	  String ActualUn = myacc.getActualUserName1();
	  
	  Assert.assertEquals(ExpectedUn, ActualUn,"Expectun and actualun is not match test case is fail");
  }
  @AfterMethod
  public void logoutpolicyBazzar()
  {
	  Reporter.log("logout from policyBazzar",true);
	  myacc.ClickOnlogOut();
  }
  @AfterClass
  public void closePolicyBazzar()
  {
	  Reporter.log("Close the Policy Bazzar&broswer",true);
	  closebrowserStudy();
  } 
  
}


