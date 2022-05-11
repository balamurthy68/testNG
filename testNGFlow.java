package testNGClasses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class testNGFlow {

	@Test (priority=1)
	  public void B() {
		  System.out.println("in method B");
	  }
	@Test (priority=2)
  public void A() {
	  System.out.println("in method A");
  
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
