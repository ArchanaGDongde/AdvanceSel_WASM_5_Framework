package vtiger.GenricUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelFileUtility {
	/**
	 * This method will read data from excel sheet and return the value
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public String readDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fis= new FileInputStream(ConstantsUtility.ExcelFilePath);
	Workbook wb= WorkbookFactory.create(fis);
	Sheet s = wb.getSheet(sheet);
	Row r= s.getRow(row);
	Cell cel = r.getCell(cell);
	String value = cel.getStringCellValue();
	wb.close();
	return value;
}
/**
 * This method will return the last row number in particular sheet
 * @param sheet
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
	FileInputStream fis= new FileInputStream(ConstantsUtility.ExcelFilePath);
	Workbook wb= WorkbookFactory.create(fis);
	Sheet s = wb.getSheet(sheet);
	int lastRow= s.getLastRowNum();
	wb.close();
	return lastRow;	
}

/**
 * This method will write data into the excel sheet
 * @param sheet
 * @param row
 * @param cel
 * @param value
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public void writeDataIntoExcel(String sheet, int row, int cel, String value) throws EncryptedDocumentException, IOException {
	FileInputStream fis= new FileInputStream(ConstantsUtility.ExcelFilePath);
	Workbook wb= WorkbookFactory.create(fis);
	Sheet s = wb.getSheet(sheet);
	Row r = s.getRow(row);
	Cell cell = r.getCell(cel);
	cell.setCellValue(value);
	
	FileOutputStream fos= new FileOutputStream(ConstantsUtility.ExcelFilePath);
	wb.write(fos);
	wb.close();
}


}

