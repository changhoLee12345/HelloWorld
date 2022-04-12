package co.edu;

public class OperatorExample3 {
	public static void main(String[] args) {
		// 비교연산자, 논리연산자
		int num1 = 10;
		int num2 = 20;

		if (num1 == num2) {
			System.out.println("두수는 같습니다.");
		}

		if (num1 != num2) {
			System.out.println("두수는 같지 않습니다.");
		}

		if (num1 >= num2) {
			System.out.println(num1 + "이 " + num2 + "보다 큽니다.");
		}

		num1 = 10;
		num2 = 20;
		if ((++num1 % 2 == 0) && (num2++ % 2 == 0)) {
			System.out.println("두수는 짝수.");
		} else {
			System.out.println("두수가 짝수는 아닙니다.");
		}
		System.out.println(num1 + ", " + num2);

		if ((++num1 % 2 == 0) || (num2++ % 2 == 0)) {
			System.out.println("두수중에 하나 짝수.");
		} else {
			System.out.println("두수가 다 홀수입니다.");
		}
		System.out.println(num1 + ", " + num2);

		System.out.println("end of prog");

	}
}
