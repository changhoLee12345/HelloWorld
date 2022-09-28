package com.edu.variables;

import java.util.Arrays;

public class HelloMain {
	public static void main(String[] args) {
		int num1 = 10, num2 = 20;
		int result = sum(num1, num2);

		result = Math.subtractExact(num1, num2);

		int[] intAry = {};
		intAry = new int[] { 1, 2, 3, 4, 5 };
		for (int i = 0; i < intAry.length; i++) {
			System.out.println(intAry[i]);
		}
		
		Arrays.asList(intAry).stream();

		System.out.println(num1 + "과 " + num2 + "의 결과는 " + result + "입니다.");
	}

	public static int sum(int n1, int n2) {
		int sum = n1 + n2;
		return sum;
	}
}
