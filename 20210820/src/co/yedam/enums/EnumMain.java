package co.yedam.enums;

import java.util.Scanner;

public class EnumMain {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("1.Add 2.Modify 3.Exit");
			int menu = scn.nextInt();
			scn.nextLine();

			if (Menu.ADD.equal(menu)) {
				System.out.println("add function.");

			} else if (Menu.MODIFY.equal(menu)) {
				System.out.println("modify function.");

			} else if (Menu.EXIT.equal(menu)) {
				System.out.println("exit function.");
				break;

			}
		}
		System.out.println("end of prog.");
		scn.close();
	}
}
