package vtiger.GenricUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
/**
 * This method will read the specific key value from the property file  
 * @param key
 * @return
 * @throws IOException
 */
	public String readDataFormatPropertyFile(String key) throws IOException {
		FileInputStream fis= new FileInputStream(ConstantsUtility.PropertyfilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
}
