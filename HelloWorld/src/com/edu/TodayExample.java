package com.edu;
// 이름을 입력받도록...(String) -> scn.nextLine();

// 연락처 입력...(String) -> scn.nextLine();
// 나이 입력...(int) -> scn.nextInt();
// 키 입력...(double) -> scn.nextDouble();

// 이름은 : ???
// 연락처 : 010-2345-8456
// 나이  : 26
// 키    : 167.4
// 몸무게 : 63.4
// 적정몸무게: (키 - 100) * 0.9 => 60.3 크면 과제충 작으면 저체중.
// +- 5키로...55.3< < 65.3

public class TodayExample {
	public static void main(String[] args) {
		double weight = 67.5; // 72.5 ~ 62.5 사이에 적정.

		double realWeigth = 69.3; // 30

		if (weight + 5 > realWeigth && weight - 5 < realWeigth) {
			System.out.println("적정몸무게입니다.");
		} else {
			System.out.println("비정상입니다.");
		}
	}
}
