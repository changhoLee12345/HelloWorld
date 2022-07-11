package co.yedam.inheritence;

public class DmbCellPhone extends CellPhone {
	private int channel;

	public DmbCellPhone() {
		super(); // 부모의 생성자
	             // 부모생성자 반드시 호출
	}

	public DmbCellPhone(String model, String color, int channel) {
		super(model, color); // super()
		this.channel = channel;
	}

	public void turnOn() {
		System.out.println("dmb on");
	}

	public void turnOff() {
		System.out.println("dmb off");
	}

	public void changeChannel() {
		System.out.println("change channel");
	}
}
