package co.edu.condition;

public class CondExample {
	public static void main(String[] args) {
		// 임의 값: Math.random()
		// 51 ~ 100 까지의 임의 값.
		int randomVal = (int) (Math.random() * 50) + 51;
		System.out.println(randomVal);
		randomVal /= 10; // randomValue = randomVal / 10;
		// 100 ~ 90 => A학점.
		// ~ 80 => B학점.
		// ~ 70 => C학점.
		// ~ 60 => D학점.
		// 이하 F학점.
		switch(randomVal) {
		case 10:
		case 9: System.out.println("A학점임.");break;
		case 8: System.out.println("B학점임.");break;
		case 7: System.out.println("C학점임.");break;
		case 6: System.out.println("D학점임.");break;
		default:
			System.out.println("F학점임.");
		}
	}
}
