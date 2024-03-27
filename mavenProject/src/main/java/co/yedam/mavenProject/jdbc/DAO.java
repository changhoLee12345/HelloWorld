package co.yedam.mavenProject.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "jsp";
	String pass = "jsp";
	public Connection conn;

	public void getConn() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
