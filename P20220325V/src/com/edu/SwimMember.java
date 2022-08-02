package com.edu;

public class SwimMember extends Member {
	// 강습반의 강사이름.
	// 수영등급(A,B,C,D)
	private String teachName;
	private String grade;

	public SwimMember(int memberId, String memberName, String phone//
			, String teachName, String grade) {
		super(memberId, memberName, phone);
		this.teachName = teachName;
		this.grade = grade;
	}

	// 정보출력시 => 강사이름: 홍길동, 등급: A
	@Override
	public String toString() {
		String info = super.toString(); // 부모클래스(Member) id, name, phone
		info += "\n추가정보)  강사이름=" + teachName + ", 등급=" + grade + "\n";
		return info;
	}
}
