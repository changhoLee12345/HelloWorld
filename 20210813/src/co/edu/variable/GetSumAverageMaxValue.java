package co.edu.variable;

import java.util.Scanner;

public class GetSumAverageMaxValue {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int num1, num2, num3, maxValue, sum;
		double avg;

		System.out.println("점수를 입력하세요>>> ");
		num1 = scn.nextInt();
		System.out.println("점수를 입력하세요>>> ");
		num2 = scn.nextInt();
		System.out.println("점수를 입력하세요>>> ");
		num3 = scn.nextInt();

		sum = num1 + num2 + num3;
		avg = sum / 3.0;

		// 최고점을 구하는 방식(num1, num2, num3) 비교.
		maxValue = num1;
		if (maxValue < num2) {
			maxValue = num2;
		}
		if (maxValue < num3) {
			maxValue = num3;
		}

		System.out.printf("합은 %3d이고 평균은 %.2f이고 최고점은 %3d점입니다.", sum, avg, maxValue);
	}
}
