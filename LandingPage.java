package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

 //This class will store all the locators and methods of Login page
 
public class LandingPage {
	
WebDriver driver;	

By flashmsg = By.id("flash");
By logoutbutton = By.linkText("Logout");


//creating parameterized constructor to initialize WebDriver reference
public LandingPage(WebDriver driver)
{
	this.driver =driver;
}

	public String readFlashMsg()
	{

		String m = driver.findElement(flashmsg).getText();
		
		return m;


	}
	
	public void clickLogout ()
	{
		
		
	   driver.findElement(logoutbutton).click();
		
		
	}
	
}