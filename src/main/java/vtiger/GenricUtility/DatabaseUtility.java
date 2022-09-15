package vtiger.GenricUtility;
/**
 * This method contains all the generic method related to database
 * @author archa
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DatabaseUtility 
{
	Driver driverRef;
	Connection con= null;
	
	/**
	 * Thismethod will establish the connection with DB
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException {
		driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con= DriverManager.getConnection(ConstantsUtility.DBUrl, ConstantsUtility.DBUsername, ConstantsUtility.DBPassword);	
	}
	
	/**
	 * This method will close the DB connection
	 * @throws SQLException 
	 */
	public void closeDB() throws SQLException
	{
		con.close();
	}
	
	/**
	 * This method will execute a query and check for the expected data
	 * if the expected data o=is found, it will return the data
	 * else it will return the null.
	 * Data vaildation with resoect to database
	 * @param query
	 * @param colIdex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndVerifyTheData(String query, int colIdex, String expData) throws SQLException
	{
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String actData= result.getString(colIdex);
			if(actData.equals(expData))
			{
				flag= true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("data present "+ expData);
			return expData;
		}
		else
		{
			System.out.println("data not present ");
			return " ";
		}
	}
}
