package co.edu.variable;

import java.io.IOException;
import java.util.Scanner;

public class SystemExample {
	public static void main(String[] args) {
		// 표준입출력. System.in, System.out
//		Scanner scn = new Scanner("홍길동 길동 박길동"); // 키보드.
//		System.out.println("세개의 단어를 입력. 예) 안녕 방가 잘가");
//		while (scn.hasNext()) {
//			String str = scn.next();
//			System.out.println(str);
//			if (str.equals("exit")) {
//				break;
//			}
//		}

		System.out.println("숫자를 입력하세요.");
		while (true) {
			int readByte;
			try {
				readByte = System.in.read();
				System.out.println(readByte);
				if(readByte == 97)
					break;
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		System.out.println("end of program");
	}
}
