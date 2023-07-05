package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import net.bytebuddy.utility.RandomString;


public class UtilityClassStudy 
{
		//wait
		public static void implicitWait(WebDriver driver, long waitTime)
		{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		Reporter.log("for test class wait", true);;
		}
		
		//screenshot
		public static void captureScreenShot(WebDriver driver,String fileName) throws
		IOException
		{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        
		  String PolicyBazzar = RandomString.make(2);
	    File dest=new File("C:\\Users\\Admin\\eclipse-workspace\\MyPolicyBazzar\\ScreenShots\\-"+fileName+PolicyBazzar+".jpg");
		FileHandler.copy(src, dest);
		Reporter.log("for tc caputring screenshot ", true);
		Reporter.log("ScreenShot Location is "+dest, true);
		}
		
		//scrolling
		public static void scrollIntoView(WebDriver driver, WebElement element)
		{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element );
		Reporter.log("for tc scrolling", true);
		}
		
		//readDataFromExcel
		public static String readDataFromExcel(int rowNum, int cellNum) throws
		EncryptedDocumentException, IOException
		{
		FileInputStream myFile= new FileInputStream("C:\\Exel data\\New data for selenium.xlsx");
		String value =
		WorkbookFactory.create(myFile).getSheet("Sheet1").getRow(rowNum).getCell(cellNum).getStringCellValue();
		Reporter.log("Read data from exelSheet", true);
		return value;

	}
		public static String readDataFromPropertyFile(String key) throws IOException
		{
		Properties prop= new Properties();
		FileInputStream myFile= new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\selenium18feb_2023project\\myProperty.properties");

		prop.load(myFile);
		String value = prop.getProperty(key);
		Reporter.log("readind data "+key+" from propertyFile", true);
		return value;
		}

	}