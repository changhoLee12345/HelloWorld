package co.yedam.collect;

import java.util.ArrayList;
import java.util.Scanner;

public class NextTokenExample {
	public static void main(String[] args) {

		ArrayList<Employee> list = new ArrayList<Employee>();

		Scanner scn = new Scanner(System.in);

		System.out.println("ex) 100 Hong 2500");
		while (true) {
			System.out.print(">> ");
			String inputVal = scn.nextLine();
			String[] input = inputVal.split(" ");
			if (input[0].equals("quit"))
				break;

			if (input.length != 3) {
				System.out.println("다시 입력하세요.");
				continue;
			}

			list.add(new Employee(Integer.parseInt(input[0]), input[1], Integer.parseInt(input[2])));

		}

//		출력부분.
		for (Employee emp : list) {
			System.out.println(emp.toString());
		}
		scn.close();
		System.out.println("end of prog.");
	}
}
