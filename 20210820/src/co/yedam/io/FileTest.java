package co.yedam.io;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		// 폴더생성
//		 createFolder();

		// 파일정보 읽기
//		 fileInfo();

		// 파일삭제
//		 fileDelete();

		// 폴더안의 파일목록
		folderInfo();
	}

	public static void folderInfo() {
		File file = new File("c:/Temp");
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isFile())
				System.out.println(f.getName());
		}

	}

	public static void fileDelete() {
		File file = new File("c:/Temp/sample_copy.jpg");
		file.delete();
		System.out.println("deleted.");
	}

	public static void fileInfo() {
		File file = new File("c:/Temp/sample_orig.jpg");
		System.out.println("파일크기:" + file.length());
		System.out.println("파일경로:" + file.getParent());
		System.out.println("파일이름:" + file.getName());
		System.out.println("실행가능:" + file.canExecute());
	}

	public static void createFolder() {
		File file = new File("c:/Temp/image");
		file.mkdir();
		System.out.println("completed.");
	}
}
