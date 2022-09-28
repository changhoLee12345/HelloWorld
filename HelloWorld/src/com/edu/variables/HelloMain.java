package com.edu.variables;

public class HelloMain {
	public static void main(String[] args) {
		String name = "hong";
		String[] names = { "hong", "kang", "Choi" };

		for (String nm : names) {
			if (nm == name) {
				System.out.println("same");
			} else {
				System.out.println("diff");
			}
		}
	}

	public static int sum(int n1, int n2) {
		int sum = n1 + n2;
		return sum;
	}
}
