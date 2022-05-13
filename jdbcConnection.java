package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;
   public class jdbcConnection
   {
       @SuppressWarnings("deprecation")
	public static void main (String[] args)
       {
           System.out.println("\n\n***** MySQL JDBC Connection Testing *****");
		   Connection conn = null;
           try
           {
        	   
		      java.sql.Driver d=new com.mysql.cj.jdbc.Driver();
        	   d.connect("com.mysql.cj.jdbc.Driver",null);
        	   String userName = "balamurthy";
               String password = "balamurthy";
               String url = "jdbc:MySQL://localhost:3306/sample";    
               conn = DriverManager.getConnection (url, userName, password);
               System.out.println ("\nDatabase Connection Established...");
               
               String sql = "select id,name,age,occupation from employee_table";
               java.sql.Statement stmt  = conn.createStatement();
               ResultSet rs    = stmt.executeQuery(sql);
             
              // loop through the result set
              while (rs.next()) {
                  System.out.println(rs.getString("name")+" " + rs.getInt("age") + " "  + rs.getString("occupation"));
                      
              }
          
           }
           
          catch (Exception ex)
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
                       System.out.println("\n***** Let terminate the Connection *****");
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
