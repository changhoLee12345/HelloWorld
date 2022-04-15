package co.edu.array;

import java.util.Scanner;

public class ArrayExample5 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] scores = new int[5];

		for (int i = 0; i < scores.length; i++) {
			System.out.println("학생점수를 입력>>>> ");
			scores[i] = scn.nextInt();
		}

		int maxVal, minVal;
		maxVal = minVal = scores[0];

		for (int i = 0; i < scores.length; i++) {
			// 최고점.
			if (scores[i] > maxVal) {
				maxVal = scores[i];
			}
			// 최저점.
			if (scores[i] < minVal) {
				minVal = scores[i];
			}
		}

		// 학생중에 최고점, 최저점.
		System.out.println("최고점은 80점, 최저점은 67점");

		// 학생이름, 점수 
		// 배열, 배열 0 => 학생, 90
	}
}
