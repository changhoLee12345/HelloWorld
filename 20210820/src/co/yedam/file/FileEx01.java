package co.yedam.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student implements Serializable {
	String name;
	int age;

	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

public class FileEx01 {
	static Scanner scn = new Scanner(System.in);
	static String path = "c:/temp/";

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
//		createFile();
//		copy();
//		copyUsingBuffer();
		copyObject();

		long endTime = System.currentTimeMillis();
		System.out.printf("시작시간: %d, 종료시간: %d, duration: %d\n", startTime, endTime, (endTime - startTime));

		System.out.println("end of prog.");
		scn.close();

	} // end of main().

	// 객체 복사.
	static void copyObject() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("hong", 12));
		students.add(new Student("hwang", 22));

		Student s1 = new Student("park", 22);

		try {
			FileOutputStream fos = new FileOutputStream(new File("object.bin"));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(students);

			FileInputStream fis = new FileInputStream(new File("object.bin"));
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<Student> list = (List<Student>) ois.readObject();
			for (Student student : list) {
				System.out.printf("name: %s, age %d \n", student.name, student.age);
			}
			fos.close();oos.close();
			fis.close();ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	// 새로운 파일 생성.
	static void createFile() {
		String dirs = path + "folder/";
		File file;
		file = new File(dirs);
		if (!file.exists())
			file.mkdirs();

		String fileName = "sample.txt";
		file = new File(dirs + fileName);

		OutputStream os;
		try {
			os = new FileOutputStream(file);
//			os.write(97); // a 출력.
			int i = 0;
			while (i++ < 5) {
				System.out.printf("message %d\n", i);
				String msg = scn.nextLine();
				msg += "\n";
				byte[] bytes = msg.getBytes();

				os.write(bytes);
			}
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of createFile()

	// 버퍼를 사용한 파일의 복사.
	static void copyUsingBuffer() {
		String dirs = path + "folder/";
		String fileName = dirs + "sqldeveloper-23.1.0.097.1607-x64.zip";
		String destName = dirs + "copy.zip";

		File fileInfo = new File(fileName);
		if (fileInfo.isFile()) {
			System.out.println(fileInfo.getPath());
		}

		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(destName)));
			int readByte = 0;
			while ((readByte = bis.read()) != -1) {
				bos.write(readByte);
//				System.out.println(readByte);
			}
			bos.flush();
			bis.close();
			bos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 파일의 복사.
	static void copy() {
		String dirs = path + "folder/";

		File file = new File(dirs);
		if (!file.exists())
			file.mkdirs();
		String origName = "1.jpg";
		String targetName = "copy.jpg";

		file = new File(dirs + origName);

		OutputStream os;
		InputStream is;
		try {

			File dest = new File(dirs + targetName);

			is = new FileInputStream(file);
			os = new FileOutputStream(dest);

			int readBit = 0;
			byte[] buf = new byte[100];

			while (readBit != -1) {

//				readBit = is.read();
//				System.out.println(readBit);
//				os.write(readBit);

				readBit = is.read(buf);
				System.out.println(readBit);
				os.write(buf);

			}
			os.flush();

			is.close();
			os.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of copy().

}
