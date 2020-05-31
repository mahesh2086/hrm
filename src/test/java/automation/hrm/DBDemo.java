package automation.hrm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class DBDemo {

//	MySQL DB properties
	private static String DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver"; // com.mysql.jdbc.Driver
	private static String DB_URL = "jdbc:mysql://166.62.10.225:3306/SeleniumDemo";
	private static String DB_USERNAME = "mahesh";
	private static String DB_PASSWORD = "Selenium@Demo";

//  
	public static void main(String[] args) {
		Connection db_con = null;
		String QUERY = "SELECT * FROM SeleniumDemo.User_Info;";// MyGuests
		try {
			Class.forName(DB_DRIVER_CLASS);
			db_con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			Statement stmt = db_con.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
//				System.out.println("Column Label: " + rs.getMetaData().getColumnLabel(i));
//				System.out.println("Column Name : " + rs.getMetaData().getColumnName(i));
				System.out.print(rs.getMetaData().getColumnLabel(i)+"|");
			}
			System.out.println("");

			while (rs.next()) {
				/*
				 * int id = rs.getInt("id"); String firstname = rs.getString("firstname");
				 * String lastname = rs.getString("lastname"); String email =
				 * rs.getString("email"); Timestamp ts = rs.getTimestamp("reg_date");
				 * System.out.println(id +"|"+firstname+"|"+lastname+"|"+email+"|"+ts);
				 */
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					System.out.print(rs.getString(i) + "|");
				}
				System.out.println("");

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				db_con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
