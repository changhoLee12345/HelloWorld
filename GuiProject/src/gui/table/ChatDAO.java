package gui.table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChatDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	public ChatDAO() {

	}

	public void conn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.14:1521:xe", "hr", "hr");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void disconn() {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		if (psmt != null)
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public List<Employee> getList() {
		conn();
		List<Employee> list = new ArrayList<>();
		String sql = "select * from employees order by 1";
		try {
			conn.setAutoCommit(false);
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Employee vo = new Employee(rs.getInt("employee_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("email"), rs.getString("job_id"),
						rs.getString("hire_date"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

//	public boolean addChat(Employee vo) {
//		conn();
//		String sql = "insert into chatting(seq, content, writer, creation_date) values(chat_seq.nextval,?,?,sysdate)";
//
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, vo.getContent());
//			psmt.setString(2, vo.getWriter());
//			psmt.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			disconn();
//		}
//		return false;
//	}
}
