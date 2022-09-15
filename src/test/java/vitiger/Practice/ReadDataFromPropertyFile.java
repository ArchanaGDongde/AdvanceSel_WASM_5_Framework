package vitiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile 
{
	public static void main(String[] args) throws IOException {
		
		//step 1: Load the file  to file input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
	
		//step 2: create object of properties from java
		Properties pObj = new Properties();
		
		// step 3: Load the file to properties obj
		pObj.load(fis);
		
		//step 4: read the data through the key
		String Browser = pObj.getProperty("browser");
		System.out.println(Browser);

		String Url= pObj.getProperty("url");
		System.out.println(Url);
	}
}
