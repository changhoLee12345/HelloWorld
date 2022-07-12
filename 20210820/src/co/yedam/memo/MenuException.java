package co.yedam.memo;

public class MenuException extends Exception {
	int choice;

	public MenuException(int choice) {
		this.choice = choice;
	}

	public void showMessage() {
		System.out.println(choice + " 없는 메뉴입니다.");
	}
}
