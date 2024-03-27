package co.yedam.mavenProject.jdbc;

import java.util.Scanner;

public class Utils {
	static Scanner scn = new Scanner(System.in);

	public static String choiceMessage(String msg) {
		System.out.print(msg + ">> ");
		return scn.nextLine();
	}

	public static String inputString(String msg) {
		System.out.print(msg + ">> ");
		return scn.nextLine();
	}

	public static int inputNumber(String msg) {
		System.out.print(msg + ">> ");
		return Integer.parseInt(scn.nextLine());
	}
	
	public static int inputMenu(String msg) {
		System.out.println(msg);
		System.out.print("선택>> ");
		return Integer.parseInt(scn.nextLine());
	}
}
