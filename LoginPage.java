package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

 //This class will store all the locators and methods of Login page
 
public class LoginPage {
	
WebDriver driver;	

By username= By.id("username");
By password = By.xpath("//*[@id='password']");
By loginstatus = By.cssSelector("#flash");
By loginbutton = By.xpath("//*[@id=\"login\"]/button");


//creating parameterized constructor to initialize WebDriver reference
public LoginPage(WebDriver driver)
{
	this.driver =driver;
}


public void typeusername(String s)
{
	driver.findElement(username).sendKeys(s);
}

public void typepassword(String p) {
	driver.findElement(password).sendKeys(p);
}

public boolean isUsernameATextbox()
{
	String un = driver.findElement(username).getAttribute("type");
	System.out.println(un);
	
	if (un.equals("text"))
		 return true;
	
	else
		return false;

	
}

public boolean isPasswordVisible()
{

	String pwd = driver.findElement(password).getAttribute("type");
	System.out.println(pwd);
	
	if (pwd.equals("password"))
		 return false;
	
	else
		return true;
	
}


public boolean isUsernameboxAvailable()
{

	if (driver.findElement(username).isDisplayed()) {
		return true;
	}
	else
	{
		return false;
	}
	
	}
   public String readTitle()
   {
         return driver.getTitle();
   }

public Point  getPositionOfUsernamebox()   
{
	return driver.findElement(username).getLocation();
}

public void clickLoginButton()
{
	driver.findElement(loginbutton).click();
}

public String getLoginStatus()
{
	return driver.findElement(loginstatus).getText();
}

public boolean isUsernameVisible()
{
	System.out.println("NEW METHOD I WROTE NOW");
	return driver.findElement(username).isDisplayed();
}

}
