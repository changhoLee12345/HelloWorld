package co.yedam.fly;

public class Bird extends Animal {

	@Override
	public void run() {
		System.out.println("주로 날아다닌다");
	}

	@Override
	public void eat() {
		System.out.println("벌레를 먹는다");
	}

	public void takeOff() {
		System.out.println("Bird 이륙");
	}

	public void fly() {
		System.out.println("Bird 비행");
	}

	public void land() {
		System.out.println("Bird 착륙");
	}

	public void layEggs() {
		System.out.println("Bird 알을 낳다");
	}
}
