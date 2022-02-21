package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

/**
 * This class has the methods required to establish data base connectivity
 * @author Akash
 *
 */
public class DatabaseUtility {
		
		public Connection con;
		/**
		 * This is generic method to connect to db
		 * @throws Throwable
		 */
		public void connectToDb() throws Throwable
		{
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			con= DriverManager.getConnection(IConstants.dbURL, IConstants.dbUserName, IConstants.dbPassword);
		}
		/**
		 * This method will execute the the query and verify data in database
		 * @param query
		 * @param columnIndex
		 * @param expData
		 * @return String
		 * @throws Throwable
		 */
		public String executeQueryAndGetData(String query, int columnIndex, String expData ) throws Throwable
		{
			ResultSet result = con.createStatement().executeQuery(query);
			boolean flag= false;
			while(result.next())
			{
				String data = result.getString(columnIndex);
				if(data.equalsIgnoreCase(expData))
				{
					flag= true; //raising flag
					break;
				}
			}
			if(flag)
			{
				System.out.println(expData+" data found in db");
				return expData;
			}
			else
			{
				System.out.println("data not present");
				return "";
			}
		}
		/**
		 * This is generic method to close db connection
		 * @throws Throwable
		 */
		public void closeDbConnection() throws Throwable
		{
			con.close();
		}
	}


