package co.edu.dimension;

public class ArrayExample {
	public static void main(String[] args) {
		int[][] intAry = new int[5][5];

		intAry[0][0] = 10;
		intAry[1][0] = 20;
		intAry[3][2] = 100;

		for (int j = 0; j < intAry.length; j++) {
			for (int i = 0; i < intAry[j].length; i++) {
//				System.out.print("[" + j + "]" + "[" + i + "] => " + intAry[j][i] + " ");
			}
			System.out.println();
		}
		//
// 1 2 3 4 5
// 6 7 8 910
//1112131415
//1617181920
//2122232425
		intAry[0][0] = 1;
		intAry[0][1] = 2;
		intAry[0][2] = 3;
		intAry[0][3] = 4;
		intAry[0][4] = 5;

		intAry[1][0] = 6;
		intAry[1][1] = 7;
		intAry[1][2] = 8;
		intAry[1][3] = 9;
		intAry[1][4] = 10;

		intAry[2][0] = 11;
		intAry[2][1] = 12;
		intAry[2][2] = 13;
		intAry[2][3] = 14;
		intAry[2][4] = 15;

		intAry[3][0] = 16;
		intAry[3][1] = 17;
		intAry[3][2] = 18;
		intAry[3][3] = 19;
		intAry[3][4] = 20;

		intAry[4][0] = 21;
		intAry[4][1] = 22;
		intAry[4][2] = 23;
		intAry[4][3] = 24;
		intAry[4][4] = 25;

		// 배열에서는 인덱스 주소값으로 값을 지정, 호출.
		for (int i = 4; i >= 0; i--) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("%3d", intAry[i][j]);
			}
			System.out.println();
		}

	}
}
