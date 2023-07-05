package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void myFirstProgram()
  {
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.policybazaar.com/");
	  driver.manage().window().maximize();
  }
}

