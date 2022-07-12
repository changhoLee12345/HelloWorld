package co.yedam.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CharTest {
	public static void main(String[] args) {

		// write1();
		// read1();
		read2();
	}

	// 버퍼를 통해서 파일입력
	public static void read2() {
		try {
			FileReader fr = new FileReader("c:/Temp/addr.txt");
			BufferedReader br = new BufferedReader(fr);
			String s = null;
			while (true) {
				s = br.readLine();
				if (s == null)
					break;
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void read1() {
		try {
			FileReader fr = new FileReader("c:/Temp/addr.txt");
			char[] arr = new char[100];
			while (true) {
				int a = fr.read(arr);
				if (a == -1)
					break;
				for (int i = 0; i < a; i++) {
					System.out.print(arr[i]);
				}
				// char[] -> string
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 키보드 입력(ctrl+z) 받아서 파일에 저장
	public static void write1() {
		try {
			FileWriter fw = new FileWriter("c:/Temp/addr.txt");
			Scanner scanner = new Scanner(System.in);
			System.out.println("입력>");
			String s = null;
			while (true) {
				try {
					s = scanner.nextLine();
				} catch (NoSuchElementException e) {
					break;
				}
				fw.write(s + "\n");
			}
			fw.close();
			System.out.println("생성!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
