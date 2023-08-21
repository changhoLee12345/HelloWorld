package com.edu;

import java.util.Scanner;

public class Work2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		while (true) {
			int you = (int) (Math.random() * 3) + 1; // 1=>가위, 2=>바위, 3=>보

			System.out.println("가위(1), 바위(2), 보(3)");
			int me = scn.nextInt();
			if (me == -1) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			if (((you + 1) % 3) == (me % 3)) {
				System.out.println("You win.");
			} else if (you == me) {
				System.out.println("Same");
			} else {
				System.out.println("You lose.");
			}
		} // end of while
		System.out.println("end of prog.");
		scn.close();
	}
}
