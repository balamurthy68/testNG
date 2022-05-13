package TestCases;

import static org.testng.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.LandingPage;
import Pages.LoginPage;
import Util.ExcelApiTest;
import junit.framework.Assert;


public class HomePageTests {
	static WebDriver driver;

	String xlFilePath = "d:\\TestData.xlsx";
    String sheetName = "Sheet1";
    ExcelApiTest eat = null;
    public LoginPage lp;
    public LandingPage landingPage;
	
    @AfterMethod()
    public void printLineAfterTestMethod()
    {
    	System.out.println("-------------------------------------");
    }
    
    @BeforeClass
	public void initialize()
	{
		  System.setProperty("webdriver.chrome.driver","d://chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.get("https://the-internet.herokuapp.com/login");
		  
		  lp = new LoginPage(driver);
		
	}

	//@Parameters({ "p_username","p_password" })
	
	/* - limited sets of login data
	 * if using excel data use excelData as the Data provider
	 */
	
	@DataProvider(name = "userData")
	public Object[][] createData1() {
	 	 return new Object[][] { { "tomsmith", "SuperSecretPassword!" }, { "tomsmith", "Test@123" }, { "testuser_2", "Test@123" }};
	}
	
	
	@DataProvider(name = "searchdata")
	public Object[][] searchdata() {
	 	 return new Object[][] { { "T Shirt" }, { "Mouse" }, { "Shoes" }};
	}
	 
	
	//TESTMETHOD
	@Test (dataProvider="excelData", groups = "apitests")
	public void login(String un,String pw) throws InterruptedException {
			boolean isLoginSuccessful;
			System.out.println("Username:" + un + " Password: " + pw);
		
			lp.typeusername(un);
			lp.typepassword(pw);
			lp.clickLoginButton();
			
			landingPage= new LandingPage(driver);
			
			String msg = landingPage.readFlashMsg();
			System.out.println("****" + un + " " + pw + " ===> " + msg);
			
			if (msg.contains("You logged into a secure area!"))
			{
				isLoginSuccessful = true;
				System.out.println("Login successful for " + un + " " + pw);
				landingPage.clickLogout();
			}
			else
			{
				System.out.println("Login unsuccessful for " + un + " " + pw);
				isLoginSuccessful = false;
			}
			driver.get("https://the-internet.herokuapp.com/login");
			
			//Assert is not required in this context
			//Assert.assertEquals(true, isLoginSuccessful);
			
			
	}
	
    @Ignore
	@Test (dataProvider="searchdata")
	public void search(String searchfor)
	{
		System.out.println("Search for:" + searchfor);
	}

	 @DataProvider(name="excelData")
	    public Object[][] userFormData() throws Exception
	    {
	        Object[][] data = getTestDataFromExcel(xlFilePath, sheetName);
	        return data;
	    }
	     
	    public Object[][] getTestDataFromExcel(String xlFilePath, String sheetName) throws Exception
	    {
	        Object[][] excelData = null;
	        eat = new ExcelApiTest(xlFilePath);
	        
	        int rows = eat.getRowCount(sheetName);
	        int columns = eat.getColumnCount(sheetName);
	                 
	        excelData = new Object[rows-1][columns];
	         
	        for(int i=1; i<rows; i++)
	        {
	            for(int j=0; j<columns; j++)
	            {
	            	
	            	excelData[i-1][j] = eat.getCellData(sheetName, j, i);
	            	
	            }
	             
	        }
	        
	        return excelData;
	    }
	
	
	    @Test
	    public void securityCheck()
	    {
	    	SoftAssert sa = new SoftAssert();
			
	    	
	    		    	
	    //check if username is visible 
	    
	    	boolean isUsernameTextVisible = lp.isUsernameATextbox();
	    	sa.assertTrue(isUsernameTextVisible);
	    	
	    //password check if password is not visible
	    	boolean isVisible = lp.isPasswordVisible();
	    	
	    	sa.assertFalse(isVisible);
	    	sa.assertAll();
	    }
	
}
