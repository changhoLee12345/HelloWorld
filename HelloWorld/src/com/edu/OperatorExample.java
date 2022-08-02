package com.edu;

public class OperatorExample {
	public static void main(String[] args) {
		int num1, num2, result;

		num1 = 10;
		num2 = 100;

		num1 += 20;
		num2 -= 50;

		num1++; // 31
		num2--; // 49
		num2--; // 48
		num1 >>= 2; // num1 = num1 >> 2;

		result = num1 + num2;
		System.out.println("result=> " + result);
		int myAge = 19;
		// myAge = 29;
		boolean isAdult = myAge > 20;
		System.out.println(isAdult);

		// 논리연산자
		if (isAdult) {
			System.out.println("성인입니다");
		} else {
			System.out.println("미성년입니다");
		}

		int val1 = 10;
		int val2 = 20;

		if ((val1++ % 2 == 0) | (val2++ % 2 == 0)) {
			System.out.println(val1 + ", " + val2);
		}
	}
}
