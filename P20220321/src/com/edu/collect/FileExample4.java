package com.edu.collect;

import java.util.Scanner;

public class FileExample4 {
	public static void main(String[] args) {
//		InputStream is = System.in;
//		int readByte;
//		try {
//			while (true) {
//				readByte = is.read();
//				System.out.println(readByte + " => " + (char) readByte);
//				if (readByte == 97) {
//					break;
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		Scanner scn = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String content = "";
		while (true) {
			String str = scn.nextLine();
			sb.append(str + "\n");
			if (str.equals("exit")) {
				break;
			}
			content = sb.toString();
		}
		System.out.println(content);
		scn.close();

		System.out.println("end of prog");

	}
}
