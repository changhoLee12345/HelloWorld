package com.test;

import java.util.Scanner;

//문제3) 정수형배열 선언하고 사용자로 세개의 정수값을 
//      입력받아서 배열에 저장. 제일 큰값을 구하는 코드를 작성.
public class Exam03 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] intAry = new int[4];

		for (int i = 0; i < intAry.length; i++) {
			System.out.println("정수를 입력하세요>> ");
			intAry[i] = scn.nextInt();
		}
		// 배열에 값이 3개 저장. [34, 23, 56]
		int maxValue = intAry[0];
		for (int i = 0; i < intAry.length; i++) {
			if (intAry[i] > maxValue) {
				maxValue = intAry[i];
			}
		}
		System.out.println("최대값: " + maxValue);
	}
}
