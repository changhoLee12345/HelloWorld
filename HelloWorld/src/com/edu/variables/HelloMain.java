package com.edu.variables;

import java.util.Arrays;

public class HelloMain {

	public static void main(String[] args) {
		int[] intAry = { 34, 21, 18 };

		// sorting.
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
		if (intAry[0] > intAry[1]) {
			temp = intAry[0];
			intAry[0] = intAry[1];
			intAry[1] = temp;
		}

		// sorted.
		for (int num : intAry) {
			System.out.println(num);
		}
	}

}
