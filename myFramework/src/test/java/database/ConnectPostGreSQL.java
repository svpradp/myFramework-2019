package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectPostGreSQL {
	
	private static Connection connection = null;
	
	public Connection connectDB(String url, String dbname, String port, String username, String password) throws Exception
	{		
		
		String conn = "jdbc:postgresql://" + url + ":" + port + "/" + dbname;

	//Class.forName("org.sqlite.JDBC")

	//String connectionString = "jdbc:sqlite:" + dataFile

	if(connection!= null && !connection.isClosed())
	{

		connection.close();

	}

	connection = DriverManager.getConnection(conn, username, password);

	return connection;
			
	}
}
