package co.yedam.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentEx {
	public static void main(String[] args) throws IOException {

		InputStream is = new FileInputStream("/home/linuxie/Dev/sample.txt");
		InputStreamReader isr = new InputStreamReader(is);
		char[] buf = new char[100];
		int readBuf = 0;
		int sum = 0, maxScore = 0;
		String name = "";
//		while ((readBuf = isr.read(buf)) != -1) {
		isr.read(buf);
		String readLine = new String(buf, 0, buf.length);
		System.out.println(readLine);
		String[] values = readLine.split("\n");
		System.out.println(values.length);
		for (int i = 0; i < values.length; i++) {
//				System.out.println(line);
			String[] val = values[i].split(" ");
//			System.out.println(val[0] + "," + val[1] + "," + val[2]);
//				int score = Integer.parseInt(val[2]);
//				if (score > maxScore) {
//					maxScore = score;
//				}
		}
//		}
		is.close();
		isr.close();
		System.out.println("maxScore: " + maxScore);
		System.out.println("end of prog.");
	}

	public static void method2() throws IOException {

		FileReader fr = new FileReader("/home/linuxie/Dev/sample.txt");

		while (true) {
			int readData = fr.read();
			if (readData == -1) {
				break;
			}
			char result = (char) readData;
			System.out.println(result + " : " + readData);
		}
	}

	public static void method1() {
		double avg = 0;
		int cnt = 0, sum = 0, maxScore = 0;
		String name = "";

		try {
			Scanner scn = new Scanner(new File("/home/linuxie/Dev/sample.txt"));

			String str = "";
			while (true) {
				try {
					str = scn.nextLine();
				} catch (NoSuchElementException e) {
					break;
				}
				System.out.println(str);
				String[] strAry = str.split(" ");

				if (maxScore < Integer.parseInt(strAry[2])) {
					maxScore = Integer.parseInt(strAry[2]);
					name = strAry[1];
				}
				sum += Integer.parseInt(strAry[2]);
				cnt++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		avg = ((double) sum / cnt++);
		System.out.printf("평균: %.2f\n", avg);
		System.out.printf("최고점수 %d, 학생 %s \n", maxScore, name);

	}
}
