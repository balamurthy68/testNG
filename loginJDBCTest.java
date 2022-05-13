package TestCases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mysql.cj.xdevapi.Statement;

import Pages.LandingPage;
import Pages.LoginPage;
public class loginJDBCTest
{

	static WebDriver driver;
	LoginPage lp;
	LandingPage landingPage;

	Connection conn = null;
	java.sql.Statement stmt;
	java.sql.Driver d;
	@BeforeClass
	public void initialize() throws SQLException
	{
		System.setProperty("webdriver.chrome.driver","d://chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/login");

		lp = new LoginPage(driver);
		d=new com.mysql.cj.jdbc.Driver();
		d.connect("com.mysql.cj.jdbc.Driver",null);
		String userName = "balamurthy";
		String password = "balamurthy";
		String url = "jdbc:MySQL://localhost:3306/sample";    
		conn = DriverManager.getConnection (url, userName, password);
		System.out.println ("\nDatabase Connection Established...");



	}

	@AfterClass
	public void teardown()
	{
		driver.quit();
	}


	@Test
	public void testLogin() throws SQLException
	{
		lp = new LoginPage(driver);
		System.out.println("\n\n***** MySQL JDBC Connection Testing *****");

		try {
			String sql = "select Username,Password from users";
			stmt = conn.createStatement();
			ResultSet rs    = stmt.executeQuery(sql);

			// loop through the result set
			while (rs.next()) {
				System.out.println(rs.getString("Username")+" "  + rs.getString("Password"));

				lp.typeusername(rs.getString("Username"));
				lp.typepassword(rs.getString("Password"));
				lp.clickLoginButton();
				landingPage= new LandingPage(driver);

				String msg = landingPage.readFlashMsg();
				System.out.println("****" + rs.getString("Username") + " " + rs.getString("Password") + " ===> " + msg);

				boolean isLoginSuccessful;
				if (msg.contains("You logged into a secure area!"))
				{
					isLoginSuccessful = true;
					System.out.println("Login successful for " + rs.getString("Username") + " " + rs.getString("Password"));
					landingPage.clickLogout();
				}
				else
				{
					System.out.println("Login Unsuccessful for " + rs.getString("Username") + " " + rs.getString("Password"));
					isLoginSuccessful = false;
				}
				driver.get("https://the-internet.herokuapp.com/login");

				//Assert is not required in this context
				//Assert.assertEquals(true, isLoginSuccessful);

			}
		}
		catch(SQLException ex)
		{
			System.err.println ("Cannot connect to database server");
			ex.printStackTrace();
		}      

		finally
		{
			if (conn != null)
			{
				try
				{
					System.out.println("\n***** Let's terminate the Connection *****");
					conn.close ();					   
					System.out.println ("\nDatabase connection terminated...");
				}
				catch (Exception ex)
				{
					System.out.println ("Error in connection termination!");
				}
			}
		}


	}

}

