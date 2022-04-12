package co.edu.loop;

import java.util.Scanner;

public class AccountExample {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int balance = 0;
		boolean run = true;

		while (run) {
			System.out.println("--------------------------------");
			System.out.println("1.예금 2.출금 3.조회 4.종료");
			System.out.println("--------------------------------");
			System.out.print("선택>>> ");
			int menu = scn.nextInt();

			if (menu == 1) {
				// 예금기능.
				System.out.print("예금액> ");
				int money = scn.nextInt();
				balance += money;

			} else if (menu == 2) {
				// 출금기능.
				System.out.print("출금액> ");
				int money = scn.nextInt();
				balance -= money;

			} else if (menu == 3) {
				// 조회기능.
				System.out.print("잔고> " + balance + "\n");

			} else if (menu == 4) {
				// 종료.
				run = false;

			} else {
				System.out.println("잘못된 메뉴를 선택했습니다.");
			}

		} // end of while(run);

		System.out.println("프로그램 종료.");

	}
}
