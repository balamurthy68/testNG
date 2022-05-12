package RegressionTests;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Util.RegularExpressions;

public class TimeFormatTest {
	  static WebDriver driver;
	  
	 
		  @AfterSuite
	  public void afterSuite() {
		  
		  driver.close();
	  }
	
	  
	  @Parameters({"browser"})
		   
	@Test(groups="functest")
	
	public void regExCheck(String browsertype) {
		  System.out.println("BROWSER:" + browsertype);
		  
		  if (browsertype.equals("chrome"))
		  {	  
			  System.setProperty("webdriver.chrome.driver","d://chromedriver.exe");
				
			  driver = new ChromeDriver();
		  }
		  else
		  {
			  System.setProperty("webdriver.gecko.driver","d://geckodriver.exe");
				
			  driver = new FirefoxDriver();
		  }
		  
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.get("http://www.timeanddate.com");
		  
	
	
		  
		  
		  //get the time in hh:mm:ss format in the string exampleString

			//clk_hm,clk_s
		
			String hhmm = driver.findElement(By.id("clk_hm")).getText();
			String ss = driver.findElement(By.id("clk_s")).getText();
			RegularExpressions re=new RegularExpressions();
			//time display
			Pattern p = Pattern.compile("[0-9]{2}:[0-9]{2}:[0-9]{2}");
			String exampleString = hhmm +  ss;
			boolean match = re.patternMatch(exampleString, p);
			
			Reporter.log("Output from TimeFormatchecker " + exampleString );
			
			Assert.assertEquals(true, match);
		
		}
  }

