package com.edu;

public class Work1 {
	public static void main(String[] args) {
		int start = -0;
		int curr, next, prev;
		prev = -1;
		curr = start;
		for (int i = 0; i < 10; i++) {
			System.out.print(curr + " ");
			next = (prev == -1 ? (curr + 1) : prev) + curr;
			prev = curr;
			curr = next;
		}
	}

	// 중복값이 없이 배열을 채워넣기.
	public void work1() {
		int aSize = 10;

		int[] intAry = new int[aSize];

		for (int i = 0; i < intAry.length;) {
			int temp = (int) (Math.random() * aSize) + 1;
			int j = i - 1; // 현재 위치의 -1번째 위치부터 처음까지 비교하려고 한다.
			for (; j >= 0; j--) {
				if (intAry[j] == temp) {
					break;
				}
			}
			if (j >= 0) { // 같은 값이 있으면 그 때의 순번은 0보다 크다.
				continue;
			}
			// 같은 값이 없으면 새로운 값을 입력하고 i를 증가시킨다.
			intAry[i++] = temp;
		}

		for (int t : intAry) {
			System.out.print(t + " ");
		}

	}
}
