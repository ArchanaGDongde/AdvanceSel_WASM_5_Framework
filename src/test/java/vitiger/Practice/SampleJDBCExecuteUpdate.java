package vitiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		Driver driverRef= new Driver();
		
		//1:
		DriverManager.registerDriver(driverRef);
		
		//2:
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		
		
		//3:
		Statement statement = con.createStatement();
	
		//4:
		String query = "insert into customerinfo values('Neel', 12, 'Hubballi')";
		
		int result= statement.executeUpdate(query);
		if(result==1) 
		{
			System.out.println("the data is inserted");
		}
		if(result==2) 
		{
			System.out.println("the data is not inserted");
		}
		//5:
		con.close();
	}
	
}
