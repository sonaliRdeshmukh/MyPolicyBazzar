package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import utility.UtilityClassStudy;

public class BaseClass 
{
	static protected WebDriver driver;
     


public void openbrowseStudy()

{
	driver=new ChromeDriver();
	driver.get("https://www.policybazaar.com/");
	driver.manage().window().maximize();
	Reporter.log("opening the policy bazzar applocation", true);
}

public void launchBrowserUsingPropertyFile() throws IOException
{
driver= new ChromeDriver();
driver.manage().window().maximize();
driver.get(UtilityClassStudy.readDataFromPropertyFile("url"));
Reporter.log("Launching browser", true);
}

public void closebrowserStudy()
{
	Reporter.log("for close the browser", true);
	driver.quit();
}
}

