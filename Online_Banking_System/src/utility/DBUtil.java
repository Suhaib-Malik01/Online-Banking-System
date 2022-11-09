package utility;

import java.sql.*;

public class DBUtil {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		String url = "jdbc:mysql://localhost:3306/Bank_of_future";
		
		try(Connection connect = DriverManager.getConnection(url, "root", "Suhaib")){
			
			if(connect!=null) {
				System.out.println("Connect");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
