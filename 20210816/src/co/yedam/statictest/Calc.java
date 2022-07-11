package co.yedam.statictest;

/*
 *final = 상수 .(초기화되고나면 변경불가)
 * 초기화는 필드선언시 or 생성자
 */
public class Calc {

	final String color;
	static final double pi = 3.14;

	Calc() {
		this.color = "blue";
	}

	static int plus(int x, int y) {
		return x + y;
	}

	static int minus(int x, int y) {
		return x - y;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
