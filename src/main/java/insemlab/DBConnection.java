package insemlab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	// Using singleton pattern
	
	private static Connection con = null;
	private DBConnection() {
		// private constructor to ensure only 1 instance can be created.
	}
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if(con == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/insem", "root", "SuryaTeja@9192");
		}
		return con;
	}

}
