package automation.hrm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL_Demo {

	static String server = "166.62.10.225";
	static String Port = "3306";
	static String Username = "mahesh";
	static String Password = "Selenium@Demo";
	static String Database = "SeleniumDemo";
	static String Table1 = "MyGuests";
	static String Table2 = "User_Info";
	static String mysql_class_name = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) {
		String url = "jdbc:mysql://" + server + ":" + Port + "/" + Database;
		Connection con;
		String q = "SELECT * FROM SeleniumDemo.User_Info;";
		try {
			Class.forName(mysql_class_name);
			con = DriverManager.getConnection(url, Username, Password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(q);

			int c_count = rs.getMetaData().getColumnCount();
			System.out.println("Column Count: " + c_count);

			while (rs.next()) {

				for (int i = 1; i <= c_count; i++) {
					System.out.print(rs.getString(i) + "|");
				}
				System.out.println("");

			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

//		System.out.println(url);
	}

}
