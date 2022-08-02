package com.edu.collect;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceOracle extends DAO implements StudentService {

	@Override
	public String checkResponsibility(String id, String pw) {
		conn = getConnect();
		String sql = "select * from users where id=? and passwd=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getString("etc_info");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	@Override
	public void insertStudent(Student student) {

	}

	@Override
	public Student getStudent(int sno) {
		return null;
	}

	@Override
	public List<Student> studentList() {
		List<Student> list = new ArrayList<Student>();// 조회된 결과값을 담기위한 컬렉션.
		conn = getConnect();
		String sql = "select * from student_info order by student_no";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); // 실행건수만큼 반복자.
			while (rs.next()) { // 반복자를 통해 요소를 가지고 올 수 있는지 체크. 있으면 하나 가지고 옴.
				Student student = new Student();
				student.setStudentNo(rs.getInt("student_no"));
				student.setName(rs.getString("student_name"));
				student.setEngScore(rs.getInt("eng_score"));
				student.setKorScore(rs.getInt("kor_score"));

				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}

	@Override
	public void modifyStudent(Student student) {

	}

	@Override
	public void removeStudent(int sno) {

	}

	@Override
	public List<Student> searchStudent(String name) {
		return null;
	}

	@Override
	public void saveToFile() {

	}

}
