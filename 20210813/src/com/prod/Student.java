package com.prod;

public class Student {
	// 22-123456
	// 필드.(field)
	String studentNo;
	String studentName;
	int korScore;
	int engScore;

	// method : 기능..함수
	void study(String gwamok) {
		System.out.println(gwamok + "를(을) 공부합니다.");
	}

	void eat(String food) {
		System.out.println(food + "을 먹습니다.");
	}

	int getKorScore() {
		return korScore;
	}

	int getEngScore() {
		return engScore;
	}

}
