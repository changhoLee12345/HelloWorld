package com.yedam.app;

/* 
 * 1. 객체화
 * 2. 타입변환
 * int -> long  (int)
 * 객체간은 부모와 자식  (부모)
 *  String -> int, long, date
 */
public class WrapperTest {
	public static void main(String[] args) {

		// 1.객체와 int <-> Integer
		int a = 10;
		Integer b = Integer.valueOf(a); // boxing
		b = a; // auto boxing

		a = b; // auto unboxing
		a = b.intValue(); // unboxing

		// 2. 타입변환 int -> String
		String c = Integer.toString(a);

		// String -> int
		a = Integer.parseInt(c);

		// String <- double
		double d = 10.5;
		c = Double.toString(d);
		c = String.valueOf(d);

		// String -> double
		d = Double.parseDouble(c);

		// 3. 진수변환
		int e = 15;
		String r1 = Integer.toBinaryString(e);
		String r2 = Integer.toOctalString(e);
		System.out.println(r1 + ":" + r2);

		// 4.
		Integer i3 = new Integer(128);
		byte b3 = i3.byteValue();
//		b3 = (byte) i3;
		System.out.println("b3: " + b3);

		((Integer) 3).intValue();
		Byte.valueOf("3").byteValue();

	}
}
