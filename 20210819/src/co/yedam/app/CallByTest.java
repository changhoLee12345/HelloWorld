package co.yedam.app;

public class CallByTest {
	public static void main(String[] args) {
		// Call by value(값에 의한 호출)
		int a = 10;
		sub1(a);
		System.out.println(a);

		// Call by value : String, Wrapper 클래스는 객체이지만 메서드의 인수로 사용될 경우 value임
		String b = "hi";
		sub2(b);
		System.out.println(b);

		// Call by reference(참조에 의한 호출)
		Emp c = new Emp();
		c.name = "홍길동";
		sub3(c);
		System.out.print(c.name);
	}

	public static void sub1(int a) {
		a = a * a;
	}

	public static void sub2(String a) {
		a = "hello";
	}

	public static void sub3(Emp a) {
		a.name = "이순신";
	}
}
