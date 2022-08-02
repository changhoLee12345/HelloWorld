package com.edu;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StreamExample {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String fileName = "c:/upload/sample.txt";
		String copyFile = "c:/upload/copy.txt";

		try (FileReader fr = new FileReader(fileName); FileWriter fw = new FileWriter(copyFile)) {

			int buf = -1;
			for (int i = 0; i < 1000; i++) {
				while ((buf = fr.read()) != -1) {
//					fw.write(buf);
					fw.append((char) buf);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		scn.close();
		System.out.println("===end of prog===");

	}
}
