package com.edu;

public class StringTest {
	public static void main(String[] args) {
//		StringBuilder str = new StringBuilder();
		String str = "";
		for (int i = 0; i < 1000000; i++) {
//			str.append(String.valueOf(i));
			str += String.valueOf(i);
//			try {
//				Thread.sleep(1);
//				System.out.println(str);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		System.out.println(str);
		System.out.println("end of prog");
	}
}
