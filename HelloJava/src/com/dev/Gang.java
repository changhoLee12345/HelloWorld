package com.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Gang {
	public static void main(String[] args) {

		ArrayList list = new ArrayList(5);

		int[] problems = new int[5];
		for (int i = 0; i < problems.length;) {
			int val = (int) (Math.random() * 5) + 1;

			for (int j = 0; j <= i; j++) {
				if (problems[j] == val) {
					break;
				} else if (j == i) {
					problems[i] = val;
					i++;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(problems));

		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println(".>>>");
			int input = scn.nextInt();
			list.add(input - 1, 1);
			for (int i = 0; i < problems.length; i++) {
				if (i == input - 1) {
					System.out.print("[" + problems[i] + "]");
				} else {
					if ((int) list.get(i) == 1) {
						System.out.print("[" + problems[i] + "]");
					} else {
						System.out.print("[*]");
					}
				}
			}
		}
//		System.out.println("end of prog.");
	}
}
