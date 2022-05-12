package RegressionTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class testNGFlow {

	
	@Test
	  public void Registration() {
		  System.out.println("in method B");
	  }
	
	@Parameters({"p_username","p_password"})
	@Test (dependsOnMethods="Registration")
  public void Login(String un,String pw) {
	  System.out.println("in method A un:" + un + " Password:" +pw);
  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("******Before method");
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
  
	  System.out.println("*****After method");
	
  }

  @BeforeClass
  public void beforeClass() {
  
	  System.out.println("Before Class---------------");
	  
  }

  @AfterClass
  public void afterClass() {
  
	  System.out.println("After Class------------------");
	  
  }

  @BeforeTest
  public void beforeTest() {
	  
	  System.out.println("***********************Before Test set");
	  
	  
  }

  @AfterTest
  public void afterTest() {
  
	  System.out.println("***********************After Test set");
	  
  
  }

  @BeforeSuite
  public void beforeSuite() {
	  
	  System.out.println("----Before Test suite---");
	  
  }

  @AfterSuite
  public void afterSuite() {
	  
	  System.out.println("----After Test suite----");
	  
  }

}
