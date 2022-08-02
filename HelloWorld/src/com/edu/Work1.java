package com.edu;

public class Work1 {
	public static void main(String[] args) {
		int[] intAry = new int[5];

		for (int i = 0; i < intAry.length; i++) {
			intAry[i] = (int) (Math.random() * 30) + 1;
		}

		int maxVal, minVal;
		minVal = maxVal = intAry[0];
		for (int i = 0; i < intAry.length; i++) {
			System.out.println(intAry[i]);
			// 최고점.
			if (intAry[i] > maxVal) {
				maxVal = intAry[i];
			}
			// 최저점.
			if (intAry[i] < minVal) {
				minVal = intAry[i];
			}
		}
		System.out.println("max: " + maxVal);
		System.out.println("min: " + minVal);

	}
}
