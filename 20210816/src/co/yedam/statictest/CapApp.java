package co.yedam.statictest;

public class CapApp {
	public static void main(String[] args) {
		Car car1 = new Car(); // Car.getInstance();
		Car car2 = new Car(); // Car.getInstance();

		System.out.println(car1 == car2);

		// car1.speed = -100;
		car1.setSpeed(-100);
		// System.out.println(car1.speed);
		System.out.println(car1.getSpeed());
	}
}
