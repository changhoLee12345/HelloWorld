package co.yedam.app;

import java.util.ArrayList;

public class ExceptionTest {

	public static void main(String[] args) {

		String data = null;
		sub1(data);

		data = "a123";
		sub2(data);

		ArrayList<String> list = new ArrayList<>();
		sub3(list);
		
		System.out.println("end===");

	}
	
	public static void sub3(ArrayList<String> a) {
		try {
			a.add("aa");
			String b = a.get(1);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}
	

	public static void sub2(String d) {
		
		try {
			int a = Integer.parseInt(d);
			System.out.println("a=" + a);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
	}

	public static void sub1(String d) {
		try {
			System.out.println(d.length());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
}
