package com.dev;

public class ForExample4 {
	public static void main(String[] args) {
		// 1 ~ 10 까지 수중에서 짝수의 값=> evenSum, 홀수의 값=> oddSum
		int evenSum = 0;
		int oddSum = 0; // int형 변수선언
//		evenSum = oddSum = 0; // 변수에 초기값을 할당(초기화)

		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				oddSum += i; // oddSum = oddSum + i;
			} else {
				evenSum += i;// evenSum = evenSum + i;
			}
		}
		System.out.println("홀수의 합: " + oddSum + ", 짝수의 합: " + evenSum);
		// 홀수의 합: ??, 짝수의 합: ?? 입니다.
	}
}
