package co.edu;

import java.util.Scanner;

public class CalTimeEx {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("초를 입력하세요.");
		int time = scn.nextInt();
		// 시, 분, 초 => 5000초 5000/(60*60) => ?시간
		// 5000%(60*60) => 1400/60 => ?분
		// 초 => ?초

		int hours, minutes, secs;
		hours = time / (60 * 60); // => 1시간으로 나누기 연산. 정수연산의 결과.
		time = time % (60 * 60); // => 연산결과의 나머지를 time에 대입.

		minutes = time / 60; // 1분으로 나누기 연산.
		time = time % 60;

		secs = time; // 나머지 값을 secs 변수로 대입.

		System.out.printf("%2d시 %2d분 %2d초", hours, minutes, secs);

	}
}
