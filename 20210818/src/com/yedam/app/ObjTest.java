package com.yedam.app;

class Member {
	String id;
	String name;

	public Member() {
	}

	public Member(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Member target = (Member) obj;
		return this.name.equals(target.name);
	}
}

public class ObjTest {

	public static void main(String[] args) {
		Member member = new Member("100", "김길동");
		Member member2 = new Member("101", "김길동");
		System.out.println(member);

		System.out.println(member.equals(member2));
	}

}
