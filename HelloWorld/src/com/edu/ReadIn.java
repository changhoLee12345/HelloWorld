package com.edu;

import java.io.IOException;

public class ReadIn {
	public static void main(String[] args) {
		try {
			System.out.println("value>>");
			int result = System.in.read();
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
