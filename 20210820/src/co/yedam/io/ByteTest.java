package co.yedam.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ByteTest {

	public static void main(String[] args) {
		write1();
//		read1();
//		try {
//			write2();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		read2();
//		filecopy();
	}

	public static void filecopy() {
		try {
			FileInputStream fis = new FileInputStream(new File("c:\\Temp", "sample_orig.jpg"));
			FileOutputStream fos = new FileOutputStream("c:\\Temp\\sample_copy.jpg");
			byte[] arr = new byte[100];
			while (true) {
				int a = fis.read(arr);
				if (a == -1)
					break;
				fos.write(arr, 0, a); // 배열의 크기만큼 읽어 들인값을 반환한다.
			}
			fis.close();
			fos.close();
			System.out.println("생성.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void read2() {
		try {
			FileInputStream fis = new FileInputStream("c:/Temp/data2.dat");
			byte[] arr = new byte[2]; // 3 바이트
			while (true) {
				// 배열일 경우에는 버퍼에 읽어들인 크기를 반환.
				int a = fis.read(arr);

				// 반환값이 -1이면 파일의 끝부분.
				if (a == -1)
					break;

				for (int i = 0; i < a; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.println();
			}
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void read1() {
		try {
			FileInputStream fis = new FileInputStream("c:/Temp/data1.dat");
			while (true) {
				int a = fis.read();
				if (a == -1)
					break;
				System.out.println(a);
			}
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 바이트 배열 출력
	public static void write2() throws Exception {
		byte[] arr = new byte[] { 10, 20, 30 };
		FileOutputStream fos = new FileOutputStream("c:/Temp/data2.dat");
		fos.write(arr);
		fos.flush();
		fos.close();
		System.out.println("생성");
	}

	// 1바이트 출력
	public static void write1() {
		try {
			OutputStream fos = new FileOutputStream("c:/Temp/data1.dat");
			byte a = 10;
			byte b = 20;
			fos.write(a);
			fos.write(b);
			fos.flush();
			fos.close();
			System.out.println("생성");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
