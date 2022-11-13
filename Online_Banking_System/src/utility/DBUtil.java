package utility;

import java.sql.*;

public class DBUtil {
	public static Connection provideConnection() {
		Connection connect = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		String url = "jdbc:mysql://localhost:3306/Bank_of_future";
		
		try{
			connect = DriverManager.getConnection(url, "root", "Suhaib");
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return connect;
		
	}

}
