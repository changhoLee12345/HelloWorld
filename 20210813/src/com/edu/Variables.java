package com.edu;

public class Variables {
	public static void main(String[] args) {
		// 변수 : 메모리공간 이름지정 값을 할당.
		int age = 20; // 20 == 30
		System.out.println("age변수: " + age);
		int num1 = 60;
		int num2 = 50;
		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
		System.out.println("20 + 10 = 30");

		String name = "홍길동"; // 문자열.
		name = "최민규";
		System.out.println(name + "의 나이는 " + age + "입니다.");

		final String myName = "박이례"; // 상수(Constance)
//		myName = "김창호";

		// 전화번호, 이메일 값을 담을 수 있는 변수. 010-1234, abc@email.com
		// code here..
		String phoneNumber = "010-4434-1234";
		String email = "abc@emai.com";
		System.out.println(myName + "의 전화번호: " + phoneNumber + "이고 이메일은 " + email);
	}
}
