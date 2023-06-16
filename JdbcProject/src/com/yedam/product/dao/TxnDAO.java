package com.yedam.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.yedam.Dao;
import com.yedam.product.vo.TxnVO;

public class TxnDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private String sql;

	// close()
	private void close() {
		try {
			if (conn != null) {
				conn.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 재고체크(출고하기전에 가능한 수량)
	public int onhandCheck(String pcode) {
		conn = Dao.getConnect();
		sql = "select prod_code, sum(qty) qty " //
				+ "from in_out_txn " //
				+ "where prod_code= ? " //
				+ "group by prod_code ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pcode);
			rs = psmt.executeQuery();
			if (rs.next()) {
				int cnt = rs.getInt("qty");
				return cnt;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return -1;
	}

	// 입고.
	public boolean receipt(String pcode, int qty) {
		conn = Dao.getConnect();
		sql = "insert into in_out_txn values(txn_seq.nextval, ?, ?, sysdate) ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pcode);
			psmt.setInt(2, qty);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	// 출고.
	public boolean issue(String pcode, int qty) {
		conn = Dao.getConnect();
		sql = "insert into in_out_txn values(txn_seq.nextval, ?, ?, sysdate) ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pcode);
			psmt.setInt(2, qty * -1);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	public List<TxnVO> txnHistory(String pcode) {
		List<TxnVO> list = new ArrayList<>();
		conn = Dao.getConnect();
		sql = "select * from in_out_txn where prod_code=? order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pcode);
			rs = psmt.executeQuery();
			while (rs.next()) {
				TxnVO vo = new TxnVO();
				vo.setProdCode(rs.getString("prod_code"));
				vo.setQty(rs.getInt("qty"));
				vo.setTxnDate(rs.getDate("txn_date"));
				vo.setTxnId(rs.getInt("txn_id"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 재고.
	public List<HashMap<String, Integer>> onhandList(boolean overZero) {
		conn = Dao.getConnect();
		List<HashMap<String, Integer>> list = new ArrayList<>();
		sql = "select prod_code, sum(qty) qty from in_out_txn ";
		sql += " group by prod_code";
		if (overZero) {
			sql += " having sum(qty) > 0";
		}
		sql += " order by prod_code";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				HashMap<String, Integer> map = new HashMap<String, Integer>();
				map.put(rs.getString("prod_code"), rs.getInt("qty"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 재고 (페이징)
	public int pagingCount(boolean overZero) {
		conn = Dao.getConnect();
		sql = "select count(1) cnt from ( "//
				+ "  select prod_code cnt from in_out_txn group by prod_code";
		if (overZero) {
			sql += " having sum(qty) > 0";
		}
		sql += ")";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<HashMap<String, Integer>> onhandPaging(int page, boolean overZero) {
		List<HashMap<String, Integer>> list = new ArrayList<>();
		conn = Dao.getConnect();
		int start = 1, last = 1;
		start = (page - 1) * 5;
		last = page * 5;
		sql = "select * from ( "//
				+ "    select rownum rn, prod_code, qty "//
				+ "    from ( "//
				+ "        select prod_code, sum(qty) qty "//
				+ "        from in_out_txn "//
				+ "        group by prod_code ";//
		if (overZero) {
			sql += "        --having sum(qty) > 0 ";//
		}
		sql += "        order by prod_code "//
				+ "    ) a "//
				+ "    where rownum <= ? "//
				+ ") b "//
				+ "where rn > ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(2, start);
			psmt.setInt(1, last);
			rs = psmt.executeQuery();
			while (rs.next()) {
				HashMap<String, Integer> map = new HashMap<String, Integer>();
				map.put(rs.getString("prod_code"), rs.getInt("qty"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
}
