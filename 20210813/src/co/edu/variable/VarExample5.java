package co.edu.variable;

public class VarExample5 {
	public static void main(String[] args) {
		int val = 2147483647; // 4 * 1byte => 1byte = 8 * bit; 값이 on/off

		System.out.println(Integer.MAX_VALUE);

		long val2 = 2147483648L;
		long val3 = 10; // 10 -> long 변환(promotion:자동형변환).

		int val4 = (int) 10L; // long -> int (casting:강제형변환).

		int result = (int) (10000000000000000L / 5); //

		long val5 = 10000000000L;
		long val6 = 10L;

		result = (int) (val5 - val6); // casting(강제형변환);
		System.out.println(result);

		char charLit = 97; // 0 ~ 65535 까지의 정수값에
		charLit = 44032;
		System.out.println(charLit++);
		System.out.println(charLit++);
		System.out.println(charLit++);
		System.out.println(charLit++);
		System.out.println(charLit++);
		System.out.println(charLit++);
		System.out.println(charLit++);
		System.out.println(charLit++);
		System.out.println(charLit++);
		System.out.println(charLit++);

	}
}
