package co.edu;

public class Member {
	// 필드 => 회원아이디, 회원이름, 회원연락처, 회원나이.
	private String memberId;
	private String memberName;
	private String memberPhone;
	private int memberAge; // -14

	// 생성자
	public Member(String memberId, String memberName, String memberPhone, int memberAge) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberAge = memberAge;
	}

	// 메소드
	void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	String getMemberId() {
		return memberId;
	}

	void setMemberAge(int age) {
		if (age < 0) {
			memberAge = 10;
		} else {
			memberAge = age;
		}
	}

	int getMemberAge() {
		return memberAge;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	void showInfo() {
		System.out.printf("회원아이디 %7s\n회원이름 %4s\n연락처 %13s\n나이 %2d\n", memberId, memberName, memberPhone, memberAge);
	}
}
