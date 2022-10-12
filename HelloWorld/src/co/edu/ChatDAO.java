package co.edu;

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
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "prj", "prj");
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

	public List<ChatVO> getList() {
		conn();
		List<ChatVO> list = new ArrayList<>();
		String sql = "select * from chatting where creation_date between (sysdate - (300/24/60)) and sysdate order by seq";
		try {
			conn.setAutoCommit(false);
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ChatVO vo = new ChatVO(rs.getInt("seq"), rs.getString("content")//
						, rs.getString("writer"), rs.getDate("creation_date"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	public boolean addChat(ChatVO vo) {
		conn();
		String sql = "insert into chatting(seq, content, writer, creation_date) values(chat_seq.nextval,?,?,sysdate)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getContent());
			psmt.setString(2, vo.getWriter());
			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}
}
