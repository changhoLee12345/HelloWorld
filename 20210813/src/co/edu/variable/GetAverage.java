package co.edu.variable;

import java.util.Scanner;

public class GetAverage {
	public static void main(String[] args) {
		// 입력값을 num1, num2, num3
		Scanner scn = new Scanner(System.in);
		int age = 10;
		String myName = "홍길동";

		// 정수 연산 => 정수. 10, 15, 15 => 40/3.0 => 13
		int num1, num2, num3;
		num1 = num2 = 10;
		num3 = 15;
		double avg = (num1 + num2 + num3) / 3.0;

		// 결과값 : 입력한 세 정수는 10, 15, 15 이고 평균은 13.33333 입니다.
//		System.out.printf("이름은 %3s이고 평균은 %.2f이고 나이는 %5d", myName, avg, age);
		System.out.printf("입력한 세 정수는 %3d, %3d, %3d 이고 평균은 %.2f 입니다.", num1, num2, num3, avg);
	}
}
