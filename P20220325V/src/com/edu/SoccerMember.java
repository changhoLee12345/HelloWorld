package com.edu;

public class SoccerMember extends Member {
	// 축구반의 코치이름.
	// 락커룸의 이름.(A, B, C, D)
	private String coachName;
	private String rockName;

	public SoccerMember(int memberId, String memberName, String phone//
			, String coachName, String rockName) {
		super(memberId, memberName, phone);
		this.coachName = coachName;
		this.rockName = rockName;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public String getRockName() {
		return rockName;
	}

	public void setRockName(String rockName) {
		this.rockName = rockName;
	}

	// 정보출력시 => 코치이름: 홍길동, 락커룸: A
	@Override
	public String toString() {
		String info = super.toString(); // 부모클래스(Member) id, name, phone
		info += "\n추가정보)  코치이름=" + coachName + ", 라커룸=" + rockName + "\n";
		return info;
	}
}
