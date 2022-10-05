package co.yedam.app;

import java.util.ArrayList;

public class ExceptionTest3 {

	public static void main(String[] args) {

		try {
			String data = null;
			sub1(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			String data = "a123";
			sub2(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			ArrayList<String> list = new ArrayList<>();
			sub3(list);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("end===");

	}

	public static void sub3(ArrayList<String> a) throws Exception {
		a.add("aa");
		String b = a.get(1);
	}

	public static void sub2(String d) throws Exception {
		int a = Integer.parseInt(d);
		System.out.println("a=" + a);

	}

	public static void sub1(String d) throws Exception {
		System.out.println(d.length());
	}
}
