package co.yedam.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class FileEx01 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		String dirs = "c:/temp/folder1";
		String files = dirs + "/sample2.txt";

		dirs = "folder1/";
		files = dirs + "sample.txt";
		File file = new File(dirs);
		if (!file.exists())
			file.mkdirs();

		OutputStream os;
		try {
			file = new File(files);
			os = new FileOutputStream(file);
//			os.write(97);
			int i = 0;
			while (i++ < 5) {
				System.out.printf("message %d\n", i);
				String msg = scn.nextLine();
				msg += "\n";
				byte[] bytes = msg.getBytes();
//				for(byte bt : bytes) {
//					System.out.println(bt);
//				}
				os.write(bytes);
			}
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		scn.close();
		System.out.println("end of prog.");

	}
}
