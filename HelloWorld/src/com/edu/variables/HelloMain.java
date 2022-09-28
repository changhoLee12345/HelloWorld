package com.edu.variables;

public class HelloMain {

	public static void main(String[] args) {
		int[] intAry = { 34, 21, 18, 12 };

		// sorting.
		// 1)
		int temp = 0;
		if (intAry[0] > intAry[1]) {
			temp = intAry[0];
			intAry[0] = intAry[1];
			intAry[1] = temp;
		}
		if (intAry[1] > intAry[2]) {
			temp = intAry[1];
			intAry[1] = intAry[2];
			intAry[2] = temp;
		}
		if (intAry[2] > intAry[3]) {
			temp = intAry[2];
			intAry[2] = intAry[3];
			intAry[3] = temp;
		}
		printAry(intAry);
		// 2)
		if (intAry[0] > intAry[1]) {
			temp = intAry[0];
			intAry[0] = intAry[1];
			intAry[1] = temp;
		}
		if (intAry[1] > intAry[2]) {
			temp = intAry[1];
			intAry[1] = intAry[2];
			intAry[2] = temp;
		}
		printAry(intAry);
		// 3)
		if (intAry[0] > intAry[1]) {
			temp = intAry[0];
			intAry[0] = intAry[1];
			intAry[1] = temp;
		}
		printAry(intAry);

		// sorted.
//		for (int num : intAry) {
//			System.out.println(num);
//		}
	}

	public static void sortAry(int[] ary) {
		int temp = 0;
		for (int j = 0; j < ary.length - 1; j++) {
			for (int i = 0; i < ary.length - (j + 1); i++) {
				System.out.println("j=> " + j + ", i=> " + i);
				if (ary[i] > ary[i + 1]) {
					temp = ary[i];
					ary[i] = ary[i + 1];
					ary[i + 1] = temp;
				}
			}
		}
	}

	public static void printAry(int[] ary) {
		for (int i = 0; i < ary.length; i++)
			System.out.printf("%d ", ary[i]);

		System.out.println();
	}

}
