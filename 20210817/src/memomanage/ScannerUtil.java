package memomanage;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ScannerUtil {

	static Scanner scanner = new Scanner(System.in);

	public static int readInt() {
		int result = 0;
		while (true) {
			try {
				String temp = scanner.next();
				result = Integer.parseInt(temp);
				break;
			} catch (Exception e) {
				System.out.println("숫자 형식이 아닙니다.");
			}
		}
		return result;
	}

	// 숫자입력
	public static int readInt(String prompt) {
		System.out.print(prompt);
		System.out.print(">");
		return readInt();
	}

	// 날짜입력
	public static String readDate() {
		String result = "";
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		do {
			try {
				result = scanner.next();
				df.parse(result.trim());
				break;
			} catch (Exception e) {
				System.out.println("날짜 형식이 아닙니다.(yyyyMMdd)");
			}
		} while (true);
		return result;
	}

	public static String readDate(String prompt) {
		System.out.print(prompt);
		System.out.print(">");
		return readDate();
	}

	public static String readStr(String prompt) {
		System.out.print(prompt);
		System.out.print(">");
		return readStr();
	}

	// 한줄입력
	public static String readStr() {
		String result = "";
		try {
			result = scanner.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 여러줄입력
	public static String readMultiLine() {
		StringBuffer result = new StringBuffer();
		try {
			String a = "";
			while (true) {
				a = scanner.next();
				if (a == null || a.trim().equals(".end")) {
					break;
				}
				result.append(a).append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

}
