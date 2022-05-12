package RegressionTests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
 
public class XMLProperties 
{
  public static void main(String[] args) throws InvalidPropertiesFormatException, IOException 
  {
    String outPropertiesFile = "application.properties";
    String inXmlFile = "settings.xml";
 
    InputStream inStream = new FileInputStream(inXmlFile);      //Input XML File
    OutputStream outStream = new FileOutputStream(outPropertiesFile); //Output properties File
     
    Properties props = new Properties();
     
    //Load XML file
    props.loadFromXML(inStream);
     
    //Store to properties file
    props.store(outStream, "Converted from applicationProperties.xml");
     
    //Use properties in code
    System.out.println(props.get("username"));     
    System.out.println(props.get("password"));
    System.out.println(props.get("browser"));
    
    
  }
}