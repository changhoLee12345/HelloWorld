package co.yedam.enums;

public enum Menu {
	ADD(1), MODIFY(2), EXIT(3);

	private int val;

	private Menu(int val) {
		this.val = val;
	}

	boolean equal(int val) {
		return this.val == val;
	}
}
