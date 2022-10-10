package co.yedam.memo.except;

public class MenuException extends Exception {
	private static final long serialVersionUID = 1L;

	int choice;

	public MenuException(int choice) {
		this.choice = choice;
	}

	public void showMessage() {
		System.out.println(choice + "는 없는 메뉴입니다.");
	}
}
