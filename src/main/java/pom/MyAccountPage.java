package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage
{

	//variable 
	 @FindBy(xpath="//div[@class='textCapitalize sc-ckVGcZ kWpXlQ']") private WebElement validateusername;
	 @FindBy(className = "h_l") private WebElement logOutButtton;
	  //contructor
	  public MyAccountPage(WebDriver driver)
	  {
		 PageFactory.initElements(driver, this); 
	  }
	  public String getActualUserName1()
	  {
		   String actualUsername=validateusername.getText();
		  return actualUsername;
		  
		  }
	  public void ClickOnlogOut()
	  {
		 logOutButtton.click();
	  }
	
	}
		 
	  
	


