package co.yedam.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BufferTest {

	public static void main(String[] args) {

//		streamToReader();
//		streamToWriter();

//		bufferReader();
		bufferWriter();

	}

	// Reader, Writer 스트림.
	// 입력바이트스트림 > InputStreamReader/ 출력바이트스트림 > OutputStreamWriter:
	public static void streamToReader() {
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		char[] cbuf = new char[100];
		try {
			int len = isr.read(cbuf);

			for (int i = 0; i < len; i++) {
				System.out.print(cbuf[i]);
			}
			System.out.println("end.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			is.close();
			isr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void streamToWriter() {
		OutputStream os = System.out;
		OutputStreamWriter osw = new OutputStreamWriter(os);
//		char[] cbuf = new char[100];

		Scanner scn = new Scanner(System.in);
		System.out.println("입력> ");
		String str = scn.nextLine();
		try {
			osw.write(str + "\n");
			osw.write("end.");
			osw.flush();
			osw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scn.close();
	}

	// BufferedInputStream, BufferedReader/ BufferedOutputStream, BufferedWriter
	public static void bufferReader() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String a = "";
		try {
			a = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(a);

	}

	public static void bufferWriter() {
		OutputStream os = System.out;
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);

		String str = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("c:/temp/addr.txt"));

			while (true) {
				str = br.readLine();
				if (str == null)
					break;
				bw.write(str);
				bw.write("\n");

			}
			br.close();
			bw.flush();
			bw.close();
			osw.close();
			os.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
