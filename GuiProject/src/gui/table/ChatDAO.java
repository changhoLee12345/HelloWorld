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

	private String url;

	public ChatDAO() {

	}

	public void conn() {
		int menu = 1;
		if (menu == 1) {
			url = "jdbc:oracle:thin:@192.168.0.14:1521:xe";
		} else {
			url = "jdbc:oracle:thin:@localhost:1521:xe";
		}
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hr", "hr");
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

	public List<Employee> getList(Employee emp) {
		conn();
		List<Employee> list = new ArrayList<>();
		String sql = "select * from emp_temp";
		sql += " where employee_id=decode(?, 0, employee_id, ?) and first_name like '%'||?||'%' and last_name like '%'||?||'%' and email like '%'||?||'%' ";
		sql += " and to_char(hire_date, 'yyyy-mm-dd') like '%'||?||'%' and job_id = nvl(?, job_id) ";
		sql += "order by 1";
		try {
			conn.setAutoCommit(false);
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp.getEmployeeId());
			psmt.setInt(2, emp.getEmployeeId());
			psmt.setString(3, emp.getFirstName());
			psmt.setString(4, emp.getLastName());
			psmt.setString(5, emp.getEmail());
			psmt.setString(6, emp.getHireDate());
			psmt.setString(7, emp.getJobId());

			rs = psmt.executeQuery();
			while (rs.next()) {
				Employee vo = new Employee(rs.getInt("employee_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("email"), rs.getString("hire_date"),
						rs.getString("job_id"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	public Employee getEmpl(int eId) {
		conn();
		String sql = "select * from emp_temp where employee_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, eId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				Employee emp = new Employee(rs.getInt("employee_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("email"), rs.getString("hire_date"),
						rs.getString("job_id"));
				return emp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null;
	}

	public boolean delEmp(int eId) {
		conn();
		String sql = "delete from emp_temp where employee_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, eId);
			int r = psmt.executeUpdate();
			if (r > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;

	}

	public boolean addEmp(Employee emp) {
		System.out.println(emp);
		conn();
		String sql = "insert into emp_temp(employee_id, first_name, last_name, email, hire_date, job_id) "//
				+ " values(employees_seq.nextval,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getFirstName());
			psmt.setString(2, emp.getLastName());
			psmt.setString(3, emp.getEmail());
			psmt.setString(4, emp.getHireDate());
			psmt.setString(5, emp.getJobId());

			int r = psmt.executeUpdate();
			if (r > 0)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;

	}

	public boolean modEmp(Employee emp) {
		conn();
		String sql = "update emp_temp set first_name=?, last_name=?, email=?, hire_date=?, job_id=? where employee_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getFirstName());
			psmt.setString(2, emp.getLastName());
			psmt.setString(3, emp.getEmail());
			psmt.setString(4, emp.getHireDate());
			psmt.setString(5, emp.getJobId());
			psmt.setInt(6, emp.getEmployeeId());

			int r = psmt.executeUpdate();
			if (r > 0)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

}
