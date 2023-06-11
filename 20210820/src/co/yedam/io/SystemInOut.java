package co.yedam.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SystemInOut {
	public static void main(String[] args) {
		try {
			out();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void out() throws IOException {
		OutputStream os = System.out;
		for (byte b = 48; b < 58; b++) {
			os.write(b);
		}

		os.write(10);
		for (byte b = 97; b < 123; b++) {
			os.write(b);
		}
		os.write(10);

		String hangul = "가나다라마바사";
		byte[] hangulBytes = hangul.getBytes();
		os.write(hangulBytes);

		os.flush();
	}

	public static void in() throws IOException {
		InputStream is = System.in;
		byte[] datas = new byte[100];

		System.out.println("이름:");
		int nameByte = is.read(datas);
		String name = new String(datas, 0, nameByte - 2);
		System.out.println("하고싶은말:");
		int commentBytes = is.read(datas);
		String comment = new String(datas, 0, commentBytes - 2);
		System.out.printf("%s, %s", name, comment);

	}
}
