package com.edu;

public class ArraySort {
	public static void sorting(int[] ary) {
		int loopCnt = ary.length - 1; // 마지막값이 제일 처음위치로 이동하려면 배열크기-1;
		int temp = ary[0]; // 첫번째 값으로 temp값을 지정.
		for (int cnt = 0; cnt < loopCnt; cnt++)
			for (int i = 0; i < loopCnt; i++) {
				if (ary[i] > ary[i + 1]) {
					// 34 25 => 25 34로 위치변경.
					temp = ary[i];
					ary[i] = ary[i + 1];
					ary[i + 1] = temp;
				}
			}
	}

	public static void main(String[] args) {
		int[] intAry = { 34, 25, 48, 12, 8 }; // 제일 마지막값이 최소값이라고 가정.
		int[] intAry2 = { 22, 56, 99, 12 };
		int[] intAry3 = { 22, 56, 99, 12 };

		// 25, 34, 12, 48
		sorting(intAry);
		// 변경된 결과 출력.
		for (int i = 0; i < intAry.length; i++) {
			System.out.print(intAry[i] + " ");
		}
		System.out.println();

		sorting(intAry2);
		for (int i = 0; i < intAry.length; i++) {
			System.out.print(intAry2[i] + " ");
		}
		System.out.println();
		
		sorting(intAry3);
		for (int i = 0; i < intAry.length; i++) {
			System.out.print(intAry3[i] + " ");
		}
		System.out.println();

		System.out.println("\nend of prog");
	}
}
