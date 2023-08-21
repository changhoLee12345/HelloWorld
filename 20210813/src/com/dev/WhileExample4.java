package com.dev;

import java.util.Scanner;

public class WhileExample4 {
	public static void main(String[] args) {
		// 은행 계좌를 만들어서 1:입금, 2:출금, 3:종료
		// 입금일 경우: 입금액을 입력하세요...account 값을 누적.
		// 출금일 경우: 출금액을 입력하세요...account 값을 차감.
		// 종료일 경우: 프로그램 종료.

		// Scanner, account=0
		Scanner scn = new Scanner(System.in);
		int account = 0;

		while (true) {
			System.out.println("1:입금, 2:출금, 3:종료");
			System.out.print("선택> ");
			int menu = scn.nextInt();

			if (menu == 1) { // 입금일 경우..
				System.out.print("입금액>> ");
				account += scn.nextInt();
				System.out.println("잔액: " + account);

			} else if (menu == 2) { // 출금일 경우..
				// 마이너스 통장이 안되도록 처리...
				System.out.print("출금액>> ");
				int amt = scn.nextInt();

				if (amt > account) { // 잔액부족..
					System.out.println("잔액을 초과합니다.");
					System.out.println("현재 잔액: " + account);
					continue; // 구문 아래를 무시 다음순번으로 넘어감.
				}
				// 정상 출금..
				account -= amt;
				System.out.println("잔액: " + account);

			} else if (menu == 3) { // 종료일 경우..
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}

		System.out.println("end of program");
	}
}
