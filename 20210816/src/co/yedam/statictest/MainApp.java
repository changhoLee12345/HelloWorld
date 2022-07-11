package co.yedam.statictest;

/*
 * static
 * 같은 클래스타입으로 생성된 객체들이 공유하는 필드
 * 참조변수.  아니고 클래스이름.필드 or  .메서드
 * 객체생성하지 않고 사용가능
 * 클래스파일이 메모리로 로딩될때 스태틱 필드가 초기화
 */
public class MainApp {

	public static void main(String[] args) {
		System.out.println(Calc.plus(10, 20));
		System.out.println(Calc.minus(20, 10));
		System.out.println(Calc.pi);

		Calc calc1 = new Calc();
		calc1.color = "red";
		Calc.pi = 3.5;

		Calc calc2 = new Calc();
		calc2.color = "blue";
		Calc.pi = 3.4;

		System.out.println(calc1.color + ":" + Calc.pi);
		System.out.println(calc2.color + ":" + Calc.pi);
	}

}
