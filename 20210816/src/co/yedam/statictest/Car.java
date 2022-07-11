package co.yedam.statictest;

/* 
 * 싱글톤
 */
public class Car {

	static Car instance = new Car();

	static Car getInstance() {
		return instance;
	}

	private String name;
	private int speed; // 조회 가능, 변경 가능

	void print() {
		System.out.println(name + ":" + speed);
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		if (speed < 0)
			speed = 0;
		this.speed = speed;
	}

	public void setName(String name) {
		this.name = name;
	}

}
