package co.yedam.mavenProject.jdbc.swim;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.mavenProject.jdbc.DAO;

public class SwimDAO extends DAO {

	private static SwimDAO instance = new SwimDAO();

	private SwimDAO() {
	}

	public static SwimDAO getInstance() {
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

	// 강죄목록보기.
	public List<SwimVO> swimList() {
		List<SwimVO> slist = new ArrayList<>();
		String sql = "select * from tbl_swim";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				SwimVO svo = new SwimVO();
				svo.setCoach(rs.getString("coach"));
				svo.setEnabled(rs.getString("enabled"));
				svo.setSwimCode(rs.getString("swim_code"));
				svo.setSwimFee(rs.getInt("swim_fee"));
				svo.setSwimName(rs.getString("swim_name"));

				slist.add(svo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			discon();
		}
		return slist;
	}

	public boolean insertSwim(SwimVO svo) {
		getConn();
		String sql = "insert into tbl_swim (swim_code, swim_name, coach, swim_fee) values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, svo.getSwimCode());
			psmt.setString(2, svo.getSwimName());
			psmt.setString(3, svo.getCoach());
			psmt.setInt(4, svo.getSwimFee());

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			discon();
		}
		return false;
	}

	
}
