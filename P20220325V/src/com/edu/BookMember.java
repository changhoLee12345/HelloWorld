package com.edu;

public class BookMember extends Member {
	// 도서반의 반장이름.
	// 도서반의 강의실정보.(지혜실, 지식실, 모험실)
	private String banName;
	private String roomName;

	// 생성자.
	public BookMember(int memberId, String memberName, String phone, //
			String banName, String roomName) {
		super(memberId, memberName, phone);
		this.banName = banName;
		this.roomName = roomName;
	}

	// 정보출력시 => 반장이름: 홍길동, 강의실: 모험실
	@Override
	public String toString() {
		String info = super.toString(); // 부모클래스(Member) id, name, phone
		info += "\n추가정보)  반장이름=" + banName + ", 강의실=" + roomName + "\n";
		return info;
	}

}
