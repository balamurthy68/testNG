package RegressionTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import org.testng.annotations.Test;

public class AssertTests {
 
	
		@Test
		public void A() {
		
			
			//default assert type is hardassert
			System.out.println("**HARD ASSERT EXAMPLE Test case started ***");
			Assert.assertEquals(3, 5);
			
			
			System.out.println("hard assert continues...");
			
			Assert.assertTrue("Hello".equals("Hello"));
			
			System.out.println("*** HARD ASSERT executed successfully ***");
		
		}


	
		
		@Test
		public void B() {
		
			SoftAssert sa = new SoftAssert();
		
			System.out.println("*** SOFTASSERT EXAMPLE started ***");
			sa.assertEquals("Hello", "Hello" );
			System.out.println("soft assert allows this to be printed even if it fails....");
			sa.assertTrue("Hello".equals("Hello"), "Second soft assert");
			
			sa.assertTrue("Welcome".equals("Welcomddddde"), "Third soft assert");

			System.out.println("*** SOFT ASSERT test case two executed successfully ***");
			sa.assertAll();
		}
       
		
	}
	
	
	

