package co.yedam.fly;

public class Superman extends Human {
	// run() 오버라이딩
	public void run() {
		System.out.println("지구를 구한다");
	}

	public void takeOff() {
		System.out.println("슈퍼맨 이륙 - 손을 위로 들어올리고");
	}

	public void fly() {
		System.out.println("슈퍼맨 비행");
	}

	public void land() {
		System.out.println("슈퍼맨 착륙");
	}
}
