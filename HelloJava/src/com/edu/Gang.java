package com.edu;

import java.util.Scanner;

public class Gang {
	public static void main(String[] args) {

		int answer = 5;
		int[] number9 = new int[9];
		// 중복제외하고 배치.
		for (int i = 0; i < number9.length;) {
			int temp = (int) (Math.random() * 9) + 1;
			if (checkExist(temp, number9)) {
				continue;
			}
			number9[i] = temp;
			i++;
		}
		// 초기화면..
		System.out.println("-------------");
		for (int i = 0; i < 9; i++) {
			System.out.printf("%4s", "|?|");// number9[i]);
			if (i % 3 == 2) {
				System.out.println();
			}
		}
		System.out.println("-------------");

		Scanner scn = new Scanner(System.in);
		int[] selectedAry = new int[9];
		while (true) {
			System.out.println();
			System.out.print("input>> (1~9) ");
			int val = scn.nextInt();
			// 입력했던 값들을 배열에 누적.
			for (int i = 0; i < selectedAry.length; i++) {
				if (selectedAry[i] == 0) {
					selectedAry[i] = val;
					break;
				}
			}

			int correct = -1;
			System.out.println("-------------");
			for (int i = 0; i < number9.length; i++) {
				correct = -1;
				for (int j = 0; j < selectedAry.length; j++) {
					if (i + 1 == selectedAry[j]) {
						correct = i;
						break;
					}
				}
				// 입력된 값이 있으면 그 위치를 화면에 보여주기.
				if (correct != -1) {
					System.out.printf(" |%1d|", number9[i]);
				} else {
					System.out.printf("%4s", "|?|");
				}

				if (i % 3 == 2) {
					System.out.println();
				}
			}
			System.out.println("-------------");
			// 정답을 찾았을 경우. => 종료.
			if (number9[(val - 1)] == answer) {
				System.out.println("correct");
				break;
			}

		}
		scn.close();
		System.out.println("end of program");
	}

	public static boolean checkExist(int searchNo, int[] intAry) {
		for (int i = 0; i < intAry.length; i++) {
			if (intAry[i] == searchNo) {
				return true;
			}
		}
		return false;
	}

}
