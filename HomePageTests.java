package RegressionTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Util.ExcelApiTest;


public class HomePageTests {
	static WebDriver driver;

	String xlFilePath = "d:\\TestData.xlsx";
    String sheetName = "Sheet1";
    ExcelApiTest eat = null;
    

	@BeforeClass
	public void initialize()
	{
		  System.setProperty("webdriver.chrome.driver","d://chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.get("https://the-internet.herokuapp.com/login");
		  
		
		
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
			
			System.out.println("Username:" + un + " Password: " + pw);
		
		//TODO: WRITE WEBDRIVER CODE TO LOGIN TO THE HEROKUAPP APPLICATION USING ABOVE un and pw
		// identify username - sendkeys un
			//identify password - sendkeys pw
			//identify login button -click
			//validate if logout is present or welcome text is present
			//click on logout if available
			//else reload the page
			
			
			driver.findElement(By.name("username")).clear();
			
			driver.findElement(By.name("username")).sendKeys(un);
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(pw);
			
			
			Thread.sleep(1000);
			
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
	
	
	
}
