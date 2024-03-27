package co.yedam.mavenProject.jdbc.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.mavenProject.jdbc.DAO;
import co.yedam.mavenProject.jdbc.swim.LectureVO;

public class MemberDAO extends DAO {

	private static MemberDAO instance = new MemberDAO();

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		return instance;
	}

	ResultSet rs;
	PreparedStatement psmt;

	public void discon() {
		try {
			if (conn != null) {
				conn.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public MemberVO loginCheck(String id, String pw) {
		String sql = "select * from tbl_member where mem_id = ? and mem_pw = ?";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();
			if (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMemId(rs.getString("mem_id"));
				vo.setMemPw(rs.getString("mem_pw"));
				vo.setMemName(rs.getString("mem_name"));
				vo.setMemPhone(rs.getString("mem_phone"));
				return vo;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			discon();
		}
		return null;
	} // end of loginCheck.

	public String checkResponsibility(MemberVO mvo) {
		String sql = "select * from tbl_auth where mem_id = ? and enabled = 'Y'";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mvo.getMemId());

			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getString("auth");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			discon();
		}
		return null;
	}

	public boolean insertMember(MemberVO mvo) {
		String sql = "insert into tbl_member (mem_id, mem_pw, mem_name, mem_phone) "//
				+ "values(?,?,?,?)";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mvo.getMemId());
			psmt.setString(2, mvo.getMemPw());
			psmt.setString(3, mvo.getMemName());
			psmt.setString(4, mvo.getMemPhone());

			int r = psmt.executeUpdate();
			if (r > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			discon();
		}
		return false;
	}

	public List<MemberVO> checkMemberAuth() {
		String sql = "select * "//
				+ "from tbl_member m "//
				+ "where not exists (select 1  "//
				+ "                  from tbl_auth a "//
				+ "                  where m.mem_id = a.mem_id)";
		getConn();
		List<MemberVO> memList = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMemId(rs.getString("mem_id"));
				vo.setMemName(rs.getString("mem_name"));
				vo.setMemPhone(rs.getString("mem_phone"));

				memList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			discon();
		}
		return memList;
	}

	public void insertAuth(String name) {
		String sql = "insert into tbl_auth(mem_id, auth) values(?,'USER')";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			discon();
		}
	}

	// 수강목록.
	public List<LectureVO> getLectureList(String id) {
		String sql = "select mem_id\r\n"//
				+ "      ,s.swim_code\r\n"//
				+ "      ,s.swim_name\r\n"//
				+ "      ,s.coach\r\n"//
				+ "      ,s.swim_fee\r\n"//
				+ "      ,sl.creation_date\r\n"//
				+ "from tbl_swim_lecture sl\r\n"//
				+ "join tbl_swim s\r\n" //
				+ "on sl.swim_code = s.swim_code\r\n"//
				+ "where s.enabled = 'Y'"//
				+ " and mem_id = ?";
		getConn();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();
			List<LectureVO> lectures = new ArrayList<>();

			while (rs.next()) {
				LectureVO lvo = new LectureVO();
				lvo.setMemId(rs.getString("mem_id"));
				lvo.setCoach(rs.getString("coach"));
				lvo.setCreationDate(rs.getDate("creation_date"));
				lvo.setSwimCode(rs.getString("swim_code"));
				lvo.setSwimFee(rs.getInt("swim_fee"));
				lvo.setSwimName(rs.getString("swim_name"));
				lectures.add(lvo);

			}
			return lectures;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			discon();
		}
		return null;
	}
}
