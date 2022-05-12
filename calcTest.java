package RegressionTests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import Util.Calculator;




public class calcTest {
	
	
	
	@BeforeClass()	
 public void ac()
 {
	 System.out.println("before secondclass");
 }
 
 @AfterClass()	
 public void ac1()
 {
	 System.out.println("After secondclass");
 }

 
	
 @Test(groups ="apitests")
  public void calcTestadd() {
		Calculator c = new Calculator("Scientific");
		
		int actualval = c.add(10, 20);
		
		int expectedval = 30;

		System.out.println("In calcTest expected:"  + expectedval + " Actual:" + actualval);
		Assert.assertEquals(actualval, expectedval);
	  }
}
