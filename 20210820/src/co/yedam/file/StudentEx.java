package co.yedam.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentEx {
	static String fileName = "C:/temp/sample.txt";

	public static void main(String[] args) {
		read2();
		System.out.println("end of prog.");
	}

	public static void write1() {

	}

	public static void read2() {
		try {
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			InputStream is = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(is);
//			BufferedReader br = new BufferedReader(isr);
//			br.readLine();

			char[] buf = new char[5];
			int readBuf = 0;
			int sum = 0, maxScore = 0;
			String name = "", str = "";

			StringBuilder sb = new StringBuilder();
			while ((readBuf = isr.read(buf)) != -1) {
//				for (int i = 0; i < readBuf; i++) {
//					System.out.print((char) buf[i]);
//				}
//				System.out.print("\n");
				sb.append(buf, 0, readBuf);
			}
			String result = sb.toString();
			System.out.println(result);

			is.close();
			isr.close();
//			System.out.println("maxScore: " + maxScore);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void read1() {
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
