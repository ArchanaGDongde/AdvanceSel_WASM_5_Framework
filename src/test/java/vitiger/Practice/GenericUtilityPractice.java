package vitiger.Practice;

import java.io.IOException;

import vtiger.GenricUtility.ExcelFileUtility;
import vtiger.GenricUtility.JavaUtility;
import vtiger.GenricUtility.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		JavaUtility jLib= new JavaUtility();
		int ra=  jLib.getRandomNumber();
		System.out.println(ra);
		String dat = jLib.getSystemDate();
		System.out.println(dat);
		String d=jLib.getSystemDateInFormat();
		System.out.println(d);
		
		PropertyFileUtility pLib= new PropertyFileUtility();
		String b = pLib.readDataFormatPropertyFile("browser");
		System.out.println(b);
		
		ExcelFileUtility eLib= new ExcelFileUtility();
		String data= eLib.readDataFromExcel("Organization", 1, 1);
		eLib.writeDataIntoExcel("Organization", 2, 7, "archana");
		System.out.println(data);
	}

}
