package co.yedam.collect;

import java.util.Scanner;

public class TypingSpeedGame {
	public static void main(String[] args) {
		String orign = "The new Madrid region will deliver hundreds of OCI services to help organizations";
		Scanner scn = new Scanner(System.in);

		boolean done = false;
		long startTime = System.currentTimeMillis();

		String[] target = orign.split(" ");
		while (true) {

			done = true;
			for (String str : target) {
				if (str != null) {
					System.out.printf("%s ", str);
					done = false;
				}
			}
			if (done) {
				break;
			}

			System.out.print("\n입력>> ");
			String word = scn.nextLine();

			// 같은 단어가 있는 지 체크해서 있으면 삭제.
			for (int i = 0; i < target.length; i++) {
				if (target[i] != null && target[i].equals(word)) {
					target[i] = null;
				}
			}

		} // end of while

		long endTime = System.currentTimeMillis();
		long duringTime = endTime - startTime;

		System.out.println("걸린시간은 " + duringTime);
	}
}
