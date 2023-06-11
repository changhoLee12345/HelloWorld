package com.yedam.app;

public class StringEx {
	public static void main(String[] args) {
		byte[] bytes = "Hello,World".getBytes();
		for (byte b : bytes) {
			System.out.println(b);
		}
	}
}
