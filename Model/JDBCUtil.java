package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection connect() {
		Connection conn = null;
		try {
//			conn = DriverManager.getConnection("jdbc:mySQL://localhost:3306/studenttest", "root", "");
			String url = "jdbc:mySQL://localhost:3306/quanlysinhvien";
			String userName = "root";
			String password = "";
			
			// connect
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void disConnect(Connection conn) {
		try {
			if(conn!=null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
