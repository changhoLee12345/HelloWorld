package com.yedam.product;

import java.util.Scanner;

public class Util {

	static Scanner scn = new Scanner(System.in);
	static final String menuErrMsg = "메뉴를 선택하세요.";

	// 출력기능.
	public static void prompt(String msg) {
		System.out.println(msg);
	}

	// 메세지와 문자열 반환값.
	public static String promptString(String msg) {
		System.out.print(msg + "> ");
		return scn.nextLine();
	}

	// 메세지와 int반환값.
	public static int promptInt(String msg) {
		int result = 0;
		while (true) {
			try {
				System.out.print(msg + "> ");
				result = scn.nextInt();
				scn.nextLine();
				break;
			} catch (Exception e) {
				System.out.println(menuErrMsg);
				scn.nextLine();
			}
		}
		return result;
	}

	public static int promptPrice(String msg) {
		int price;
		while (true) {
			try {
				System.out.print(msg + "> ");
				String result = scn.nextLine();
				if (result.equals("")) {
					return -1;
				}
				price = Integer.parseInt(result);
				break;
			} catch (Exception e) {
				System.out.println("가격을 입력하세요.");
			}
		}
		return price;
	}
}
