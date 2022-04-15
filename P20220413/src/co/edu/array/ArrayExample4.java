package co.edu.array;

public class ArrayExample4 {
	public static void main(String[] args) {
		int[] intAry = new int[5];

		// int형 값 1 ~ 30 범위의 임의 값.
		// 반복문 활용. 임의의 값 5개 저장.
		for (int i = 0; i < intAry.length; i++) {
			intAry[i] = (int) (Math.random() * 30) + 1;
		}
		for (int i = 0; i < intAry.length; i++) {
			if (intAry[i] > 15) {
				System.out.println(intAry[i]);
			}
		}

		// 23, 12, 27, 22, 6
		// 15보다 큰 값만 합계 => 평균.

	}
}
