package com.yedam.app;

public class ObjTest {

	public static void main(String[] args) {
		Member member = new Member("100", "김길동");
		Member member2 = new Member("101", "김길동");
		System.out.println(member);

		System.out.println(member.equals(member2));
	}

}
