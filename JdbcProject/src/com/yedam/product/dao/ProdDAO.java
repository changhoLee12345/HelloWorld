package com.yedam.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.Dao;
import com.yedam.product.vo.ProductVO;

public class ProdDAO {
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

	// 등록.
	public boolean insert(ProductVO vo) {
		conn = Dao.getConnect();
		sql = "insert into prod_info (prod_code, prod_name, prod_desc)"//
				+ " values(?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getProdCode());
			psmt.setString(2, vo.getProdName());
			psmt.setString(3, vo.getProdDesc());
			int r = psmt.executeUpdate();
			if (r > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	// 수정.
	public boolean update(ProductVO vo) {
		int cnt = 1;
		conn = Dao.getConnect();
		sql = "update prod_info "//
				+ "set update_date = sysdate";
		if (vo.getRctPrice() > 0) {
			sql += "   ,rct_price = nvl(?, rct_price)";
		}
		if (vo.getSalePrice() > 0) {
			sql += "   ,sale_price = nvl(?, sale_price)";
		}
		if (vo.getSafeQty() > 0) {
			sql += "   ,safe_qty = nvl(?, safe_qty)";
		}
		sql += " where prod_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			if (vo.getRctPrice() > 0) {
				psmt.setInt(cnt++, vo.getRctPrice());
			}
			if (vo.getSalePrice() > 0) {
				psmt.setInt(cnt++, vo.getSalePrice());
			}
			if (vo.getSafeQty() > 0) {
				psmt.setInt(cnt++, vo.getSafeQty());
			}
			psmt.setString(cnt++, vo.getProdCode());

			int r = psmt.executeUpdate();
			if (r > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	// 단건조회.
	public ProductVO search(String pcode) {
		conn = Dao.getConnect();
		sql = "select * from prod_info where prod_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pcode);
			rs = psmt.executeQuery();
			if (rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setCreateDate(rs.getDate("create_date"));
				vo.setProdCode(rs.getString("prod_code"));
				vo.setProdDesc(rs.getString("prod_desc"));
				vo.setProdName(rs.getString("prod_name"));
				vo.setRctPrice(rs.getInt("rct_price"));
				vo.setSafeQty(rs.getInt("safe_qty"));
				vo.setSalePrice(rs.getInt("sale_price"));
				vo.setUpdateDate(rs.getDate("update_date"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}

	// 목록.
	public List<ProductVO> list() {
		conn = Dao.getConnect();
		List<ProductVO> list = new ArrayList<>();
		sql = "select * from prod_info order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setCreateDate(rs.getDate("create_date"));
				vo.setProdCode(rs.getString("prod_code"));
				vo.setProdDesc(rs.getString("prod_desc"));
				vo.setProdName(rs.getString("prod_name"));
				vo.setRctPrice(rs.getInt("rct_price"));
				vo.setSafeQty(rs.getInt("safe_qty"));
				vo.setSalePrice(rs.getInt("sale_price"));
				vo.setUpdateDate(rs.getDate("update_date"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
}
