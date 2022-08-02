package com.prod;

import java.util.Scanner;

public class Game {

	static int[] rect = new int[16];
	static int[] answer = new int[16];

	public static void main(String[] args) {
//	 ___________________
//	|[01]|[02]|[03]|[04]|
//	|____|____|____|____|
//	|[05]|[06]|[07]|[08]|
//	|____|____|____|____|
//	|[09]|[10]|[11]|[12]|
//	|____|____|____|____|
//	|[13]|[14]|[15]|[16]|
//	|____|____|____|____|

		Scanner scn = new Scanner(System.in);
		setPosition();

		boolean run = true;
		while (run) {
			System.out.print("n1 n2>> ");
			String n1 = scn.next();
			String n2 = scn.next();

			showContent(n1, n2);
			int i = 0;
			for (; i < answer.length; i++) {
				if (answer[i] == 0) {
					break;
				}
			}
			if (i == answer.length)
				run = false;
		}
		System.out.println("end of prog.");
		scn.close();

	} // end of main()

	// 화면 보여주기.
	public static void showContent(String n1, String n2) {
		if (n1 == null || n1.equals("-1")) {
			n1 = "-1";
			n2 = "-1";
		}
		// 임의로 지정된 값을 화며에 보여주기.
		int pos1 = Integer.parseInt(n1);
		int pos2 = Integer.parseInt(n2);

		int cnt = 0;
		System.out.println(" ___________________");
		for (int i = 0; i < rect.length; i++) {

			// 위치값을 표시하기.
			String digit = toDigit(i + 1, "[", "]");
			System.out.print("|" + digit);

			// 줄바꿈할때마다 임의의 값과 언더바 그려주기.
			if (i % 4 == 3) {
				System.out.print("|\n");

				// 임의의 값을 배치하기.
				for (int j = 0; j < 4; j++) {
					if (cnt == pos1 - 1 || cnt == pos2 - 1) {
						System.out.print("|" + toDigit(rect[cnt], " ", " "));
						// 입력한 위치의 값이 같으면 정답배열의 같은 위치에 1을 넣어놓아서 0과 구별되도록 한다.
						if (rect[pos1 - 1] == rect[pos2 - 1]) {
							answer[cnt] = 1;
						}
					} else if (answer[cnt] == 1) {
						System.out.print("|" + toDigit(rect[cnt], " ", " "));
					} else {
						System.out.print("| -- ");
					}
					if (j == 3) {
						System.out.print("|\n");
					}
					cnt++;
				}
				// 밑줄 그려주기.
				for (int j = 0; j < 4; j++) {
					System.out.print("|____");
					if (j == 3) {
						System.out.print("|\n");
					}
				}
			}
		}
		if (pos1 != -1) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			showContent(null, null);
		}

	}

	// 위치배치.
	public static void setPosition() {
		// 1 ~ 8까지의 숫자를 2군데씩 임의로 지정하기.
		int cnt = 1;
		for (int i = 0; i < rect.length;) {
			int position = (int) (Math.random() * 16);
			if (i != 0 && rect[position] != 0) {
				continue;
			}

			if (i % 2 == 0) {
				rect[position] = cnt;
			} else {
				rect[position] = cnt++;
			}
			i++;
		}

	}

	public static String toDigit(int num, String ltoken, String rtoken) {

		String digit = (num < 10 ? ltoken + "0" + num + rtoken : ltoken + num + rtoken);
		return digit;

	}
}
